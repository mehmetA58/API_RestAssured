package com.techproed.day14;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.utilities.JsonUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequestWithObjectMapper01 extends JsonPlaceHolderTestBase {
    /*GetRequestWithObjectMapper01:
 https://jsonplaceholder.typicode.com/todos/198 url’ine bir get request gönderildiğinde,
Dönen response ‘un status kodunun 200 ve body kısmının
{
   "userId": 10,
   "id": 198,
   "title": "quis eius est sint explicabo",
   "completed": true
}
Olduğunu Object Mapper kullanarak test edin*/

    @Test
    public void test(){
     spec01.pathParams("first","todos","second",198);
     String jsonData="{\n" +
             "\"userId\": 10,\n" +
             "\"id\": 198,\n" +
             "\"title\": \"quis eius est sint explicabo\",\n" +
             "\"completed\": true\n" +
             "}";
       Map<String,Override>expectedData= JsonUtil.convertJsonToJava(jsonData, Map.class);
        System.out.println(expectedData);

        Response response=given()
                .contentType(ContentType.JSON)
                .spec(spec01).when().get("/{first}/{second}");
        response.prettyPrint();
        Map<String,Object>actualData=JsonUtil.convertJsonToJava(response.asString(),Map.class);
        System.out.println(actualData);
    }
}
