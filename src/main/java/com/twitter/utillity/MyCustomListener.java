package com.twitter.utillity;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class MyCustomListener implements ISuiteListener

{

	public void onStart(ISuite suite) {

		try {
			PropertyManager.loadProperties();
			ReadWriteExcel.readFile();
			TestBase.getDriver().navigate().to("https://twitter.com/i/flow/login");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		TestBase.getDriver().close();
	}

}
