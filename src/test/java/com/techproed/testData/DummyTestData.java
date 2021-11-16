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
}
