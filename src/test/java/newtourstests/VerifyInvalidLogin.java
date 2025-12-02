package newtourstests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import framework.core.BaseTest;
import framework.pages.LoginPage;

public class VerifyInvalidLogin extends BaseTest {

	@Test(priority = 0)
	public void verifyInvalidLogin() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin("adm", "qw");
		assertTrue(loginPage.getLoginFailedMsg(driver).trim().equals("Enter your userName and password correct"),
				"Login faied msg not displayed");

	}

}
