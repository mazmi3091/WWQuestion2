package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Util.Lib;

public class Homepg extends Lib {

	// Method to verify if page title is as expected
	public static void verifyTitle(WebDriver driver) {
		String expected = "Weight Loss Program, Recipes & Help | Weight Watchers";
		String title = getTitle(driver);

		try {
			Assert.assertEquals(expected, title);
			System.out.println("Homepage - Title Verified!\n");
			System.out.println("Title: " + title);
		} catch (AssertionError e) {
			System.out.println("Incorrect Page Title: Homepage");
			System.out.println("Homepage - Exptected Title: " + expected);
			System.out.println("Homepage - Actual Title: " + title);
		}
	}

	// Method to click on the "Find a Meeting" link on top right corner
	public static void findMeeting(WebDriver driver, String element) throws IOException {
		WebElement elem = findElemID(driver, readProperty(element));
		elem.click();
	}
}
