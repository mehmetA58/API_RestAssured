package com.techproed.day11;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class PostRequest03 extends JsonPlaceHolderTestBase {

    /*https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
     }
     "userId": 55,
     "title": "Tidy your room",
     "completed": false
   }
Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
   {
     "userId": 55,
     "title": "Tidy your room",
     "completed": false,
     "id": …
    }*/
    @Test
    public void test(){
        spec01.pathParam("first","todos");

        JsonPlaceHolderTestData requestData= new JsonPlaceHolderTestData();

        JSONObject expectedRequestData=requestData.setUpPostData();
        System.out.println(expectedRequestData);
        Response response=given()
                .contentType(ContentType.JSON)
                .spec(spec01)
                .auth().basic("admin","password123")
                .body(expectedRequestData.toString())
                .when()
                .post("/{first}");
        response.prettyPrint();

        response.then()
                .assertThat().statusCode(expectedRequestData.getInt("statusCode"))
                .body("completed",equalTo(expectedRequestData.getBoolean("completed")),
                        "title",equalTo(expectedRequestData.getString("title")),
                        "userId",equalTo(expectedRequestData.getInt("userId")));


        //JsonPath ile

        JsonPath json=response.jsonPath();
        assertEquals(expectedRequestData.getInt("statusCode"),response.getStatusCode());
        assertEquals(expectedRequestData.getInt("userId"),json.getInt("userId"));
        assertEquals(expectedRequestData.getString("title"),json.getString("title"));
        assertEquals(expectedRequestData.getBoolean("completed"),json.getBoolean("completed"));

        // de serialization
        HashMap<String,Object> actualData=response.as(HashMap.class);

        assertEquals(expectedRequestData.getInt("userId"),
                actualData.get("userId"));

        assertEquals(expectedRequestData.getString("title"),
                actualData.get("title"));

        assertEquals(expectedRequestData.getBoolean("completed"),
                actualData.get("completed"));
    }
}
