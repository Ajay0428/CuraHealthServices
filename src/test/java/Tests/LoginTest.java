package Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.*;
import base.BaseTest;
import config.ConfigReader;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	LoginPage loginPage;
	ConfigReader config = new ConfigReader();

	@Test(dataProvider = "loginCredentials", groups = "regression",retryAnalyzer = RetryAnalyzer.class)
	public void login(String username, String password, String message) {

		loginPage = new LoginPage(driver);

		loginPage.clickMakeAppointmentBtn();

		loginPage.userLogin(username, password, message);

	}

	@DataProvider(name = "loginCredentials")
	public Object[][] getData() throws IOException {

		Object[][] object = {
				{ config.getProperty("username"), config.getProperty("password"), config.getProperty("message") },
				{ "John Doe", "pass1", "Login failed! Please ensure the username and password are valid." },
				{ "user1", "ThisIsNotAPassword", "Login failed! Please ensure the username and password are valid." },
				{ "", "", "Login failed! Please ensure the username and password are valid." },
				{ "", "pass1", "Login failed! Please ensure the username and password are valid." },
				{ "user1", "", "Login failed! Please ensure the username and password are valid." } };

		return object;
	}
	
	@Test(groups = "smoke")
	public void loginWithValidDetails() throws IOException {

		loginPage = new LoginPage(driver);

		loginPage.clickMakeAppointmentBtn();

		loginPage.userLogin(config.getProperty("username"), config.getProperty("password"),
				config.getProperty("message"));
	}

}
