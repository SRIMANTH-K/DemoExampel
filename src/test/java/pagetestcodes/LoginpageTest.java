package pagetestcodes;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;

import BaseClass.BaseTest;
import pageActions.LoginPage;

public class LoginpageTest extends BaseTest {

	public WebDriver driver;
	public static final Logger logger = Logger.getLogger(LoginpageTest.class.getName());

	@BeforeTest
	public void initializationbrowser() throws IOException {

		driver = setup();

		driver.manage().window().maximize();
	}

	@Test

	public void login() throws InterruptedException {

		logger.info("launching url");
		Thread.sleep(10);
		driver.get(prop.getProperty("url"));
		logger.info("crating object for class to acces methods in Loginpage class");
		LoginPage lp = new LoginPage(driver);

		logger.info("clicking login button in hoome Page");
		lp.clicklogin().click();

		logger.info("Generating one excel utility file to read exceld data");
		Xls_Reader read = new Xls_Reader("D:\\Excel Data\\DataDrivenTest.xlsx");

		int rowcount = read.getRowCount("Sheet1");

		for (int rowNum = 2; rowNum <= rowcount; rowNum++) {

			String email = read.getCellData("Sheet1", "Email", rowNum);

			String pass = read.getCellData("Sheet1", "Passwrod", rowNum);
			Thread.sleep(10);
			logger.info("Clearing the email filed box");
			lp.emailid().clear();
			logger.info("Sending email data from Excel sheet");
			lp.emailid().sendKeys(email);
			logger.info("Sending password data from Excel sheet");
			lp.enterpass().sendKeys(pass);
			logger.info("click on login button");
			lp.submit().click();
			logger.info("click on forgotpassword button");
			lp.passwordforgot().click();
			logger.info("Sending reenter mail details thorugh excel ");
			String Resendemailid = read.getCellData("Sheet1", "Resendemailid", rowNum);
			logger.info("Sending reenter mail details");
			lp.enteringmailid().sendKeys(Resendemailid);
			logger.info("click on giving instructors button");
			lp.givinginstruction().click();
			logger.info("click on again login button");
			lp.loginagain().click();

		}

	}

	@AfterTest
	public void closebrowsersuccessfully() {

		logger.info("Finally closing browser");
		driver.close();
	}
}
