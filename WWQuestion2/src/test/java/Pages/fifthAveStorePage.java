package Pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Util.Lib;

public class fifthAveStorePage extends Lib {

	// Method to verify if page title is as expected
	public static void verifyTitle(WebDriver driver) {
		String expected = "WEIGHT WATCHERS STORE 23RD ST-5TH AVE";
		String title = getTitle(driver);

		try {
			Assert.assertEquals(expected, title);
			System.out.println("5th Ave Store - Title Verified!");
		} catch (AssertionError e) {
			System.out.println("Incorrect Page Title: Find Meeting Page");
			System.out.println("5th Ave Store Page - Exptected Title: " + expected);
			System.out.println("5th Ave Store Page - Actual Title: " + title);
		}
	}

	// Method to print day and hours of operation for 5th Ave Branch
	public static void todayHoursOfOperation(WebDriver driver, String day, String hour) throws IOException {
		WebElement todayDay = findElemClass(driver, readProperty("todayDay"));
		WebElement todayHours = findElemClass(driver, readProperty("todayHours"));
		System.out.println("\n" + todayDay.getText() + ": " + todayHours.getText());
	}

}
