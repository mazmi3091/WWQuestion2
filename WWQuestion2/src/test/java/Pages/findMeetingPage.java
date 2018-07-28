package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Util.Lib;

public class findMeetingPage extends Lib {

	// Method to verify if page title is as expected
	public static void verifyTitle(WebDriver driver) {
		String expected = "Get Schedules & Times Near You";
		String title = getTitle(driver);

		try {
			Assert.assertEquals(expected, title);
			System.out.println("Page Meeting - Title Verified!");
		} catch (AssertionError e) {
			System.out.println("Incorrect Page Title: Find Meeting Page");
			System.out.println("Find Meeting Page - Exptected Title: " + expected);
			System.out.println("Find Meeting Page - Actual Title: " + title);
		}
	}

	// Method to enter zip code in the search bar
	public static void enterZipcode(WebDriver driver, String element) throws IOException {
		WebElement elem = findElemID(driver, readProperty(element));
		elem.sendKeys("10011");
	}

	// Method to click search button for results
	public static void searchButton(WebDriver driver, String element) throws IOException {
		WebElement elem = findElemClass(driver, readProperty(element));
		elem.click();
	}

	// Method to print title and distance on console to confirm correct information
	public static void titleAndDistance(WebDriver driver, String name, String dist) throws IOException {
		WebElement title = findElemClass(driver, readProperty(name));
		WebElement distance = findElemClass(driver, readProperty(dist));
		System.out.println("\nTitle and Distance: " + title.getText() + " - " + distance.getText());
	}

	// Method to click on the first result after search 
	public static void clickFirstStore(WebDriver driver, String element) throws IOException {
		WebElement elem = findElemClass(driver, readProperty(element));
		elem.click();
	}

}
