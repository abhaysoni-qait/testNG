package com.abhay.practice;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class CustomReporter implements IReporter{

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		System.out.println("Location of O/P directory :: "+ outputDirectory);
		
		
		for(XmlSuite xmlsuite : xmlSuites) {
			System.out.println(xmlsuite.getAllParameters().toString());
			System.out.println(xmlsuite.getGuiceStage());
			System.out.println("Listeners of this suite :: " + xmlsuite.getListeners().toString());
			System.out.println("Listeners of this suite :: " + xmlsuite.getLocalListeners().toString());
		}
		
		for(ISuite suite : suites) {
			String name = suite.getName();
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			
			for(ISuiteResult result : suiteResults.values()) {
				ITestContext context =  result.getTestContext();
				System.out.println("total passed test :: " + context.getPassedTests().size());
				System.out.println("total failed test :: " + context.getFailedTests().size());
				System.out.println("total skipped test :: " + context.getSkippedTests().size());
				
			}
		}
		
	}

}
