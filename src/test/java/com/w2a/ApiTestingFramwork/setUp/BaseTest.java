package com.w2a.ApiTestingFramwork.setUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.ApiTestingFramwork.utilities.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest {
	
	public static Properties config = new Properties();
	public FileInputStream fis;
	
	public static ExcelReader excel = new ExcelReader("C:\\Users\\vikmishr3\\RESTAssuredAPI\\ApiTestingFramwork\\src\\test\\resources\\excel\\testdata.xlsx");
	
	@BeforeSuite
	public void setUp() {
		
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		RestAssured.baseURI=config.getProperty("baseURI");
		//RestAssured.basePath=config.getProperty("basePath");
	}
	
	@AfterSuite
	public void tearDown() {
		
		
	}

}
