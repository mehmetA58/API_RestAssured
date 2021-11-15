package com.techproed.day06;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HomeWork {
    /*
		1) Create a class and name it as you wish :)
		2) When
		     I send a GET Request to https://jsonplaceholder.typicode.com/todos
		   Then
			 HTTP Status code should be "200"
			 And Content type should be in "JSON" format
			 And there should be 200 "title"
			 And "dignissimos quo nobis earum saepe" should be one of the "title"s
			 And 111, 121, and 131 should be among the "id"s
			 And 4th title is "et porro tempora"
			 And last title is "ipsam aperiam voluptates qui"
    */
    @Test
    public void test1(){
        String url="https://jsonplaceholder.typicode.com/todos";
        Response response=given().
                accept("application/json").
                when().
                get(url);
        response.prettyPrint();

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).body("title[3]", Matchers.equalTo("et porro tempora"))
                        .body("title[-1]",Matchers.equalTo("ipsam aperiam voluptates qui"));

        Assert.assertEquals(response.jsonPath().getList("userId").size(),200);
        Assert.assertTrue(response.jsonPath().getList("title").contains("dignissimos quo nobis earum saepe"));
        Assert.assertTrue(response.jsonPath().getList("id").contains(111));
        Assert.assertTrue(response.jsonPath().getList("id").contains(121));
        Assert.assertTrue(response.jsonPath().getList("id").contains(131));

    }
}
