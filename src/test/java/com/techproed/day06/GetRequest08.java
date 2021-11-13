package com.techproed.day06;

import com.techproed.testBase.DummyTestBase;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest08 extends DummyTestBase {
    //http://dummy.restapiexample.com/api/v1/employees url’inde bulunan
    //   1) Butun calisanlarin isimlerini consola yazdıralim
    //   2) 3. calisan kisinin ismini konsola yazdıralim
    //   3) Ilk 5 calisanin adini konsola yazdiralim
    //   4) En son calisanin adini konsola yazdiralim

    @Test
    public void test01(){
     spec03.pathParam("parametre","employees");
        Response response=given().
                spec(spec03).
                when().
                get("/{parametre}");
        response.prettyPrint();
        System.out.println(response.jsonPath().getString("data.employee_name"));

        System.out.println("3. isim : "+response.jsonPath().getString("data[2].employee_name"));
        Assert.assertEquals("Ashton Cox",response.jsonPath().getString("data[2].employee_name"));
        System.out.println(response.jsonPath().getString("data.employee_name[0,1,2,3,4]"));

        System.out.println(response.jsonPath().getString("data.employee_name[-1]"));
        Assert.assertEquals("Doris Wilder",response.jsonPath().getString("data.employee_name[-1]"));




    }
}
