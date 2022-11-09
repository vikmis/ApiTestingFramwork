package com.w2a.ApiTestingFramwork.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.w2a.ApiTestingFramwork.setUp.BaseTest;
import com.w2a.ApiTestingFramwork.utilities.ExcelReader;

public class Rought extends BaseTest {
	
	
	
	public static void main(String[] args) throws IOException {
		
		/*Properties config = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
				
		config.load(fis);
		config.getProperty("baseURI");
		System.out.println(config.getProperty("baseURI"));*/
		ExcelReader excel = new ExcelReader("C:\\Users\\vikmishr3\\RESTAssuredAPI\\ApiTestingFramwork\\src\\test\\resources\\excel\\exceldata.xlsx");
	
		//excel.getRowCount("ValidateCreateCustomerApi");
		System.out.println(excel.getRowCount("ValidateCreateCustomerApi"));
	}
	
	

}
