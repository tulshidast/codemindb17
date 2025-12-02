package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertInTestNg {

	@Test
	public void testCase() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		SoftAssert verify = new SoftAssert();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load a new web page in the current browser window.
		driver.get("https://demo.guru99.com/test/newtours/");

		driver.manage().window().maximize();

		verify.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");

		verify.assertEquals(driver.getTitle(), "Welcome: Mercury Tours", "Title not marched");

		verify.assertNotEquals(driver.getTitle(), "Welcome: Mercury Tour");

		verify.assertNotEquals(driver.getTitle(), "Welcome: Mercury Tour", "Title not marched");

		verify.assertTrue(driver.getTitle().equals("Welcome: Mercury Tours"));
		verify.assertTrue(driver.getTitle().equals("Welcome: Mercury Tours"), "Title not marched");

		verify.assertFalse(driver.getTitle().equals("Welcome: Mercury Tour"));
		verify.assertFalse(driver.getTitle().equals("Welcome: Mercury Tours"), "Title not marched");

		System.out.println("Post failure");

		verify.assertAll();

	}

}
