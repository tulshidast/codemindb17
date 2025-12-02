package seleniumpractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorStatergies {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get(Utility.readProperty("url"));
		driver.manage().window().maximize();

		WebElement textArea = driver.findElement(By.id("ta1"));

		textArea.sendKeys("Welcome to codedisha");

		driver.findElement(By.name("userid")).sendKeys("admin");

		String title = driver.findElement(By.className("title")).getText();

		System.out.println(title);

		List<WebElement> textAreas = driver.findElements(By.tagName("textarea"));

		System.out.println(textAreas.size());
		
		//driver.findElement(By.linkText("http://www.Selenium143.blogspot.com")).click();
		
		driver.findElement(By.partialLinkText("http://www.Selenium143.blogs")).click();

	}

}
