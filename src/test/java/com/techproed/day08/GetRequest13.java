package com.techproed.day08;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class GetRequest13 extends DummyTestBase {

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
    public void test(){
        spec03.pathParam("parametre","employees");
        Response response=given().
                accept("application/json").
                spec(spec03).
                when().
                get("/{parametre}");
        response.prettyPrint();
        DummyTestData dummyTestData=new DummyTestData();



        HashMap<String,Object> expectedDataMap= (HashMap<String, Object>)dummyTestData.setupTestData();
        System.out.println(expectedDataMap);

        //De Serialization işlemi

        HashMap<String,Object>actualData=response.as(HashMap.class);
        System.out.println(actualData);
        //Assert.assertEquals(expectedDataMap.get("statusCode"),response.getStatusCode());

        //5. Çalışan isminin "Airi Satou" olduğunu
        Assert.assertEquals(expectedDataMap.get("besinciCalisan"),((Map)((List)actualData.get("data")).get(4)).get("employee_name"));

        //çalışan sayısının 24 olduğunu
        Assert.assertEquals(expectedDataMap.get("calisanSayısı"),((List) actualData.get("data")).size());

         //Sondan 2. çalışanın maaşının 106450 olduğunu
        int datasize=((List)actualData.get("data")).size();
        Assert.assertEquals(expectedDataMap.get("sondan2calianMaasi"),((Map)((List)actualData.get("data")).get(datasize-2)).get("employee_salary"));

        //40,21 ve 19 yaslarında çalışanlar olup olmadığını
        List<Integer>age=new ArrayList<>();
        for (int i = 0; i <datasize ; i++) {
            age.add((Integer)((Map)((List) actualData.get("data")).get(i)).get("employee_age"));
        }
        Assert.assertTrue(age.containsAll((Collection) expectedDataMap.get("arananYaslari")));

        // 11. Çalışan bilgilerinin
        Assert.assertEquals(expectedDataMap.get("onBirinciCalisan"),((List<?>) actualData.get("data")).get(10));

        Assert.assertEquals(((Map)expectedDataMap.get("onBirinciCalisan")).get("employee_name"),
                ((Map) ((List<?>) actualData.get("data")).get(10)).get("employee_name"));


        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onBirinciCalisan")).get("employee_salary"),

        ((Map) ((List<?>) actualData.get("data")).get(10)).get("employee_salary"));

        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onBirinciCalisan")).get("employee_age"),
                ((Map) ((List<?>) actualData.get("data")).get(10)).get("employee_age"));

        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onBirinciCalisan")).get("profile_image"),
                ((Map) ((List<?>) actualData.get("data")).get(10)).get("profile_image"));



    }



    }


