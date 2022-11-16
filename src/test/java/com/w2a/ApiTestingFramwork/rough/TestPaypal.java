package com.w2a.ApiTestingFramwork.rough;

import org.apache.xmlbeans.impl.tool.PrettyPrinter;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.ApiTestingFramwork.POJO.Amount;
import com.w2a.ApiTestingFramwork.POJO.ExperienceContext;
import com.w2a.ApiTestingFramwork.POJO.Order;
import com.w2a.ApiTestingFramwork.POJO.PaymentSource;
import com.w2a.ApiTestingFramwork.POJO.Paypal;
import com.w2a.ApiTestingFramwork.POJO.PurchageUnits;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class TestPaypal {

	String access_token;

	String UserName = "AZvHWE9z0m7eje9b5A7W5UAh3-cENJLyl7C9YtjFSDfaen5Gu4WmOg-nHQE9XgBy598xSeu5mLvwVxCb";
	String Password = "EHw5D7_aX-bdHZA0XK0gHGuqVYdDU-1UwSLg3BZ9EzZdcaNOHVjHgZ-1xJzVB_99oGtyKDaB3VWSSFXB";
	String orderId;

	@Test(priority = 1)
	public void getAccessToken() {

		RestAssured.baseURI = "https://api-m.sandbox.paypal.com";

		Response response = given().param("grant_type", "client_credentials").auth().preemptive()
				.basic(UserName, Password).post("v1/oauth2/token");

		// response.prettyPrint();
		access_token = response.jsonPath().get("access_token");
		System.out.println(access_token);

	}

	@Test(priority = 2, dependsOnMethods = "getAccessToken")
	public void createOrder() {

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

		RestAssured.baseURI = "https://api-m.sandbox.paypal.com";

		Response response = given().contentType(ContentType.JSON)
				.header("PayPal-Request-Id", "7b92603e-77ed-4896-8e78-5dea2050476a").auth().oauth2(access_token)
				.body(order).post("v2/checkout/orders");

		response.prettyPrint();
		
		orderId=response.jsonPath().get("id");

		// Assert.assertEquals(response.jsonPath().get("status"),
		// "PAYER_ACTION_REQUIRED");

	}
	
	@Test(priority = 3, dependsOnMethods = {"getAccessToken","createOrder"})
	public void getOrder() {
		
		Response response = given().contentType(ContentType.JSON)
				.header("PayPal-Request-Id", "7b92603e-77ed-4896-8e78-5dea2050476a").auth().oauth2(access_token)
				.get("v2/checkout/orders"+"/"+orderId);

		response.prettyPrint();
	}

}
