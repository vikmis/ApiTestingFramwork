package com.w2a.ApiTestingFramwork.API;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.ApiTestingFramwork.setUp.BaseTest;

import io.restassured.response.Response;

public class DeleteCustomerAPI extends BaseTest {
	
public static Response sendDeleteRequestToDeleteCustomerAPIWithValidID(Hashtable<String, String>data) {
		
		Response response = given()
				.auth()
				.basic(config.getProperty("validSecretKey"), "")
				.post(config.getProperty("customerAPIEndPoint")+"/"+data.get("id"));
		
		return response;

	}
	
	

}
