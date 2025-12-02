package seleniumpractices;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementMethods2 {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get(Utility.readProperty("url"));
		driver.manage().window().maximize();

		WebElement textArea = driver.findElement(By.cssSelector("textarea#ta1"));

		File file = textArea.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("src/test/resources/screenshot/" + System.currentTimeMillis() + ".png"));

		String tagName = textArea.getTagName();
		System.out.println(tagName);

		String visibleTextOfWebElement = driver
				.findElement(By.xpath("//h2[text()='Disabled Text Box' and @class='title']")).getText();

		System.out.println(visibleTextOfWebElement);

		System.out.println("text area displayed on the page = " + textArea.isDisplayed());

		System.out.println("delyed text displayed on the page = "
				+ driver.findElement(By.cssSelector("#delayedText")).isDisplayed());

		Thread.sleep(10000);

		System.out.println("delyed text displayed on the page after 10 sec= "
				+ driver.findElement(By.cssSelector("#delayedText")).isDisplayed());

		System.out.println("Button 1 is enabled = " + driver.findElement(By.cssSelector("#but1")).isEnabled());
		System.out.println("Button 2 is enabled = " + driver.findElement(By.cssSelector("#but2")).isEnabled());

		textArea.sendKeys("Welcome to Codedisha pune");

		Thread.sleep(2000);

		textArea.clear();

		WebElement maleRadioBtn = driver.findElement(By.cssSelector("#radio1"));

		WebElement femaleRadioBtn = driver.findElement(By.cssSelector("#radio2"));

		WebElement orangeCheckbox = driver.findElement(By.cssSelector("#checkbox1"));

		WebElement blueCheckbox = driver.findElement(By.cssSelector("#checkbox2"));

		System.out.println("Male radio btn is selected = " + maleRadioBtn.isSelected());

		femaleRadioBtn.click();

		System.out.println("Female radio btn is selected = " + femaleRadioBtn.isSelected());

		System.out.println("Orange checkbox is selected = " + orangeCheckbox.isSelected());

		System.out.println("Blue checkbox is selected = " + blueCheckbox.isSelected());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

		file = takesScreenshot.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("src/test/resources/screenshot/" + System.currentTimeMillis() + ".png"));

	}

}
