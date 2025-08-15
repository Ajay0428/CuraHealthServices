package Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigReader;
import pages.AppointmentConfirmationPage;
import pages.BookAppointmentPage;
import pages.LoginPage;

public class BookAppointmentTest extends BaseTest {
	ConfigReader config = new ConfigReader();
	LoginPage loginPage;

	@Test(dataProvider = "appointmentData")
	public void fillMakeAppointmentForm(String facility, String healthCareProgramoption, String visitDate,
			String comments) throws IOException {
		loginPage = new LoginPage(driver);
		loginPage.clickMakeAppointmentBtn();
		BookAppointmentPage bookAppointmentPage = loginPage.userLogin(config.getProperty("username"),
				config.getProperty("password"), config.getProperty("message"));

		bookAppointmentPage.selectFacility(facility);
		bookAppointmentPage.selectCheckboxApplyForHospitalReadmission();
		bookAppointmentPage.selectRadioBtnHealthCareProgram(healthCareProgramoption);
		bookAppointmentPage.selectVisitDate(visitDate);
		bookAppointmentPage.enterComments(comments);
		AppointmentConfirmationPage appointmentConfirmationPage = bookAppointmentPage.clickBookAppointmentBtn();

		assertEquals(facility, appointmentConfirmationPage.getTextFacility());
		assertEquals(true, appointmentConfirmationPage.isTrueApplyForHospitalReadmission());
		assertEquals(healthCareProgramoption, appointmentConfirmationPage.getTextHealthcareProgram());
		assertEquals(visitDate, appointmentConfirmationPage.getTextVisitdate());
		assertEquals(comments, appointmentConfirmationPage.getTextComments());

	}

	@DataProvider(name = "appointmentData")
	public Object[][] getData() {
		return new Object[][] { { "Seoul CURA Healthcare Center", "Medicaid", "23/03/2000", "CommentText" } };
	}

}
