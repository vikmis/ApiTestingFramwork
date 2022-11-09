package com.w2a.ApiTestingFramwork.testcases;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

/*import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;*/

import org.testng.annotations.Test;

import com.w2a.ApiTestingFramwork.API.CreateCustomerAPI;
import com.w2a.ApiTestingFramwork.API.DeleteCustomerAPI;
import com.w2a.ApiTestingFramwork.listeners.ExtentListeners;
import com.w2a.ApiTestingFramwork.setUp.BaseTest;
import com.w2a.ApiTestingFramwork.utilities.DataUtil;
import com.w2a.ApiTestingFramwork.utilities.TestUtill;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteCustomer extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	// keep the sheet name same as menthod name.
	public void deleteCutomer(Hashtable<String, String> data) {

		Response response = DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerAPIWithValidID(data);
		ExtentListeners.testReport.get().info(data.toString());
	
		response.prettyPrint();

		System.out.println("ResponseCode is : - " + response.statusCode());
		
		/*String acctualId  = response.jsonPath().get("id").toString();
		System.out.println("Getting id form JSON path : "+acctualId);
		
		Assert.assertEquals(acctualId, data.get("id")," ID not matching");
		Assert.assertEquals(response.statusCode(), 200);*/
		
		Assert.assertTrue(TestUtill.jsonHasKey(response.asString(),"id"),"ID is not Prresent");
			
		
		String acctualId  =TestUtill.getJsonKeyValue(response.asString(), "id");
		System.out.println(acctualId);
		Assert.assertEquals(acctualId, data.get("id")," ID not matching");
	}

	
}
