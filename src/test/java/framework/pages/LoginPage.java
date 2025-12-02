package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.core.BasePage;
import framework.core.Utilities;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//input[@name='userName']")
	WebElement userNameTextField;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordTextField;

	@FindBy(xpath = "//input[@name='submit']")
	WebElement submitButton;

	@FindBy(xpath = "//span[normalize-space()='Enter your userName and password correct']")
	WebElement loginFailedMsg;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void doLogin(String uname, String password) {
		userNameTextField.sendKeys(uname);
		passwordTextField.sendKeys(password);
		submitButton.click();
	}

	public boolean isSubmitBtnEnabled() {
		return submitButton.isEnabled();
	}

	public String getLoginFailedMsg(WebDriver driver) {
		Utilities.waitfoElementToBeVisible(driver, loginFailedMsg);
		return loginFailedMsg.getText();
	}

}
