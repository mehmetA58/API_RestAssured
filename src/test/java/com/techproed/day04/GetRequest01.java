package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
//https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde donecek cevap(response) icin
//HTTP status kodunun 200
//Content Type'in Json
//Ve Status Line'in HTTP/1.1 200 OK
//Oldugunu test edin
@Test
public void test01() {
    //1-api testi yaparken ilk olarak url(endpoint)belirlenmeli.
    String url = "https://restful-booker.herokuapp.com/booking/3";
    //2-beklenen sonuç(expected result) oluşturulur.

    //bu case de benden body dogrulaması istemedigi için şimdilik beklenen sonuç oluşturmuyoruz

    //3-request gönder
      Response response= given().
              accept("application/json").
              when().
              get(url);
    response.prettyPrint();
    //4-actual result oluştur
    //response body ile ilgili işlem yapmayacağımız için şimdi oluşturmayacağız.

    // 5-doğrulama yap(assertion)

    System.out.println("StatusCode() = " + response.getStatusCode());
    System.out.println("ContentType() = " + response.getContentType());
    System.out.println("StatusLine() = " + response.getStatusLine());
    System.out.println("Headers() = " + response.getHeaders());
//    Assert.assertEquals("Beklenen status code actual result'a esit degildir. TEST FAILED ",200,response.getStatusCode());
//
//// status code bize int olarak geldigi icin 200 yazdik. expected kismi bize task olarak verildi.
//// Actual kismibi response objesinden elde ettik.
//    Assert.assertEquals("application/json; charset=utf-8",response.getContentType());
//    Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());

    response.then().
            assertThat().
            statusCode(200).
            contentType(ContentType.JSON).
            statusLine("HTTP/1.1 200 OK");


}

}
