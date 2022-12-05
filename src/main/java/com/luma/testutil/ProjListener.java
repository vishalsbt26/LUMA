package com.luma.testutil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.luma.base.TestBase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ProjListener extends TestBase implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ProjExtentReport.getReport();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
