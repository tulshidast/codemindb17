package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdvancedActionsInSelenium {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load a new web page in the current browser window.
		driver.get("https://www.google.com/");

		driver.manage().window().maximize();

		WebElement textField = driver.findElement(By.xpath("//textarea[@name='q']"));

		Actions actions = new Actions(driver);

//		actions.click(textField).build().perform();

//		actions.contextClick(textField).build().perform();
//		
//		actions.doubleClick(textField).build().perform();

		actions.moveToElement(driver.findElement(By.xpath("//a[@aria-label='Google apps']"))).build().perform();

		actions.keyDown(Keys.SHIFT).keyDown(textField, "a").keyUp(Keys.SHIFT).keyUp("a").keyDown("p").keyUp("p").build()
				.perform();

		driver.navigate().to("https://jqueryui.com/droppable/");

		Thread.sleep(7000);

		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

		WebElement source = driver.findElement(By.cssSelector("#draggable"));
		WebElement target = driver.findElement(By.cssSelector("#droppable"));

		actions.dragAndDrop(source, target).build().perform();

	}

}
