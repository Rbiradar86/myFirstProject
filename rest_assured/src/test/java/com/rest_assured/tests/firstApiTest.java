package com.rest_assured.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class firstApiTest {
	private RequestSpecification reqSpec;
    private ResponseSpecification resSpec;
    @BeforeClass
    public void setup() {
        reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")
                .addHeader("x-api-key","reqres_b765520b60b44cffa7a144a613e5fd55")
                .setContentType("application/json")
                .build();
        resSpec = new ResponseSpecBuilder()
        		.expectStatusCode(200)
        		.expectContentType("application/json")
        		.build();
        
        
    }	
//	 public void setup() {
//	RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
//	RestAssured.baseURI = "https://reqres.in/api";
//	RestAssured.requestSpecification = new RequestSpecBuilder()
//	       .addHeader("x-api-key", "reqres_b765520b60b44cffa7a144a613e5fd55")
//	        .build();
////		 RestAssured.filters((req, res, ctx) -> {
////			    req.baseUri("https://reqres.in/api");
////			    req.header("x-api-key", "reqres_b765520b60b44cffa7a144a613e5fd55");
////			    return ctx.next(req, res);
////			});
//	 }
//    
 

  @ Test
	 @Description("Validate PreAuth API response schema")
	    @Severity(SeverityLevel.CRITICAL)
	    @Epic("Payment APIs")
	    @Feature("PreAuth Transaction")
	    @Story("Validate schema and status code")
	 
	 @Step("Prepare payload for get preauth transaction")
  public void testGetUsers1() {
	  
   // RestAssured.baseURI = "https://reqres.in/api";
    given().spec(reqSpec)
      .when().get("/users?page=2")
      .then().log().all().statusCode(200)
      .body("data[0].id", equalTo(7),
    		  "data[0].email",equalTo("michael.lawson@reqres.in"));
  }
  
  @Test
  public void testGetUsers2() {
	  System.out.println("Required specification is"+reqSpec);
   // RestAssured.baseURI = "https://reqres.in/api";
    given().spec(reqSpec)
      .when().get("/users?page=2")
      .then().log().all().statusCode(200)
      .body("data[1].id", equalTo(8),
    		  "data[1].email",equalTo("lindsay.ferguson@reqres.in"));
  }
  
  @Test
  public void verifyHeaders()
  {
	  System.out.println("verifyHeaders test started");
//	  given().spec(reqSpec)
//	   .when().get("/users?page=2")
//	   .then().log().all().spec(resSpec);
	  given().spec(reqSpec)
	   .when().get("/users?page=2")
	   .then().log().all()
	   .spec(resSpec);
  }
//    @Test
//    
//    public void testGetUsers1() {
//  	  
//     // RestAssured.baseURI = "https://reqres.in/api";
//      given()
//        .when().get("/users?page=2")
//        .then().statusCode(200)
//        .body("data[0].id", equalTo(7),
//      		  "data[0].email",equalTo("michael.lawson@reqres.in"));
//    }
//  
//  @Test
//  public void testGetUsers2() {
//	
//
//    given()
//      .when().get("/users?page=2")
//      .then().statusCode(200)
//      .body("data[1].id", equalTo(8),
//    		  "data[1].email",equalTo("lindsay.ferguson@reqres.in"));
//  }
}
