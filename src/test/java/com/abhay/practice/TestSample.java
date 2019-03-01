package com.abhay.practice;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestSample {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("this beforesuite is from TestSAmple class");
	}
	
	@BeforeClass
	public void setup() {
		System.out.println("setup method from TestSample class");
	}
	
	
	
	@Test
	public void test1() {
		boolean status = true;
		assertEquals(status, false);
	}
	
	
}
