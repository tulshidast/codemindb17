package newtourstests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import framework.core.BaseTest;
import framework.core.Log;
import framework.pages.LoginPage;
import framework.pages.LoginSucessPage;

public class VerifyValidLogin extends BaseTest {

	@Test
	public void verifyValidLogin() {
		LoginPage loginPage = new LoginPage(driver);
		Log.info("Before login");
		loginPage.doLogin("admin", "admin@123");
		Log.info("After login");
		LoginSucessPage loginSucessPage = new LoginSucessPage(driver);
		assertEquals(loginSucessPage.getLoginMsg(), "Login Successfully", "Login failed");
	}

}
