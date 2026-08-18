package com.rest_assured.tests;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class setEnvVariable {
	private RequestSpecification reqSpec;
	@BeforeClass
    public void setup(){
//		String baseURI= System.getenv("BASE_URI");
//		String xApiKey = System.getenv("API_KEY");
//		reqSpec= new RequestSpecBuilder().setBaseUri(baseURI)
//				.addHeader("x-api-key", xApiKey)
//				.build();
		reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")
                .addHeader("x-api-key","reqres_b765520b60b44cffa7a144a613e5fd55")
                .setContentType("application/json")
                .build();
		
	}
	
	@Test
	
	 public void testGetUsers1() {
		  
		   // RestAssured.baseURI = "https://reqres.in/api";
		    given().spec(reqSpec)
		      .when().get("/users?page=2")
		      .then().log().all().statusCode(200)
		      .body("data[0].id", equalTo(7),
		    		  "data[0].email",equalTo("michael.lawson@reqres.in"));
		  }
}
