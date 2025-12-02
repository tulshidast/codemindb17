package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToHandleFrames {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load a new web page in the current browser window.
		driver.get(Utility.readProperty("url"));

		driver.manage().window().maximize();

		// driver.switchTo().frame(0);

		// driver.switchTo().frame("navbar-iframe");

		WebElement frame = driver.findElement(By.xpath("//iframe[@id='navbar-iframe']"));

		driver.switchTo().frame(frame);

		driver.findElement(By.xpath("//input[@name='q' and not(@title)]")).sendKeys("Handling frames");

		driver.switchTo().defaultContent();

		driver.findElement(By.cssSelector("#ta1")).sendKeys("Welcome back to main page");

	}

}
