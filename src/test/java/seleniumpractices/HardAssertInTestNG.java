package seleniumpractices;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertInTestNG {

	@Test
	public void testCase() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load a new web page in the current browser window.
		driver.get("https://demo.guru99.com/test/newtours/");

		driver.manage().window().maximize();

		assertEquals(driver.getTitle(), "Welcome: Mercury Tours");

		assertEquals(driver.getTitle(), "Welcome: Mercury Tours", "Title not marched");

		assertNotEquals(driver.getTitle(), "Welcome: Mercury Tour");

		assertNotEquals(driver.getTitle(), "Welcome: Mercury Tour", "Title not marched");

		assertTrue(driver.getTitle().equals("Welcome: Mercury Tours"));
		assertTrue(driver.getTitle().equals("Welcome: Mercury Tours"), "Title not marched");

		assertFalse(driver.getTitle().equals("Welcome: Mercury Tour"));
		assertFalse(driver.getTitle().equals("Welcome: Mercury Tours"), "Title not marched");

		System.out.println("Post failure");

	}

}
