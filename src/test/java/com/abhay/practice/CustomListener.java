package com.abhay.practice;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomListener extends TestListenerAdapter{
	
	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println(tr.getName() + " :: PASSED ");
	}
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		System.out.println(tr.getName() + " :: FAILED");
	}
	
	@Override
	public void onTestSkipped(ITestResult tr) {
		System.out.println(tr.getName() + " :: was SKIPPED");
	}
	
}
