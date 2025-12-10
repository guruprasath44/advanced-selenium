package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private  String browser;
	private  Logger log;

	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}

	public WebDriver createDriver() {
		// Create driver
		log.info("Create driver: " + browser);
		ChromeOptions Coptions = new ChromeOptions();
		FirefoxOptions FFoptions = new FirefoxOptions();
		switch (browser) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

			Coptions.addArguments("--headless=new");
			//driver.set(new ChromeDriver(Coptions));
			driver.set(new ChromeDriver());
			break;

			case "firefox":
			//	System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
				// Add the --headless argument to enable headless mode
				FFoptions.addArguments("--headless");
				//driver.set(new FirefoxDriver(FFoptions));
				driver.set(new FirefoxDriver());
				break;

			default:
				System.out.println("Do not know how to start: " + browser + ", starting chrome.");
				//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
				//Coptions.addArguments("--headless=new");
				//driver.set(new ChromeDriver(Coptions));
				driver.set(new ChromeDriver());
				break;
		}

		return driver.get();
	}
}
