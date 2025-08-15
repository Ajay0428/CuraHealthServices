package smoke;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	LoginPage loginPage;
	
	@Test
	public void login() {
		
		loginPage = new LoginPage(driver);
		
		loginPage.clickMakeAppointmentBtn();
		
		System.out.println(driver.getTitle());
			
		
	}
}
