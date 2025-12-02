package seleniumpractices;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenUsingExcel {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load a new web page in the current browser window.
		driver.get("https://demo.guru99.com/test/newtours/register.php");

		driver.manage().window().maximize();

		ArrayList<String> userData = Utility.readExcelData("Sheet1");

		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(userData.get(0));
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(userData.get(1));
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(userData.get(2));
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(userData.get(3));

	}

}
