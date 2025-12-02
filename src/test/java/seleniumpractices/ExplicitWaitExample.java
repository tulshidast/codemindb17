package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitExample {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load a new web page in the current browser window.
		driver.get(Utility.readProperty("url"));

		driver.manage().window().maximize();

		WebElement delayedText = driver.findElement(By.cssSelector("#delayedText"));

		System.out.println("Element visible = " + delayedText.isDisplayed());

		waitfoElementToBeVisible(delayedText, driver, 10);

		System.out.println("Element visible = " + delayedText.isDisplayed());

		driver.findElement(By.xpath("//button[text()='Check this']")).click();

		waitfoElementToBeClickAble(driver.findElement(By.cssSelector("#dte")), driver, 10);

		driver.findElement(By.cssSelector("#dte")).click();

	}

	public static void waitfoElementToBeClickAble(WebElement element, WebDriver driver, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitfoElementToBeVisible(WebElement element, WebDriver driver, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
