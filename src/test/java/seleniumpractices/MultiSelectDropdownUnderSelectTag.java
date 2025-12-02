package seleniumpractices;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelectDropdownUnderSelectTag {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load a new web page in the current browser window.
		driver.get(Utility.readProperty("url"));

		driver.manage().window().maximize();

		Select select = new Select(driver.findElement(By.cssSelector("#multiselect1")));

		List<WebElement> allOptions = select.getOptions();

		for (WebElement option : allOptions) {
			System.out.println(option.getText());
		}

		System.out.println("######################First selected option############################");

		select.selectByIndex(0);

		select.selectByValue("swiftx");

		WebElement firstSelectedOption = select.getFirstSelectedOption();

		System.out.println("First selected option = " + firstSelectedOption.getText());

		System.out.println("######################All Selected options############################");

		allOptions.clear();

		allOptions = select.getAllSelectedOptions();

		for (WebElement option : allOptions) {
			System.out.println(option.getText());
		}

		System.out.println("###################is multiple###################");

		System.out.println("Is multiple = " + select.isMultiple());

		System.out.println("################################################");

		select.selectByVisibleText("Audi");

		select.selectByContainsVisibleText("Hyun");

		Thread.sleep(2000);

		select.deselectAll();

		Thread.sleep(2000);

		select.selectByIndex(0);

		select.selectByValue("swiftx");

		select.selectByVisibleText("Audi");

		select.selectByContainsVisibleText("Hyun");

		Thread.sleep(2000);

		select.deSelectByContainsVisibleText("Swi");

		Thread.sleep(2000);

		select.deselectByIndex(2);

		Thread.sleep(2000);

		select.deselectByValue("volvox");

		Thread.sleep(2000);

		select.deselectByVisibleText("Audi");

	}

}
