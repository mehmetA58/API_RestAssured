package com.techproed.day06;

import com.techproed.testBase.DummyTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest09 extends DummyTestBase {

@Test
public void test01(){
    //http://dummy.restapiexample.com/api/v1/employees
    //url ine bir istek gönderildiğinde,
    //status kodun 200,
    //gelen body de,
    //5. çalışanın isminin "Airi Satou" olduğunu ,
    //6. çalışanın maaşının "372000" olduğunu ,
    //Toplam 24 tane çalışan olduğunu,
    //"Rhona Davidson" ın employee lerden biri olduğunu
    //"21", "23", "61" yaşlarında employeeler olduğunu test edin
    spec03.pathParams("parametre","employees");
    Response response=given()
            .spec(spec03)
            .when()
            .get("/{parametre}");
    response.prettyPrint();
    response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
    Assert.assertEquals("Airi Satou",response.jsonPath().getString("data[4].employee_name"));
    Assert.assertEquals(372000,response.jsonPath().getString("data[5].employee_salary"));
    Assert.assertTrue(response.jsonPath().getList("data.employee_name").contains("Rhona Davidson"));
    Assert.assertTrue(response.jsonPath().getList("data.employees_age").contains("21||23||61"));

}
}
