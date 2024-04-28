package com.twitter.testcases;

import org.testng.annotations.Test;

import com.twitter.pages.LoginPage;

public class Login

{
	@Test
	public void twitterLogin() {

		LoginPage loginpage = new LoginPage();
		loginpage.checkLoginurl();
		loginpage.waitForusername();
		loginpage.usernameValidation();
		loginpage.waitForusername();
		loginpage.confirmUsername();
		loginpage.nextButtonclick();
		loginpage.waitForpassword();
		loginpage.passwordValidation();

	}

}
