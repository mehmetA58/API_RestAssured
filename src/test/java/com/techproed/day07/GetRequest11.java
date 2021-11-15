package com.techproed.day07;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest11 extends JsonPlaceHolderTestBase {
    //https://jsonplaceholder.typicode.com/todos/2 url ‘ine istek gönderildiğinde,
    // Dönen response un
    // Status kodunun 200, dönen body de,
    //       "completed": değerinin false
    //       "title”: değerinin “quis ut nam facilis et officia qui”
    //       "userId" sinin 1 ve header değerlerinden
    // "Via" değerinin “1.1 vegur” ve
    //       "Server" değerinin “cloudflare” olduğunu test edin…
    @Test
    public void test(){
        spec01.pathParams("parametre1","todos",
                "parametre2",2);

        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("completed",false);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("userId",1);
        expectedData.put("Via","1.1 vegur");
        expectedData.put("Server","cloudflare");
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
