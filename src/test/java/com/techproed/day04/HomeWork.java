package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class HomeWork {
    // url'ine bir GET request gonderdigimizde donen Response'un,
    //        status code'unun 200,
    //        ve content type'inin "application/json"; charset=utf-8,
    //        ve Server isimli Header'in degerinin Cowboy,
    //        ve status Line'in HTTP/1.1 200 OK
    //        ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
@Test
   public void test(){
    String url="https://restful-booker.herokuapp.com/booking/10";
    Response response=given().accept("application/json").when().get(url);
    response.prettyPrint();
    response.then().assertThat().
            statusCode(200).
            contentType("application/json").
            header("Server", equalTo("Cowboy")).
            statusLine("HTTP/1.1 200 OK");
    response.then().assertThat().time(lessThan((long)5000));

}

}
