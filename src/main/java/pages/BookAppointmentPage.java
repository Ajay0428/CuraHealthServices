package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAppointmentPage {

	WebDriver driver;
	
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
	
	
	
}
