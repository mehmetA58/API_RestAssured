package com.techproed.testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String,Object>setupTestData() {


        Map<String, Object> expectedData = new HashMap<String,Object>();
        expectedData.put("completed", false);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("userId", 1);
        expectedData.put("Via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");
return expectedData;
    }
     /*https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
     }
     "userId": 55,
     "title": "Tidy your room",
     "completed": false
   }
Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
   {
     "userId": 55,
     "title": "Tidy your room",
     "completed": false,
     "id": …
    }*/

    public JSONObject setUpPostData(){
        JSONObject testData=new JSONObject();
        testData.put("statusCode",201);
        testData.put("userId",55);
        testData.put("title","Tidy your room");
        testData.put("completed",false);
      return testData;
    }

    public JSONObject setUpPutData(){
        JSONObject expectedRequest=new JSONObject();
        expectedRequest.put("completed",false);
        expectedRequest.put("userId",21);
        expectedRequest.put("title","Wash the dishes");

return expectedRequest;
    }
    }
