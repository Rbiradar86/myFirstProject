package com.rest_assured.tests;


import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

//import Utils.payloadUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
import static org.hamcrest.Matchers.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class paymentApi {
	 private RequestSpecification reqSpec;
	 public static String txnReceipt;
	
	 
	 @BeforeClass
	 public void setup() {
	        reqSpec = new RequestSpecBuilder()
	                .setBaseUri("")
	                .addHeader("x-api-key","")
	               // .setContentType("application/json")
	               // .setAccept("application/json")
	                .build();
	        }
//	 
	 @ Test
	 @Description("Validate PreAuth API response schema")
	    @Severity(SeverityLevel.CRITICAL)
	    @Epic("Payment APIs")
	    @Feature("PreAuth Transaction")
	    @Story("Validate schema and status code")
	 
	 @Step("Prepare payload for get preauth transaction")
	 public void getGuestPayment()
	 {
		 given().spec(reqSpec).when().get("")
		 .then().log().all().statusCode(200)
		.body(matchesJsonSchemaInClasspath("paymentSchema.json"));
//		 given().spec(reqSpec)
//	      .when().get("/users?page=2");
	 }
//	 
//	
//	 
//	 
//	 @Test(priority = 1)
//	 
//	 public void guestPreuathPayment() throws Exception {
//	 System.out.println("Guest preauth started");
//	 String json = new String(Files.readAllBytes(Paths.get("src/test/resources/payment.json")));
//	 JsonNode root = new ObjectMapper().readTree(json);
//	 String payload = payloadUtil.getPayload("payment.json", "preauth");
//	// String preauthPayload = root.get("preauth").toString();
//	 System.out.println("Preauth payload is " +payload );
//	 ObjectMapper mapper = new ObjectMapper();
//	 JsonNode root1 = mapper.readTree(payload);
//
//	 // dynamically update amount
//	 ((ObjectNode) root1).put("amount", 999.99);
//
//	 // dynamically update merchantTransactionId
//	 ((ObjectNode) root1.get("merchantData")).put("merchantTransactionId", UUID.randomUUID().toString());
//
//	 String newPayload = root1.toString();
//	 System.out.println("newPayload is"+ newPayload);
	 
		 
//		 Response response = given().spec(reqSpec).body(preauthPayload).log().all()
//		 .when().post("/request"); 
//	
////		 given().spec(reqSpec)
////	      .when().get("/users?page=2");
//		// String responseBody = response.asString();
//	System.out.println("Response  of first test "+ response.asString());
////		 int statusCode = response.getStatusCode();
//		 txnReceipt = response.jsonPath().getString("transactionReceipt");
//		 String stan= response.jsonPath().getString("payment.metadata.stan");
//		 String resultType = response.jsonPath().getString("result.resultType");
////		 System.out.println("status code is "+statusCode);
//	 System.out.println("transactionReceipt is "+txnReceipt);
	 
//		 System.out.println("status is "+stan);
//		 //System.out.println("Status code is " + statusCode+ txnReceipt + stan);
//		 Assert.assertEquals(statusCode, 200);
//		 Assert.assertNotNull(txnReceipt);
//		 Assert.assertEquals(resultType, "DUPLICATE");
		 
//		 response.then().statusCode(200)
//		 .body("transactionReceipt", notNullValue())
//		 .body("payment.metadata.stan", notNullValue())
//		 .body("result.resultType", equalTo("DUPLICATE"));
		 
//		 List<String> errors = response.jsonPath().getList("message");
//		 Assert.assertTrue(errors.contains("amount should not be empty"));
//		 Assert.assertTrue(errors.size() > 0);
//		 
//		 response.then()
//		 .body("message[1]", equalTo("amount should not be empty"))
//		 .body("message[3]",equalTo("paymentMethod should not be empty"));
		 
		 
	  
	
	// }
	 
//	 @Test(priority = 2)
//	 public void cancelPreauthPayment()
//	 {
//		Response response = given().spec(reqSpec).body("{\r\n"
//				+ "    \"merchantData\": {\r\n"
//				+ "        \"merchantTransactionId\": \"hEY  c r0l\",\r\n"
//				+ "        \"transactionUUID\": \"\"\r\n"
//				+ "    }\r\n"
//				+ "}\r\n"
//				+ " ").log().all().when().post("/req/"+txnReceipt+"/cancel");
//		
//		System.out.println("cancel preauth Response is "+ response.asPrettyString());
//		response.then()
//		.body("result.resultDescription", equalTo("Cancel request Succeeded"));
//		
//		
// }


}