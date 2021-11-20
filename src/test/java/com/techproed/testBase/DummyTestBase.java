package com.techproed.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import java.util.HashMap;

public class DummyTestBase {
    protected RequestSpecification spec03;
    @Before
    public void setUp(){
        spec03= new RequestSpecBuilder().
                setBaseUri("http://dummy.restapiexample.com/api/v1").
                build();
    }

}

