package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentConfirmationPage {

	WebDriver driver;

	public AppointmentConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[contains(text(),'Facility')]/parent::div/parent::div/div[2]")
	WebElement facilityValueElement;

	@FindBy(xpath = "//label[contains(text(),'readmission')]/parent::div/parent::div/div[2]")
	WebElement applyForHospitalReadmissionValueElement;

	@FindBy(xpath = "//label[contains(text(),'Healthcare')]/parent::div/parent::div/div[2]")
	WebElement healthcareprogramValueElement;

	@FindBy(xpath = "//label[contains(text(),'Date')]/parent::div/parent::div/div[2]")
	WebElement visitDateValueElement;

	@FindBy(xpath = "//label[contains(text(),'Comment')]/parent::div/parent::div/div[2]")
	WebElement commentBoxValueElement;
	
	@FindBy(xpath = "//a[contains(text(),'Homepage')]")
	WebElement goToHomepageBtnElement;

	public String getTextFacility() {
		String facilityValue = facilityValueElement.getText();
		return facilityValue;
	}

	public boolean isTrueApplyForHospitalReadmission() {
		boolean isTrueApplyForHospitalReadmission =  applyForHospitalReadmissionValueElement.getText().contains("Yes");
		return isTrueApplyForHospitalReadmission;
	}
	
	public String getTextHealthcareProgram() {
		String healthcareProgramValue = healthcareprogramValueElement.getText();
		return healthcareProgramValue; 
	}
	
	public String getTextVisitdate() {
		String visitdateValue = visitDateValueElement.getText();
		return visitdateValue; 
	}
	
	public String getTextComments() {
		String commentsValue = commentBoxValueElement.getText();
		return commentsValue; 
	}
	
	public void goToHomePage() {
		 goToHomepageBtnElement.click();
	}
	

}
