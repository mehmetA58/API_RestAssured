package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class HomeWork {
    //https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request gonderdigimizde donen Response'un,
    //        status code'unun 200,
    //        ve content type'inin application/json; charset=utf-8,
    //        ve Server isimli Header'in degerinin Cowboy,
    //        ve status Line'in HTTP/1.1 200 OK
    //        ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
@Test
   public void test(){
    String url="https://restful-booker.herokuapp.com/booking/10";
    //for getRequest;
    Response response= given().accept("application/json").when().get(url);
    response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
//response.prettyPrint();
    System.out.println(response.getHeaders());
    System.out.println("******************************");
    String headerName=response.header("Server");
    System.out.println("server ismi :"+headerName);
    System.out.println("******************************");

    long responseTime=response.getTimeIn(TimeUnit.SECONDS);
    System.out.println(responseTime);
    Assert.assertTrue(responseTime<5);
}

}
