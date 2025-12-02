package seleniumpractices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {

	private static WebDriver driver;

	private Utility() {

	}

	public static String readProperty(String key) {

		File file = new File("src/test/resources/master.properties");

		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Properties properties = new Properties();
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return properties.getProperty(key);
	}

	public static ArrayList<String> readExcelData(String sheetName) {
		File file = new File("src/test/resources/registration_data.xlsx");

		ArrayList<String> udata = new ArrayList<>();
		udata.clear();

		try {

			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);
			XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);

			int lastRowNumber = xssfSheet.getLastRowNum();

			for (int i = 1; i <= lastRowNumber; i++) {
				XSSFRow xssfRow = xssfSheet.getRow(i);

				int lastCellNumber = xssfRow.getLastCellNum();

				for (int j = 0; j < lastCellNumber; j++) {
					XSSFCell xssfCell = xssfRow.getCell(j);

					String s = xssfCell.getStringCellValue();

					udata.add(s);

				}
			}
			xssfWorkbook.close();

		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return udata;

	}

	public static void takesScreenshot(WebDriver driver, String name) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("src/test/resources/screenshot/" + name + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver(String browser) {


			if (browser.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			}

			else if (browser.equalsIgnoreCase("firefox")) {

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			}

			else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			}

			else {
				System.out.println("Invalid browser name");
			}

		return driver;

	}

}
