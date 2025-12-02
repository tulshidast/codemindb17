package seleniumpractices;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverMethods {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get(Utility.readProperty("url"));

		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current opened url = " + currentUrl);

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

		String title = driver.getTitle();

		System.out.println("Title of the page = " + title);

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

		String pageSource = driver.getPageSource();

		// System.out.println(pageSource);

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		String windowHandle = driver.getWindowHandle();
		System.out.println("Currently focussed window handle = " + windowHandle);

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

		driver.switchTo().newWindow(WindowType.TAB).get("https://www.flipkart.com/");

		Set<String> windowsHandles = driver.getWindowHandles();

		for (String handle : windowsHandles) {
			System.out.println(handle);
		}

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

		// driver close will close currently focused tab or window
		driver.close();

		driver.switchTo().window(windowHandle);

		driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.amazon.in/");

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

		driver.quit();

	}

}
