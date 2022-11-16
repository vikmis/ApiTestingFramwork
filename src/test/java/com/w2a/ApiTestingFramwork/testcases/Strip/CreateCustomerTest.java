package com.w2a.ApiTestingFramwork.testcases.Strip;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

/*import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;*/

import org.testng.annotations.Test;

import com.w2a.ApiTestingFramwork.API.Strip.CreateCustomerAPI;
import com.w2a.ApiTestingFramwork.listeners.ExtentListeners;
import com.w2a.ApiTestingFramwork.setUp.BaseTest;
import com.w2a.ApiTestingFramwork.utilities.DataUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateCustomerTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	// keep the sheet name same as menthod name.
	public void validateCreateCustomerAPIWithValidSecretKey(Hashtable<String, String> data) {

		Response response = CreateCustomerAPI.sendPostrequestToCreateCustomerAPIWithValidAuthKey(data);
		ExtentListeners.testReport.get().info(data.toString());

		response.prettyPrint();

		System.out.println("ResponseCode is : - " + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void validateCreateCustomerAPIWithInValidSecretKey(Hashtable<String, String> data) {

		Response response = CreateCustomerAPI.sendPostrequestToCreateCustomerAPIWithInValidAuthKey(data);
		ExtentListeners.testReport.get().info(data.toString());

		response.prettyPrint();

		System.out.println("ResponseCode is : - " + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
	
	}

}
