package com.cbt.day1_intro;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredIntro {


    /*   RestAssured is gherkin keyword like Given , When , Then
    * make a get request to api.zippopotam.us/us/90210
     */

    @Test
    public void testStatusCode(){

        // in rest assured we use gherkin style given when then
        // GIVEN --> used to prepare the request
        // When used to send the request
        // Then used for verifying the request

        RestAssured.
                given().log().all().
                when().get("" +
                "").
                then().statusCode(200);
    }



    /*
    make a get request to http://api.openrates.io/latest
    verify that status code is 200

      1. -- 100--> information
      2. --> 200 --> success
      3. --    > redirect
      4.-- 401 > client error
      4.-- 403 > client error
      5. -->501 server error
     */
    @Test
    public void testStatusCode2(){
        RestAssured.
                when().get("http://api.openrates.io/latest").
                then().statusCode(200);
    }


     //   make a get request to http://api.openrates.io/latest
     //    verify that status code is 200
    @Test
    public void printResponse(){

         // prettyPeek() --> prints the response
        RestAssured.when().get("http://api.openrates.io/latest").
                prettyPeek().then().statusCode(200);
    }

    /*
    make a get request to http://api.openrates.io/latest
    verify that status code is 200
    verify header reponse type application / json

     */
    @Test
    public void verifyContentType(){

        // StatusCode -- > verify code
        // contentType --> verify the header content type

        RestAssured.when().
                get("http://api.openrates.io/latest").
                prettyPeek().
                then().statusCode(200).contentType(ContentType.JSON);

        // same test with some syntactic sugar  it will help for code readablities and organization
        RestAssured.when().
                get("http://api.openrates.io/latest").
                prettyPeek().
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON);

        // same test but verify header differently

        RestAssured.when().
                get("http://api.openrates.io/latest").
                prettyPeek().
                then().statusCode(200).contentType("application/json");

        // same test but verify header differently differently


        RestAssured.when().
                get("http://api.openrates.io/latest").
                prettyPeek().
                then().statusCode(200).header("Content-Type","application/json");


    }

      /*
    make a get request to http://api.openrates.io/us/us/22401
    verify that status code is 200
    verify header reponse type application / json
    verify header CharSet UTF-8
       @Test
    public void testStatusCodeAndHeader(){
        RestAssured.
                when().
                        get("http://api.zippopotam.us/us/20007").
                        prettyPeek().
                then().statusCode(200).
                    and().contentType(ContentType.JSON).
                    and().header("Charset", equalTo("UTF-8"));
    }
}
​

     */

    @Test
    public void testStatusCodeAndHeader(){

        RestAssured.when().
                get("http://api.zippopotam.us/us/22401").
                prettyPeek().
                then().statusCode(200).and().contentType(ContentType.JSON).and().header("Charset",equalTo("UTF-8"));
    }
}
