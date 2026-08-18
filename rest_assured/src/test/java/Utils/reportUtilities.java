package Utils;

import io.qameta.allure.Allure;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class reportUtilities {
	

	    public  static void logRequest(String method, String uri,String body) {
	        Allure.addAttachment("Request Method", "text/plain", method);
	        Allure.addAttachment("Request URI", "text/plain", uri);
	       // Allure.addAttachment("Request Headers", "text/plain", headers.toString());
	        if (body != null) {
	            Allure.addAttachment("Request Body", "application/json", body);
	        }
	    }

	    public  static void logResponse(Response response) {
	        Allure.addAttachment("Response Status", "text/plain", String.valueOf(response.getStatusCode()));
	        Allure.addAttachment("Response Headers", "text/plain", response.getHeaders().toString());
	        Allure.addAttachment("Response Body", "application/json", response.getBody().asString());
	    }
	}


