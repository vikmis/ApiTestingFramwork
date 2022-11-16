package com.w2a.ApiTestingFramwork.testcases.Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.ApiTestingFramwork.API.paypal.OrderAPI;
import com.w2a.ApiTestingFramwork.setUp.BaseTest;

import io.restassured.response.Response;

public class CreateOrdertest extends BaseTest {
	
	@Test
	public void createOrder() {
		
		String accessTkn = OrderAPI.getAccessToken();
		System.out.println(accessTkn);
		Response response = OrderAPI.createOrder(accessTkn);
		// Assert.assertEquals(response.jsonPath().get("status"),"PAYER_ACTION_REQUIRED");
		 response.prettyPrint();
	}

}
