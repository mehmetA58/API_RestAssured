package com.techproed.day07;

import com.techproed.testBase.DummyTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class HomeWork extends DummyTestBase {
    //http://dummy.restapiexample.com/api/v1/employee/3 url'ine bir GET request gonderdigimizde
    //donen response'un asagidaki gibi oldugunu test edin.
    //    Response Body
    //    {
    //        "status":"success",
    //        "data":{
    //                "id":3,
    //                "employee_name":"Ashton Cox",
    //                "employee_salary":86000,
    //                "employee_age":66,
    //                "profile_image":""
    //                },
    //        "message":"Successfully! Record has been fetched."
    //    }
    @Test
    public void test(){
        spec03.pathParams("parametre1","employee","parametre2",3);


        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("status", "success");
        expectedData.put("statusCode", 200);
        expectedData.put("id", 3);
        expectedData.put("employee_salary", 86000);
        expectedData.put("employee_age", 66);
        expectedData.put("profile_image", "");
        expectedData.put("message", "Successfully! Record has been fetched.");
        System.out.println(expectedData);

        Response response=given().
                accept("application/json").
                spec(spec03).
                when().
                get("/{parametre1}/{parametre2}");
        response.prettyPrint();
        JsonPath jsonPath=response.jsonPath();
        //Assert.assertEquals(200,response.getStatusCode());
        response
                .then()
                .assertThat()
                .header("status",equalTo(expectedData.get("status")))
                .body("id",equalTo(expectedData.get("id")))
                .body("employee_salary",equalTo(expectedData.get("employee_salary")))
                .body("employee_age",equalTo(expectedData.get("employee_age")))
                .body("profile_image",equalTo(expectedData.get("profile_image")))
                .body("message",equalTo(expectedData.get("message")));
        Assert.assertEquals(expectedData.get("status"),jsonPath.getString("status"));
        Assert.assertEquals(expectedData.get("statusCode"),jsonPath.getInt("statusCode"));
        Assert.assertEquals(expectedData.get("id"),jsonPath.getInt("id"));
        Assert.assertEquals(expectedData.get("employee_salary"),jsonPath.getInt("employee_salary"));
        Assert.assertEquals(expectedData.get("employee_age"),jsonPath.getInt("employee_age"));
        Assert.assertEquals(expectedData.get("profile_image"),jsonPath.getString("profile_image"));
        Assert.assertEquals(expectedData.get("message"),jsonPath.getString("message"));

    }
}
