package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Lib {

	// COMMON METHODS
	
	public static String getTitle(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}

	public static WebElement findElemID(WebDriver driver, String id) {
		WebElement elem = driver.findElement(By.id(id));
		return elem;
	}

	public static WebElement findElemClass(WebDriver driver, String classname) {
		WebElement elem = driver.findElement(By.className(classname));
		return elem;
	}

	public static String readProperty(String key) throws IOException {
		File file = new File("C:\\Users\\xxthe\\Desktop\\WWQuestion2\\WWQuestion2\\locator.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}

	public static void takeScreenshot(WebDriver driver, String name) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("C:\\Users\\xxthe\\Desktop\\WWQuestion2\\WWQuestion2\\locator.properties\\Screenshot_" + name
						+ ".png"));
	}


}
