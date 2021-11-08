package com.techproed.day04;

import io.restassured.response.Response;
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
      Response response= given().accept("application/json").when().get(url);
    //4-actual result oluştur
    System.out.println(response.prettyPrint());
    // 5-doğrulama yap(assertion)

}

}
