package seleniumpractices;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleSelectDropdownCommingUnderSelectTag {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load a new web page in the current browser window.
		driver.get(Utility.readProperty("url"));

		driver.manage().window().maximize();

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='drop1']"));

		Select select = new Select(dropdown);

		List<WebElement> allOptions = select.getAllSelectedOptions();

		for (WebElement option : allOptions) {
			System.out.println(option.getText());
		}

		System.out.println("############################################");

		WebElement firstSelectedOption = select.getFirstSelectedOption();

		System.out.println(firstSelectedOption.getText());

		System.out.println("############################################");

		List<WebElement> allOptionsFromDropdown = select.getOptions();

		for (WebElement option : allOptionsFromDropdown) {
			System.out.println(option.getText());
		}

		System.out.println("############################################");

		System.out.println("Is multiple = " + select.isMultiple());

		System.out.println("############################################");

		select.selectByIndex(1);

		Thread.sleep(2000);

		select.selectByValue("jkl");

		Thread.sleep(2000);

		select.selectByVisibleText("doc 4");

		Thread.sleep(2000);

		select.selectByContainsVisibleText("Older");

	}

}
