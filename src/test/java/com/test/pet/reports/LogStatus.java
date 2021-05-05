package com.test.pet.reports;



public class LogStatus {

	private LogStatus() {
		//private to avoid initialization
	}
	public static void pass(String message)
	{
		ExtentManager.getExtTest().log(com.relevantcodes.extentreports.LogStatus.PASS, message);
		
	}

	public static void fail(String message)
	{
		ExtentManager.getExtTest().log(com.relevantcodes.extentreports.LogStatus.FAIL, message);
	}



	public static void info(String message)
	{
		ExtentManager.getExtTest().log(com.relevantcodes.extentreports.LogStatus.INFO, message);
	}



	public static void skip(String message)
	{
		ExtentManager.getExtTest().log(com.relevantcodes.extentreports.LogStatus.SKIP, message);
	}

	
}
