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

public class TextverifyTest extends BaseTest {

	public WebDriver driver;
	public static final Logger logger = Logger.getLogger(TextverifyTest.class.getName());

	@BeforeTest
	public void openbrowser() throws IOException {
		logger.info("Using BaseTest setup method");
		driver = setup();
		logger.info("Maximising browser");
		driver.manage().window().maximize();
	}

	@Test

	public void textverify() throws InterruptedException {

		logger.info("launching url");
		Thread.sleep(10);
		driver.get(prop.getProperty("url"));
		logger.info("crating object for class to access methods in HomePage class");

		HomePage hp = new HomePage(driver);

		String text = hp.TextChecking().getText();
		System.out.println("The currenet text is :"  +  text);
		
		
		String Expected = "Featured courses";
		logger.info("Passing Assert Actual ,Assert Expected conditions");
		Assert.assertEquals(text, Expected);
		logger.info("Passing assert false condition");
		Assert.assertTrue(false);
	}
	
	@AfterTest
	public void closebrowsersuccessfully() {

		//logger.info("Giving Assert condition if text  is displayed  and pass the testcase");
		
		logger.info("Finally closing browser");
		//System.out.println("TEXT IS Presented on home page");
		driver.close();
	}

}
