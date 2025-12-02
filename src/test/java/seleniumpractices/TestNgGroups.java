package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgGroups {

	WebDriver driver;

	@Test(groups = { "sanity" })
	public void verifyPageTitle() {

		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours", "Title not matched");
	}

	@Test(groups = { "sanity", "smoke" })
	public void verifyPageTitle_1() {

		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours", "Title not matched");
	}

	@Test(groups = { "smoke" })
	public void verifyPageUrl() {

		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/test/newtours/", "Url not matched");

	}

	@Test(priority = 1, groups = { "regression" })
	public void verifyUserLogin() {

		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		String actualLoginSuccessMsg = driver.findElement(By.xpath("//h3[text()='Login Successfully']")).getText();

		String expectedLoginMsg = "Login Successfully";

		Assert.assertEquals(actualLoginSuccessMsg, expectedLoginMsg, "Login failed!!");

	}

	@Test(priority = 2, groups = { "regression" })
	public void verifyAdminLogin() {

		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		String actualLoginSuccessMsg = driver.findElement(By.xpath("//h3[text()='Login Successfully']")).getText();

		String expectedLoginMsg = "Login Successfull";

		Assert.assertEquals(actualLoginSuccessMsg, expectedLoginMsg, "Login failed!!");

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
			driver=null;
		}
	}

}
