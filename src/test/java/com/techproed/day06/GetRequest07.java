package com.techproed.day06;

import com.techproed.testBase.HerokuAppTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest07 extends HerokuAppTestBase {
    /*
     https://restful-booker.herokuapp.com/booking/5 url’ine bir request yolladigimda
     HTTP Status Code’unun 200
     ve response content type’inin “application/JSON” oldugunu
     ve response body’sinin asagidaki gibi oldugunu test edin
     {"firstname": Sally,
             "lastname": "Smith",
             "totalprice": 789,
             "depositpaid": false,
             "bookingdates": {
                "checkin": "2017-12-11",
                 "checkout":"2020-02-20"
                  }
     }
 */
    @Test
    public void test01(){
        spec02.pathParams("parametre1","booking",
                "parametre2",2);
        Response response=given().
                accept("application/json").
                spec(spec02).
                when().
                get("/{parametre1}/{parametre2}");
        response.prettyPrint();
        JsonPath jsonPath=response.jsonPath();
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
        // Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("Mary",jsonPath.getString("firstname"));
        Assert.assertEquals("Jones",jsonPath.getString("lastname"));
        Assert.assertEquals(741,jsonPath.getInt("totalprice"));
        Assert.assertEquals(false,jsonPath.getBoolean("depositpaid"));
        Assert.assertEquals("2015-09-10",jsonPath.getString("bookingdates.checkin"));
        Assert.assertEquals("2020-11-03",jsonPath.getString("bookingdates.checkout"));
    }
}
