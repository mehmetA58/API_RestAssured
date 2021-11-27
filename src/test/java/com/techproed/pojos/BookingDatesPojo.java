package com.techproed.pojos;

public class BookingDatesPojo {


    private  String Checkout;
    private  String Checkin;

    public String getCheckout() {
        return Checkout;
    }

    public void setCheckout(String checkout) {
        Checkout = checkout;
    }

    public String getCheckin() {
        return Checkin;
    }

    public void setCheckin(String checkin) {
        Checkin = checkin;
    }

    public BookingDatesPojo() {
    }

    public BookingDatesPojo(String checkout, String checkin) {
        Checkout = checkout;
        Checkin = checkin;
    }

    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "Checkout='" + Checkout + '\'' +
                ", Checkin='" + Checkin + '\'' +
                '}';
    }
}
