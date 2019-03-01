package com.abhay.practice;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class TestDatabase {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("this is beforeSuite from TestDatabase class");
	}
	
	@BeforeClass
	public void setup() {
		System.out.println("this is setup from TestDatabase class");
	}
	
	@Test(groups = "planets")
	@Parameters("myName")
	public void test1(String name) {
		System.out.println("This test1 is from TestDatabase class :::: " + name);
	}
	
	@Test(groups = "stars")
	public void test2() {
		System.out.println("This test2 is from TestDatabase class");
	}
	
	@Test(groups = "stars", description = "if this test fails test 4 will also not run")
	public void test3() {
		System.out.println("This test3 is from TestDatabase class");
		assertEquals(true, false);
	}
	
	@Test(groups = "stars", dependsOnMethods = {"test3"}, description = "This a dependent test depending on test3")
	public void test4() {
		System.out.println("This test4 is from TestDatabase class");
	}
}
