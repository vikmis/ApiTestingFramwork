package com.w2a.ApiTestingFramwork.utilities;

import org.json.JSONObject;

import com.w2a.ApiTestingFramwork.listeners.ExtentListeners;

public class TestUtill {
	
	public static boolean jsonHasKey(String json,String key) {
		
		JSONObject jsonObject= new JSONObject(json);
		ExtentListeners.testReport.get().info("Validing the presence of key : "+key);
		
		return jsonObject.has(key);
		
	}
	
	public static String  getJsonKeyValue(String json,String key) {
		
		JSONObject jsonObject= new JSONObject(json);
		ExtentListeners.testReport.get().info("Validing the Value of key : "+key);
		return jsonObject.get(key).toString();
	}

}
