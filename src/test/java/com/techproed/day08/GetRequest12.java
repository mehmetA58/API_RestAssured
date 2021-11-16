package com.techproed.day08;

import com.techproed.testBase.HerokuAppTestBase;
import com.techproed.testData.HerokuappTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest12 extends HerokuAppTestBase {
    @Test
    public void test(){
        //https://restful-booker.herokuapp.com/booking/1 url ine bir istek gönderildiğinde
        // dönen response body nin
        //  {
        //   "firstname": "Eric",
        //   "lastname": "Smith",
        //   "totalprice": 555,
        //   "depositpaid": false,
        //   "bookingdates": {
        //       "checkin": "2016-09-09",
        //       "checkout": "2017-09-21"
        //    }
        //} gibi olduğunu test edin

        spec02.pathParams("parametre1","booking",
                "parametre2",1);


        HerokuappTestData herokuappTestData=new HerokuappTestData();
        HashMap<String,Object> expectedData= (HashMap<String, Object>) herokuappTestData.setUpTestData();
        System.out.println(expectedData);
        Response response=given().
                accept("application/json").
                spec(spec02).
                when().
                get("/{parametre1}/{parametre2}");
        response.prettyPrint();

//        HashMap<String,Object> actualData=response.as(HashMap.class);
//        System.out.println(actualData);
//        Assert.assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
//        Assert.assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
//        Assert.assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
//        Assert.assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
//        Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
//        Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));
JsonPath jsonPath=response.jsonPath();
Assert.assertEquals(expectedData.get("firstname"),jsonPath.getString("firstname"));
Assert.assertEquals(expectedData.get("lastname"),jsonPath.getString("lastname"));
Assert.assertEquals(expectedData.get("totalprice"),jsonPath.getInt("totalprice"));
        Assert.assertEquals(expectedData.get("depositpaid"), jsonPath.getBoolean("depositpaid"));
        Assert.assertEquals(((Map) expectedData.get("bookingdates")).get("checkin")
                , jsonPath.getString("bookingdates.checkin"));
        Assert.assertEquals(((Map) expectedData.get("bookingdates")).get("checkout")
                , jsonPath.getString("bookingdates.checkout"));



    }
}
