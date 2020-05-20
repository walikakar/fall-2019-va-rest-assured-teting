package com.cbt.day1_intro;

import io.restassured.RestAssured;
import jdk.jfr.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RestAssuredPractice {


    @Test
    public void test1(){

        String one = "ABC";
        String two = "ABC";
        String three = "  ABC  ";
        assertThat(one,equalTo(two));
        assertThat(two,equalTo(one));
        assertThat(one,equalToCompressingWhiteSpace(two));

    }

    @Test
    public void test2() {

        String str = "java";
        String str1 = "java";
        String str2 = " java ";

        assertThat(str, equalTo(str1));
        assertThat(str2, equalToCompressingWhiteSpace(str));

        assertThat(1, is(1));

        assertThat(0, lessThan(1));
        assertThat(4, lessThanOrEqualTo(4));

        List<String> arrList = new ArrayList<>();
        assertThat(arrList, empty());

        List<String> stringList = Arrays.asList("wali", "jan", "khan");
        assertThat(stringList, contains("wali", "jan", "khan"));
        System.out.println(stringList);

        assertThat(stringList, hasSize(3));
        assertThat(stringList, hasItem("khan"));


        Assertions.assertTrue(true);

        Assertions.assertAll(
                () -> Assertions.assertTrue(true),
                () -> Assertions.assertEquals(2, 2),
                () -> Assertions.assertFalse(false)

        );

    }
        @Test
                public void verifyStatusCode(){
            // in rest assured we use gherkin style given when then
            // GIVEN --> used to prepare the request
            // When used to send the request
            // Then used for verifying the request

            RestAssured.when().get("http://api.zippopotam.us/us/22401").then().statusCode(200);

            RestAssured.when().get("http://api.zippopotam.us/us/22406").then().statusCode(200);


            RestAssured.
                    when().
                    get("http://api.zippopotam.us/us/22406").then().statusCode(200).contentType("application/json");



            RestAssured.when().get("http://api.zippopotam.us/us/22406").then().statusCode(200).header("Content-Type","application/json");




        }
    }

