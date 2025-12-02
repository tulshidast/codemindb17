package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.core.BasePage;

public class LoginSucessPage extends BasePage {

	@FindBy(xpath = "//h3[text()='Login Successfully']")
	WebElement loginSuccessMsg;

	public LoginSucessPage(WebDriver driver) {
		super(driver);
	}

	public String getLoginMsg() {
		return loginSuccessMsg.getText();
	}

}
