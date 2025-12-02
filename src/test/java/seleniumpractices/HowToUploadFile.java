package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToUploadFile {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load a new web page in the current browser window.
		driver.get(Utility.readProperty("url"));

		driver.manage().window().maximize();

		WebElement fileUploader = driver.findElement(By.xpath("//input[@id='uploadfile']"));

		fileUploader.sendKeys("C:\\Users\\Admin\\Documents\\PremiumpaymentReceipt_28344767_.pdf");

	}

}
