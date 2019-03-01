package com.abhay.practice;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import businessLogic.EmployeeBusinessLogic;
import model.EmployeeDetails;

public class TestEmployeeBusinessLogic {
	
	EmployeeBusinessLogic bs = null;
	
	@BeforeClass
	public void setup() {
		System.out.println("Setup from testEmployee class ran");
		bs = new EmployeeBusinessLogic();
	}
	
	
	@AfterClass
	public void tearDown() {
		bs = null;
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("this beforesuite is from TestEmployeeBusinessLogic class");
	}
	
	@DataProvider
	public EmployeeDetails[][] employeesTestData() {
		
		EmployeeDetails[][] empSampleData = {
												{new EmployeeDetails("abhay", 9000, 23)}
												,{new EmployeeDetails("raksha", 25000, 22)}
											};
		return empSampleData;
	}
	
	
	@Test(dataProvider="employeesTestData", groups = "weekly")
	public void testCalculateAppraisal(EmployeeDetails emp) {
		
		double expected = 0;
		if(emp.getMonthlySalary() < 10000) {
			expected = 500;
		}else {
			expected = 1000;
		}
		
		assertEquals(bs.calculateAppraisal(emp), expected);
	}
	
	
//	@Test(dataProvider="employeesTestData", enabled = false)
	@Test(dataProvider="employeesTestData", groups = "daily")
	public void testCalculateYearlySalary(EmployeeDetails emp) {
		double expected = emp.getMonthlySalary() * 12;
		System.out.println("this method is from daily test group");
		assertEquals( bs.calculateYearlySalary(emp), expected);
	}
	
	
	

	
}
