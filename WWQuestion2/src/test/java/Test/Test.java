package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import Pages.Homepg;
import Pages.findMeetingPage;
import Pages.fifthAveStorePage;;

public class Test {

	public WebDriver driver;
	public String path = "C:\\Users\\xxthe\\Desktop\\WWQuestion2\\WWQuestion2\\chromedriver.exe";
	public String baseUrl = "https://www.weightwatchers.com/us/";

	@BeforeTest
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@org.testng.annotations.Test
	public void test() throws IOException {

		Homepg.verifyTitle(driver);
		Homepg.findMeeting(driver, "findMeeting");

		findMeetingPage.verifyTitle(driver);
		findMeetingPage.enterZipcode(driver, "enterZip");
		findMeetingPage.searchButton(driver, "searchButton");
		findMeetingPage.titleAndDistance(driver, "firstTitle", "locationDistance");
		findMeetingPage.clickFirstStore(driver, "fifthAveStore");

		fifthAveStorePage.verifyTitle(driver);
		fifthAveStorePage.todayHoursOfOperation(driver, "todayDay", "todayHours");

	}

	@AfterTest
	public void teardown() {
		System.out.println("Testing Complete!!");
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
