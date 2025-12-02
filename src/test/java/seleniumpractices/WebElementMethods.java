package seleniumpractices;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementMethods {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get(Utility.readProperty("url"));
		driver.manage().window().maximize();

		WebElement textArea = driver.findElement(By.cssSelector("textarea#ta1"));

		System.out.println(textArea.getAccessibleName());

		System.out.println("############################################");

		System.out.println(textArea.getAriaRole());

		System.out.println("############################################");

		System.out.println(textArea.getAttribute("cols"));

		System.out.println("############################################");

		String backgroundColor = driver.findElement(By.cssSelector("button.dropbtn")).getCssValue("background-color");
		System.out.println(backgroundColor);

		System.out.println(driver.findElement(By.cssSelector("button.dropbtn")).getCssValue("font-size"));

		System.out.println("############################################");
		Point point = textArea.getLocation();

		System.out.println(point.getX());
		System.out.println(point.getY());

		System.out.println("############################################");

		Rectangle rectangle = textArea.getRect();
		System.out.println(rectangle.height);
		System.out.println(rectangle.width);
	}

}
