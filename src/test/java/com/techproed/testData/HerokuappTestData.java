package com.techproed.testData;

import org.json.JSONObject;

import java.util.HashMap;

public class HerokuappTestData {

    public HashMap<String, Object> setUpTestData(){
        HashMap<String,Object>bookingdates=new HashMap<String,Object>();
        bookingdates.put("checkin","2015-11-14");
        bookingdates.put("checkout","2016-07-16");

        HashMap<String,Object> expectedData=new HashMap<String,Object>();
        expectedData.put("firstname","Mary");
        expectedData.put("lastname","Smith");
        expectedData.put("totalprice",503);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates","bookingdates");
        return expectedData;

    }
    public JSONObject setUpTestAndRequestData(){
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin","2021-01-05");
        bookingdates.put("checkout","2021-01-10");

        JSONObject expectedRequest =new JSONObject();
        expectedRequest.put("firstname","Batch30");
        expectedRequest.put("lastname","bitti");
        expectedRequest.put("totalprice",123);
        expectedRequest.put("depositpaid",false);
        expectedRequest.put("bookingdates",bookingdates);

        return expectedRequest;
    }
}
