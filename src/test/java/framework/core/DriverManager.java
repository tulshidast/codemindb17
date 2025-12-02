package framework.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private static DriverManager instance = null;

	private DriverManager() {

		if (Utilities.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts()
					.implicitlyWait(Duration.ofMillis(Long.valueOf(Utilities.getProperty("implicitwaittimeout"))));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		} else if (Utilities.getProperty("browser").equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().timeouts()
					.implicitlyWait(Duration.ofMillis(Long.valueOf(Utilities.getProperty("implicitwaittimeout"))));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		}

		else if (Utilities.getProperty("browser").equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts()
					.implicitlyWait(Duration.ofMillis(Long.valueOf(Utilities.getProperty("implicitwaittimeout"))));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		}

		else {

			System.out.println("Please provide valid browser");

		}
	}

	public static DriverManager getInstance() {
		if (instance == null) {
			instance = new DriverManager();
		}
		return instance;
	}

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

}
