package seleniumpractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverMethod2Class {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get(Utility.readProperty("url"));
		driver.manage().window().maximize();

		driver.navigate().to("https://www.amazon.in/");

		Thread.sleep(3000);

		driver.navigate().back();

		Thread.sleep(3000);

		driver.navigate().forward();

		Thread.sleep(3000);

		driver.navigate().refresh();

		driver.navigate().back();

		WebElement textArea = driver.findElement(By.cssSelector("#ta1"));

		textArea.sendKeys("Sample text");

		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));

		System.out.println("Number of radio buttons = " + radioButtons.size());

		driver.quit();

	}

}
