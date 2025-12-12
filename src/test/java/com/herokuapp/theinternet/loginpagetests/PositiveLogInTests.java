package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.apache.commons.io.FileUtils.waitFor;

public class PositiveLogInTests extends TestUtilities {

	@Test
	public void logInTest() {

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject (driver,log);
		welcomePage.openPage ();

		takeScreenshot ( "WelcomePage opened" );
		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink ();
		takeScreenshot ( "LoginPage opened" );
		//execute log in

		Cookie ck = new Cookie("username","tomsmith","the-internet.herokuapp.com","/", null);
		loginPage.setCookie ( ck );
		SecureAreaPage secureAreaPage = loginPage.logIn ( "tomsmith", "SuperSecretPassword!" );
		takeScreenshot ( "SecureAreaPage opened" );
	String username = secureAreaPage.getCookie ( "username" );
	log.info ( "Username cookie: "+username );
		String session = secureAreaPage.getCookie ( "rack.session" );
		log.info ( "Session cookie: "+session );

		// Verifications
		// New page url is expected
		sleep ( 3000 );

		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

		// log out button is visible
		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "LogOut Button is not visible.");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}
}
