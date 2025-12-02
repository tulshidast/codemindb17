package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrolling {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load a new web page in the current browser window.
		driver.get(Utility.readProperty("url"));

		driver.manage().window().maximize();

		System.out.println(Utility.readExcelData("Sheet1").toString());

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, 500);");

		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0, -300);");

		Thread.sleep(2000);

		js.executeScript("window.scrollBy(100, 0);");

		Thread.sleep(2000);

		js.executeScript("window.scrollBy(-50, 0);");

		Thread.sleep(2000);

		WebElement dropdownBtn = driver.findElement(By.xpath("//button[text()='Dropdown']"));

		js.executeScript("arguments[0].scrollIntoView(true);", dropdownBtn);

		Thread.sleep(2000);

		js.executeScript("window.scrollTo(document.body.scrollWidth, document.body.scrollHeight)");

	}

}
