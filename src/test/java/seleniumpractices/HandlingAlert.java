package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlert {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load a new web page in the current browser window.
		driver.get(Utility.readProperty("url"));

		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("#confirm")).click();

		Alert alt = driver.switchTo().alert();

		String msg = alt.getText();

		System.out.println(msg);

		alt.accept();

		// alt.dismiss();

		driver.findElement(By.cssSelector("textarea[cols='30']")).clear();

	}

}
