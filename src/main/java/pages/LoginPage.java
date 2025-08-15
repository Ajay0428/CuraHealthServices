package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//a[@id='btn-make-appointment']")
	WebElement makeAppointmentBtnElement;

	@FindBy(css = "//input[placeholder='Username']")
	WebElement demoUserName;

	@FindBy(xpath = "//input[placeholder='pasword']")
	WebElement demoPassword;

	@FindBy(xpath = "//input[@id='txt-username']")
	WebElement usernameInputElement;

	@FindBy(xpath = "//input[@id='txt-password']")
	WebElement passwordInputElement;

	@FindBy(xpath = "//button[@id='btn-login']")
	WebElement loginBtnElement;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickMakeAppointmentBtn() {
		makeAppointmentBtnElement.click();
	}

	public BookAppointmentPage userLogin(String username, String Password, String message) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(usernameInputElement));

		usernameInputElement.sendKeys(username);
		passwordInputElement.sendKeys(Password);
		loginBtnElement.click();

		String titleString = driver.getCurrentUrl();

		String actualString = "appointment";

		String actualMessageString;

		if (titleString.toLowerCase().contains(actualString)) {
			WebElement messageElement = driver.findElement(By.id("btn-book-appointment"));
			actualMessageString = wait.until(ExpectedConditions.visibilityOf(messageElement)).getText();
		} else {
			WebElement messageElement = driver.findElement(By.cssSelector(".text-danger"));
			actualMessageString = wait.until(ExpectedConditions.visibilityOf(messageElement)).getText();
		}
		Assert.assertEquals(actualMessageString.toLowerCase(), message.toLowerCase(), "You landed into incorrect page");
		
		return new BookAppointmentPage(driver);
	}

}
