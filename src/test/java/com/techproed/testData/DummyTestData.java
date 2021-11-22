package com.techproed.testData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DummyTestData {

    /*{
     “id”:”11”
     "employee_name": "Jena Gaines",
    "employee_salary": "90560",
    "employee_age": "30",
    "profile_image": "" }
    } */
    public HashMap<String, Object> setupTestData(){
        HashMap<String,Object> onBirinci=new HashMap<>();
        onBirinci.put("id",11);
        onBirinci.put("employee_name","Jena Gaines");
        onBirinci.put("employee_salary",90560);
        onBirinci.put("employee_age",30);
        onBirinci.put("profile_image","");

        List<Integer>yasList=new ArrayList<Integer>();
        yasList.add(40);
        yasList.add(21);
        yasList.add(19);

HashMap<String,Object> expectedData=new HashMap<String,Object>();
expectedData.put("statusCode",2);
expectedData.put("besinciCalisan","Airi Satou");
expectedData.put("calisanSayısı",24);
expectedData.put("sondan2calianMaasi",106450);
expectedData.put("arananYaslari",yasList);
expectedData.put("onBirinciCalisan",onBirinci);

return expectedData;

    }
    //http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
//Status kodun 200 olduğunu,
//En yüksek maaşın 725000 olduğunu,
//En küçük yaşın 19 olduğunu,
//İkinci en yüksek maaşın 675000
//olduğunu test edin
    public HashMap<String,Integer> setUpTestData02(){
        HashMap<String,Integer> expectedData=new HashMap<String,Integer>();
        expectedData.put("statusCode",200);
        expectedData.put("enYuksekMaas",725000);
        expectedData.put("enKucukYas",19);
        expectedData.put("ikinciYuksekMaas",675000);
        return expectedData;

    }
    public HashMap<String, String> setupRequestBody(){
        HashMap<String,String> requestBody=new HashMap<String, String>();
        requestBody.put("name", "batch30");
        requestBody.put("salary","123000");
        requestBody.put("age","20");
        return requestBody;
    }
    public HashMap<String, Object> setUpExpectedData(){
        HashMap<String,Object> data=new HashMap<String, Object>();
        data.put("name","batch30");
        data.put("salary","123000");
        data.put("age","20");
        HashMap<String,Object> expectedData=new HashMap<String, Object>();
        expectedData.put("statusCode",200);
        expectedData.put("status","success");
        expectedData.put("data",data);
        expectedData.put("message","Successfully! Record has been added.");
        return expectedData;
    }
}
