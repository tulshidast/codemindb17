package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParellelTesting {

	WebDriver driver;

	@Test(groups = { "sanity" })
	public void verifyPageTitle() {

		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours", "Title not matched");
	}

	@Test(groups = { "smoke" })
	public void verifyPageUrl() {

		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/test/newtours/", "Url not matched");

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
