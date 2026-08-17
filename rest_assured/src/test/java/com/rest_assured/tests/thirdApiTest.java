package com.rest_assured.tests;
import Utils.payloadUtil;
import Utils.reportUtilities;

import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.nio.charset.StandardCharsets;

public class thirdApiTest {
	private RequestSpecification reqSpec;
	private ResponseSpecification resSpec;
	public String postRequestpayload;
	@BeforeClass
	public void setUp() throws Exception
	{
		reqSpec = new RequestSpecBuilder()
				.addHeader("application/json","contentType")
				.setAccept("application/json")
				.addHeader("x-api-key","reqres_b765520b60b44cffa7a144a613e5fd55")
				.setBaseUri("https://reqres.in/api").build();
		
		postRequestpayload = payloadUtil.getPayload("payment.json", "postRequest");
				
	}
	
	@Test
	@Description("Validate get request api")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("request APIs")
    @Feature("get request Transaction")
    @Story("Validate get request status code")
	public void getrequest() {
	
	Response response = given().spec(reqSpec)
				.when().get("/users?page=2");
	reportUtilities.logRequest("GET", "https://reqres.in/api/users?page=2",null);			
	reportUtilities.logResponse(response);
	     
		 //Allure.addAttachment("Response", "application/json", response);
		
	}
	
	@Test

	@Description("Validate post request api")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("request APIs")
    @Feature("post request Transaction")
    @Story("Validate get request status code")
	@Step("Validate post Request is working")
	public void postRequest() throws Exception
	{
		//String payload = payloadUtil.getPayload("payment.json", "postRequest");
		Response postReqRespone = given().spec(reqSpec).body(postRequestpayload.getBytes(StandardCharsets.UTF_8))
				.contentType("application/json; charset=UTF-8")
				.accept("application/json")
				.when().post("/users?page=2");
		reportUtilities.logRequest("POST", "https://reqres.in/api/users?page=2",postReqRespone.asPrettyString());
		reportUtilities.logResponse(postReqRespone);
		
		
	}
	
	@Test
	@Description("Validate post request schema api")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("request APIs")
    @Feature("post request Transaction")
    @Story("Validate post request schema")
	@Step("Validate post Request scheme is matching")
	public void validatePostRequestSchema()
	{
		given().spec(reqSpec)
				.body(postRequestpayload.getBytes(StandardCharsets.UTF_8))
				.contentType("application/json; charset=UTF-8")
				.accept("application/json")
				.when().post("/users?page=2")
				.then().statusCode(201).body(matchesJsonSchemaInClasspath("postRequestSchema.json"));
	            
		
				
	}
}
