package seleniumpractices;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdownNotCommingUnderSelect {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load a new web page in the current browser window.
		driver.get("https://www.makemytrip.com/flights/vistara-airlines.html");

		driver.manage().window().maximize();

		Thread.sleep(5000);

		selectTripType("return trip");

		Thread.sleep(5000);

		selectTripType("one way");

	}

	public static void selectTripType(String tripType) throws InterruptedException {

		driver.findElement(By.xpath("//label[text()='Trip Type']")).click();

		Thread.sleep(1000);

		List<WebElement> tripTypes = driver.findElements(By.cssSelector("div.tripTypeFilter ul li p"));

		for (WebElement trip : tripTypes) {
			if (trip.getText().equalsIgnoreCase(tripType)) {
				trip.click();
				break;
			}
		}
	}

}
