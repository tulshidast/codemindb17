package framework.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	protected WebDriver driver;

	@BeforeClass
	public void setUp() {
		DriverManager dm = DriverManager.getInstance();
		driver = dm.getDriver();
		driver.get(Utilities.getProperty("newtoursurl"));

	}

	@AfterClass
	public void terDown() {
		DriverManager.getInstance().quitDriver();
	}

}
