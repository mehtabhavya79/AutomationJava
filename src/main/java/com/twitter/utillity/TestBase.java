package com.twitter.utillity;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {
			String browser = PropertyManager.properties.getProperty("browser");
			if (browser.toUpperCase().equals("CHROME")) {
				WebDriverManager.chromedriver().clearDriverCache().setup();
				driver = new ChromeDriver();
			} else if (browser.toUpperCase().equals("EDGE")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			return driver;

		} else {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;

		}
	}

}
