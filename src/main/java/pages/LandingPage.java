package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	WebDriver driver;
	WebDriverWait wait;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".fa-bars")
	WebElement menuBarElement;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutLinkElement;
	
	@FindBy(xpath = "//a[contains(text(),'History')]")
	WebElement historyLinkElement;
	
	@FindBy(xpath = "//a[contains(text(),'Profile')]")
	WebElement profileLinkElement;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homeLinkElement;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginLinkElement;
	

	public void clickOnLogout() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(menuBarElement));
		menuBarElement.click();

		wait.until(ExpectedConditions.visibilityOf(logoutLinkElement));
		logoutLinkElement.click();

	}
	
	public void clickOnHistory() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(menuBarElement));
		menuBarElement.click();

		wait.until(ExpectedConditions.visibilityOf(historyLinkElement));
		historyLinkElement.click();

	}
	
	public void clickOnProfile() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(menuBarElement));
		menuBarElement.click();

		wait.until(ExpectedConditions.visibilityOf(profileLinkElement));
		profileLinkElement.click();

	}
	
	public void clickOnHome() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(menuBarElement));
		menuBarElement.click();

		wait.until(ExpectedConditions.visibilityOf(homeLinkElement));
		homeLinkElement.click();

	}
	
	public void clickOnLogin() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(menuBarElement));
		menuBarElement.click();

		wait.until(ExpectedConditions.visibilityOf(loginLinkElement));
		loginLinkElement.click();

	}
	
	
	
	
	
}
