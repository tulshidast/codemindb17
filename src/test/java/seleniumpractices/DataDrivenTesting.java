package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTesting {

	WebDriver driver;

	@Test(priority = 1, dataProvider = "users")
	public void verifyUsersLogin(String uname, String password, String msg) {

		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		String actualLoginSuccessMsg = driver.findElement(By.xpath("//h3[text()='Login Successfully']")).getText();

		Assert.assertEquals(actualLoginSuccessMsg, msg, "Login failed!!");

	}

	@DataProvider(name = "users")
	public String[][] dataProvider() {

		String userCredentials[][] = { { "user", "user", "Login Successfully" },
				{ "admin", "admin@123", "Login Successfully" } };
		return userCredentials;

	}

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility.getDriver("chrome");
		synchronized (driver) {

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Load a new web page in the current browser window.
			driver.get("https://demo.guru99.com/test/newtours/");

			driver.manage().window().maximize();
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
