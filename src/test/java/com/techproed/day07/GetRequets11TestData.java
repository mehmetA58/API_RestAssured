package com.techproed.day07;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testData.JsonPlaceHolderTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequets11TestData extends JsonPlaceHolderTestBase {
    @Test
    public void test() {

        spec01.pathParams("parametre1","todos",
                "parametre2",2);

        JsonPlaceHolderTestData jsonPlaceHolderTestData=new JsonPlaceHolderTestData();
        HashMap<String,Object>expectedData= (HashMap<String, Object>) jsonPlaceHolderTestData.setupTestData();
        System.out.println(expectedData);


        Response response=given().
                accept("application/json").
                spec(spec01).
                when().
                get("/{parametre1}/{parametre2}");
        response.prettyPrint();
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(200,response.getStatusCode());

        // response.then().assertThat().statusCode((int)expectedData.get("statusCode"));
        response
                .then()
                .assertThat()
                .headers("Via",equalTo(expectedData.get("Via")),"Server",equalTo(expectedData.get("Server")))
                .body("userId",equalTo(expectedData.get("userId")))
                .body("title",equalTo(expectedData.get("title")))
                .body("completed",equalTo(expectedData.get("completed")));

        Assert.assertEquals(expectedData.get("Via"),response.getHeader("Via"));
        Assert.assertEquals(expectedData.get("Server"),response.getHeader("Server"));
        Assert.assertEquals(expectedData.get("userId"),jsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.get("title"),jsonPath.getString("title"));
        Assert.assertEquals(expectedData.get("completed"),jsonPath.getBoolean("completed"));





    }
}

