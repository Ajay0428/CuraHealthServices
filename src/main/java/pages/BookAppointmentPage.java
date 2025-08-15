package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookAppointmentPage {

	WebDriver driver;
	WebDriverWait wait;

	public BookAppointmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "combo_facility")
	WebElement facility_DropdownElement;

	@FindBy(id = "chk_hospotal_readmission")
	WebElement applyForHospitalReadmission_CheckBoxElement;

	@FindBy(id = "radio_program_medicare")
	WebElement medicare_RadioBtnElement;

	@FindBy(id = "radio_program_medicaid")
	WebElement medicaid_RadioBtnElement;

	@FindBy(id = "radio_program_none")
	WebElement none_RadioBtnElement;

	@FindBy(id = "txt_comment")
	WebElement comment_BoxElement;

	@FindBy(id = "txt_visit_date")
	WebElement visitDate_DatepickerElement;

	@FindBy(id = "btn-book-appointment")
	WebElement bookAppointment_Btn;

	public void selectFacility(String facility) {
		Select select = new Select(facility_DropdownElement);
		select.selectByContainsVisibleText(facility);
	}

	public void selectCheckboxApplyForHospitalReadmission() {
		applyForHospitalReadmission_CheckBoxElement.click();

	}

	public void selectRadioBtnHealthCareProgram(String option) {
		switch (option.toLowerCase()) {
		case "medicare":
			medicare_RadioBtnElement.click();
			break;
		case "medicaid":
			medicaid_RadioBtnElement.click();
			break;
		case "none":
			none_RadioBtnElement.click();
			break;

		default:
			System.out.println("please provide the valid option");
			break;
		}
	}

	public void selectVisitDate(String visitDate) {
		visitDate_DatepickerElement.sendKeys(visitDate);

	}

	public void enterComments(String comments) {
		comment_BoxElement.sendKeys(comments);
	}

	public AppointmentConfirmationPage clickBookAppointmentBtn() {
		bookAppointment_Btn.click();
		return new AppointmentConfirmationPage(driver);

	}

}
