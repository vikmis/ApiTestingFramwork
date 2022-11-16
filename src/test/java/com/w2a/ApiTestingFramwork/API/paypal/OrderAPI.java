package com.w2a.ApiTestingFramwork.API.paypal;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import com.w2a.ApiTestingFramwork.POJO.Amount;
import com.w2a.ApiTestingFramwork.POJO.ExperienceContext;
import com.w2a.ApiTestingFramwork.POJO.Order;
import com.w2a.ApiTestingFramwork.POJO.PaymentSource;
import com.w2a.ApiTestingFramwork.POJO.Paypal;
import com.w2a.ApiTestingFramwork.POJO.PurchageUnits;
import com.w2a.ApiTestingFramwork.setUp.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OrderAPI extends BaseTest {

	//String access_token;

	static String UserName = config.getProperty("paypalClientID");
	static String Password = config.getProperty("paypalSecretKey");
	static String orderId;

	public static  String getAccessToken() {

		String accessToken = given().param("grant_type", "client_credentials").auth().preemptive()
				.basic(UserName, Password).post("v1/oauth2/token").jsonPath().get("access_token");

		return accessToken;
	}

	public static  Response createOrder(String accessTkn) {
  
		Amount amnt = new Amount("USD", "100.00");

		PurchageUnits prchunt = new PurchageUnits("d9f80740-38f0-11e8-b467-0ed5f89f718b", amnt);

		ArrayList<PurchageUnits> list = new ArrayList<PurchageUnits>();
		list.add(prchunt);

		ExperienceContext ec = new ExperienceContext("IMMEDIATE_PAYMENT_REQUIRED", "PAYPAL", "EXAMPLE INC", "en-US",
				"LOGIN", "SET_PROVIDED_ADDRESS", "PAY_NOW", "https://example.com/returnUrl",
				"https://example.com/cancelUrl");

		Paypal ppl = new Paypal(ec);

		PaymentSource ps = new PaymentSource(ppl);

		Order order = new Order("CAPTURE", list, ps);

		Response response = given().contentType(ContentType.JSON)
				.header("PayPal-Request-Id", "7b92603e-77ed-4896-8e78-5dea2050476a").auth().oauth2(accessTkn)
				.body(order).post("v2/checkout/orders");
				
		 
		return response;

	}

	public static  Response getOrder() {

		Response response = given().contentType(ContentType.JSON)
				.header("PayPal-Request-Id", "7b92603e-77ed-4896-8e78-5dea2050476a").auth().oauth2(getAccessToken())
				.get("v2/checkout/orders" + "/" + orderId);
		return response;

	}

}
