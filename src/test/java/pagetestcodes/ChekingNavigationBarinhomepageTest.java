package pagetestcodes;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.BaseTest;
import pageActions.HomePage;


public class ChekingNavigationBarinhomepageTest extends BaseTest {

	public WebDriver driver;
	public static final Logger logger = Logger.getLogger(ChekingNavigationBarinhomepageTest.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		logger.info("Using BaseTest class setup method");
		driver = setup();
		
		logger.info("Maximising browser");
		driver.manage().window().maximize();
	}

	@Test

	public void checknavigationbar() throws InterruptedException {

		logger.info("launching url");
		Thread.sleep(10);
		driver.get(prop.getProperty("url"));
		logger.info("crating object for class to access methods in HomePage class");

		HomePage hp = new HomePage(driver);

		logger.info("Giving Assert condition if navigation bar is displayed  and pass the testcase");
		if (hp.checkingnavigatiobar().isDisplayed()) {

			Assert.assertTrue(true);
			
		
			
		}

		else if (hp.checkingnavigatiobar().isDisplayed()) {

			Assert.assertTrue(false);
			// logger.info("Giving Assert condition if navigation bar is not displayed anad
			// fail the testcase");
			System.out.println("Navigationbar is not  displayed");

			// logger.info("If in case navigation bar is not displaed");

		}
	}

	@AfterTest
	public void closebrowsersuccessfully() {

		logger.info("Finally closing browser");
		driver.close();
	}

}
