package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

	@FindBy(xpath = "//a[@id='btn-make-appointment']")
	WebElement makeAppointmentBtnElement;
	
	@FindBy(css = "input[placeholder='Username']")
	WebElement demoUserName;
	
	@FindBy(xpath = "input[placeholder='pasword']")
	WebElement demoPassword;
	
	@FindBy(xpath = "//input[@id='txt-username")
	WebElement usernameInputElement;
	
	@FindBy(xpath = "//input[@id='txt-password")
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
	
	
}
