package com.techproed.day09;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class GetRequest13MatcherClass extends DummyTestBase{

    /* http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
     Status kodun 200 olduğunu,
     5. Çalışan isminin "Airi Satou" olduğunu ,  çalışan sayısının 24 olduğunu,
     Sondan 2. çalışanın maaşının 106450 olduğunu
     40,21 ve 19 yaslarında çalışanlar olup olmadığını
     11. Çalışan bilgilerinin
       {
      “id”:”11”
      "employee_name": "Jena Gaines",
     "employee_salary": "90560",
     "employee_age": "30",
     "profile_image": "" }
     } gibi olduğunu test edin./*

     */
    @Test
    public void test() {

        spec03.pathParam("parametre", "employees");
        Response response = given().
                accept("application/json").
                spec(spec03).
                when().
                get("/{parametre}");
        response.prettyPrint();
        DummyTestData dummyTestData=new DummyTestData();
        HashMap<String,Object> expectedDataMap= (HashMap<String, Object>)dummyTestData.setupTestData();
        System.out.println(expectedDataMap);
        response.then().assertThat()
                .body("data[4].employee_name",equalTo(expectedDataMap.get("besinciCalisan")),
                        "data.id",hasSize((Integer) expectedDataMap.get("calisanSayısı")),
                        "data[-2].employee_salary",equalTo(expectedDataMap.get("sondan2calianMaasi")),
                        "data.employee_age",hasItems(((List)expectedDataMap.get("arananYaslari")).get(0)),
                        "data.employee_age",hasItems(((List)expectedDataMap.get("arananYaslari")).get(1)),
                        "data.employee_age",hasItems(((List)expectedDataMap.get("arananYaslari")).get(2)),
                                        "data[10].employee_name",equalTo(((Map)expectedDataMap.get("onBirinciCalisan")).get("employee_name")),
                                        "data[10].employee_age",equalTo(((Map)expectedDataMap.get("onBirinciCalisan")).get("employee_age")),
                                        "data[10].employee_salary",equalTo(((Map)expectedDataMap.get("onBirinciCalisan")).get("employee_salary")),
                                        "data[10].profile_image",equalTo(((Map)expectedDataMap.get("onBirinciCalisan")).get("profile_image")));




    }
}
