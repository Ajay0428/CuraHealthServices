package Tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigReader;
import pages.LandingPage;
import pages.LoginPage;

public class NavigationsTest extends BaseTest {

	LoginPage loginPage;

	ConfigReader config = new ConfigReader();

	@Test
	public void verifyProfileLink() throws InterruptedException, IOException {

		loginPage = new LoginPage(driver);

		LandingPage landingPage = new LandingPage(driver);

		loginPage.clickMakeAppointmentBtn();

		loginPage.userLogin(config.getProperty("username"), config.getProperty("password"),
				config.getProperty("message"));

		landingPage.clickOnProfile();

		assertTrue(driver.getCurrentUrl().contains("profile"));

	}

	@Test
	public void verifyHistoryLink() throws InterruptedException, IOException {

		loginPage = new LoginPage(driver);

		LandingPage landingPage = new LandingPage(driver);

		loginPage.clickMakeAppointmentBtn();

		loginPage.userLogin(config.getProperty("username"), config.getProperty("password"),
				config.getProperty("message"));

		landingPage.clickOnHistory();

		assertTrue(driver.getCurrentUrl().contains("history"));

	}

	@Test
	public void verifyHomeLink() throws InterruptedException, IOException {

		loginPage = new LoginPage(driver);

		LandingPage landingPage = new LandingPage(driver);

		loginPage.clickMakeAppointmentBtn();

		loginPage.userLogin(config.getProperty("username"), config.getProperty("password"),
				config.getProperty("message"));

		landingPage.clickOnHome();

		assertTrue(driver.findElement(By.id("btn-make-appointment")).isDisplayed());

	}

	@Test
	public void verifyLoginLink() throws InterruptedException, IOException {

		loginPage = new LoginPage(driver);

		LandingPage landingPage = new LandingPage(driver);

		landingPage.clickOnLogin();

		assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Login')]")).isDisplayed());

	}

	@Test
	public void verifyPageAfterLogin() throws InterruptedException, IOException {

		loginPage = new LoginPage(driver);

		loginPage.clickMakeAppointmentBtn();

		loginPage.userLogin(config.getProperty("username"), config.getProperty("password"),
				config.getProperty("message"));

		assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Appointment')]")).isDisplayed());

	}

}
