package com.test.pet.reports;

import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager {
	
	private ExtentManager() {
		
	}
	
public static final ThreadLocal<ExtentTest> exTest= new ThreadLocal<ExtentTest>();
	

	public static ExtentTest getExtTest() {
		return exTest.get();
	}

	public static void setExtentTest(ExtentTest test) {
		exTest.set(test);
	}

}
