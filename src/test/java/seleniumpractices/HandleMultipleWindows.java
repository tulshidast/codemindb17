package seleniumpractices;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleWindows {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load a new web page in the current browser window.
		driver.get(Utility.readProperty("url"));

		driver.manage().window().maximize();

		String parentWindowHandle = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[@id='selenium143']")).click();

		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String handle : allWindowHandles) {
			if (!(handle.equals(parentWindowHandle))) {
				driver.switchTo().window(handle);
				break;
			}
		}

		System.out.println(driver.getTitle());

		WebElement selenium143Link = driver.findElement(By.xpath("//a[text()='Install Selenium IDE']"));

		selenium143Link.click();

		driver.close();

		driver.switchTo().window(parentWindowHandle);

		driver.findElement(By.cssSelector("#ta1")).sendKeys("Welcome back to parent window");

	}

}
