package smoke;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	LoginPage loginPage;

	@Test(dataProvider = "loginCredentials", groups = "Regression")
	public void login(String username, String password, String message) {

		loginPage = new LoginPage(driver);

		loginPage.clickMakeAppointmentBtn();

		loginPage.userLogin(username, password, message);

	}

	@DataProvider(name = "loginCredentials")
	public Object[][] getData() {

		Object[][] object = { { "John Doe", "ThisIsNotAPassword", "Book Appointment" },
				{ "John Doe", "pass1", "Login failed! Please ensure the username and password are valid." },
				{ "user1", "ThisIsNotAPassword", "Login failed! Please ensure the username and password are valid." },
				{ "", "", "Login failed! Please ensure the username and password are valid." },
				{ "", "pass1", "Login failed! Please ensure the username and password are valid." },
				{ "user1", "", "Login failed! Please ensure the username and password are valid." }
				};
		
		return object;
	}

}
