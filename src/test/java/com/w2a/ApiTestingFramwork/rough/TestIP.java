package com.w2a.ApiTestingFramwork.rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestIP {

	
	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress.getLocalHost().getHostAddress();
		
		System.out.println("http://"+InetAddress.getLocalHost().getHostAddress()+"8080/job/ApiTestingFramwork/Extent_20Report");
		
	}
}
