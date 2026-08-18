package com.rest_assured.tests;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class SecondApiTest {
	private RequestSpecification reqSpec;
	@BeforeClass
    public void setup(){
	

		System.out.println("Before class stareted");
		Properties prop = new Properties();
		String env = System.getProperty("env", "dev"); // default to QA
        String fileName = env + ".properties";
		FileInputStream fis = null;
		try {
			System.out.println("Attempting to load config.properties...");
			fis = new FileInputStream("src/test/resources/"+fileName);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			// TODO Auto-generated catch block
			
			System.out.println("Error: " + e.getMessage());
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}
		
		
        System.out.println("file Name is"+fileName);
		System.out.println("Base URI is showing");
		String baseURI=prop.getProperty("baseURI");
		String xapiKey = prop.getProperty("apiKey");
		System.out.println("Base URI is "+baseURI);
		System.out.println("API key is "+xapiKey);
//		
		prop.setProperty("x-relative-key", "12345");
		System.out.println("x-relative-key is "+prop.getProperty("x-relative-key"));
        reqSpec = new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .addHeader("x-api-key","reqres_b765520b60b44cffa7a144a613e5fd55")
                .build();
    }	
//		 System.out.println("Before class started");
//		    Properties prop = new Properties();
//
//		    try (InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties")) {
//		        if (is == null) {
//		            System.out.println("config.properties not found in classpath!");
//		        } else {
//		            prop.load(is);
//		            System.out.println("Loaded baseURI: " + prop.getProperty("baseURI"));
//		            System.out.println("Loaded apiKey: " + prop.getProperty("apiKey"));
//		        }
//		    } catch (IOException e) {
//		        System.out.println("Error loading properties: " + e.getMessage());
//		    }
//		   
//	}
	 @Test
	    public void dummyTest() {
	        System.out.println("Dummy test executed");
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
}
