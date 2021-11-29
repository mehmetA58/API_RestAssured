package com.techproed.day12;

import com.techproed.pojos.BookingDatesPojo;
import com.techproed.pojos.BookingPojo;
import com.techproed.pojos.BookingResponsePojo;
import com.techproed.pojos.TodosPojo;
import com.techproed.testBase.HerokuAppTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo02 extends HerokuAppTestBase {

    /*https://restful-booker.herokuapp.com/booking
url’ine aşağıdaki request body gönderildiğinde,
 {
               "firstname": "Selim",
               "lastname": "Ak",
               "totalprice": 15000,
               "depositpaid": true,
               "bookingdates": {
                   "checkin": "2020-09-09",
                   "checkout": "2020-09-21"
                }
}Status kodun 200 ve dönen response ‘un
   {
                         "bookingid": 11,
                         "booking": {
                             "firstname": "Selim",
                             "lastname": "Ak",
                             "totalprice": 15000,
                             "depositpaid": true,
                             "bookingdates": {
                                 "checkin": "2020-09-09",
                                 "checkout": "2020-09-21"
                             }
                         }
                      } olduğunu test edin*/
    @Test
    public void test(){
        spec02.pathParam("first","booking");
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2020-09-21","2020-09-09");
        BookingPojo requestExpected=new BookingPojo("Selim","Ak",15000,true,bookingDatesPojo);
        BookingResponsePojo expectedData=new BookingResponsePojo(14,requestExpected);
        System.out.println(expectedData);

        Response response=given()
                .contentType(ContentType.JSON)
                .spec(spec02)
                .auth()
                .basic("admin","password123")
                .body(requestExpected)
                .when()
                .post("/{first}");
        response.prettyPrint();

        BookingResponsePojo actualData=response.as(BookingResponsePojo.class);

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(requestExpected.getFirstname(),actualData.getBooking().getFirstname());
        Assert.assertEquals(requestExpected.getLastname(),actualData.getBooking().getLastname());
        Assert.assertEquals(requestExpected.getTotalprice(),actualData.getBooking().getTotalprice());
        Assert.assertEquals(requestExpected.isDepositpaid(),actualData.getBooking().isDepositpaid());
        Assert.assertEquals(requestExpected.getBookingdates().getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(requestExpected.getBookingdates().getCheckout(),actualData.getBooking().getBookingdates().getCheckout());




    }
}
