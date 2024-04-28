package com.twitter.pages;

import static org.testng.Assert.assertEquals;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.twitter.locators.LoginLocators;
import com.twitter.utillity.ReadWriteExcel;
import com.twitter.utillity.TestBase;

public class LoginPage implements LoginLocators

{
	public WebElement userName() {
		return TestBase.getDriver().findElement(By.xpath(username));

	}

	public void waitForusername() {

		WebDriverWait userWait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		userWait.until(ExpectedConditions.visibilityOf(userName()));
		
	
	}

	public void checkLoginurl() {
		String expectedUrl = "https://twitter.com/i/flow/login";
		String actualUrl = TestBase.getDriver().getCurrentUrl();
		assertEquals(actualUrl, expectedUrl);
		SoftAssert a = new SoftAssert();
		a.assertTrue(actualUrl.endsWith("ss"));
				System.out.println("After");
				a.assertAll();
				//assertTrue(actualUrl.endsWith("ss"));
		
	}

	public WebElement nextButton() {
		return TestBase.getDriver().findElement(By.xpath(nextButton));
	}

	public WebElement loginButton() {
		return TestBase.getDriver().findElement(By.xpath(loginButton));
	}

	public void nextButtonclick() {
		nextButton().click();
	}

	public WebElement password() {
		return TestBase.getDriver().findElement(By.xpath(password));
	}

	public void waitForpassword() {
		WebDriverWait passwordWait = new WebDriverWait(TestBase.getDriver(),Duration.ofSeconds(10));
		passwordWait.until(ExpectedConditions.visibilityOf(password()));

	}

	public int getRowcount() {
		return ReadWriteExcel.sheet.getLastRowNum() - ReadWriteExcel.sheet.getFirstRowNum();
	}

	public void confirmUsername() {
		userName().sendKeys("bhavya");
	}

	public void usernameValidation() {
		String getUsername;
		System.out.println(getRowcount());
		for (int i = 1; i <= getRowcount(); i++) {

			getUsername = ReadWriteExcel.sheet.getRow(i).getCell(0).getStringCellValue();
			userName().sendKeys(getUsername);
			nextButtonclick();
			userName().clear();
		}

	}

	public void passwordValidation() {
		String getpassword;
		System.out.println(getRowcount());
		for (int i = 1; i <= getRowcount(); i++) {

			getpassword = ReadWriteExcel.sheet.getRow(i).getCell(1).getStringCellValue();
			password().sendKeys(getpassword);
			loginButton().click();
			password().clear();

		}

	}

}
