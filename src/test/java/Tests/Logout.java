package Tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigReader;
import pages.LandingPage;
import pages.LoginPage;

public class Logout extends BaseTest {

	LoginPage loginPage;

	ConfigReader config = new ConfigReader();

	@Test(dataProvider = "loginCredentials")
	public void loginAndLogout(String username, String password, String message) throws InterruptedException {

		loginPage = new LoginPage(driver);

		LandingPage landingPage = new LandingPage(driver);

		loginPage.clickMakeAppointmentBtn();

		loginPage.userLogin(username, password, message);

		landingPage.clickOnLogout();

		assertTrue(driver.findElement(By.id("btn-make-appointment")).isDisplayed());

	}

	@DataProvider(name = "loginCredentials")
	public Object[][] getData() throws IOException {

		Object[][] object = {
				{ config.getProperty("username"), config.getProperty("password"), config.getProperty("message") } };

		return object;
	}
}
