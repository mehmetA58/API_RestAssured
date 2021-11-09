package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.internal.http.HttpResponseDecorator;
import io.restassured.internal.http.HttpResponseException;
import io.restassured.response.Response;
import org.junit.Assert.*;
import org.junit.Test;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class GetRequest02 {
    /*
   https://restful-booker.herokuapp.com/booking url'ine
   accept type'i "application/json" olan GET request'i yolladigimda
   gelen response'un
   status kodunun 200
   content type'inin "application/json" oldugunu test edin

    */
    @Test
    public void test() {
        String url = "https://restful-booker.herokuapp.com/booking";
        Response response = given().
                accept("application/json").
                when().
                get(url);
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
    }
    @Test
    /*
       https://restful-booker.herokuapp.com/booking/1001 url'ine
accept type'i "application/json" olan GET request'i yolladigimda
gelen response'un
status kodunun 404 oldugunu
ve Response body'sinin "Not Found" icerdigini
ve Response body'sinin "API" icermedigini test edin
     */
    public void test02(){
        String url1="https://restful-booker.herokuapp.com/booking/1001";

        try {
            Response  response=given().accept("application/json").when().get(url1);

        }catch (Throwable e){
            HttpResponseDecorator response=  ((HttpResponseException)e).getResponse();

            assertTrue(response.getStatus() == 404);

        }
    }





}
