package com.w2a.ApiTestingFramwork.API;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.ApiTestingFramwork.setUp.BaseTest;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest {

	public static Response sendPostrequestToCreateCustomerAPIWithValidAuthKey(Hashtable<String, String>data) {
		
		Response response = given()
				.auth()
				.basic(config.getProperty("validSecretKey"), "")
				.formParam("email", data.get("email")).formParam("name", data.get("name")).formParam("description",data.get("description") )
				.post(config.getProperty("customerAPIEndPoint"));
		
		return response;

	}

	public static Response sendPostrequestToCreateCustomerAPIWithInValidAuthKey(Hashtable<String , String >data) {
		
		Response response = given()
				.auth()
				.basic(config.getProperty("invalidSecretKey"), "")
				.formParam("email", data.get("email")).formParam("description", data.get("description") )
				.post(config.getProperty("customerAPIEndPoint"));
		
		return response;

	}

}
