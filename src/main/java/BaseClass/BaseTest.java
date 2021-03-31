package BaseClass;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	public static final Logger logger = Logger.getLogger(BaseTest.class.getName());
	public WebDriver driver;

	public Properties prop;

	public WebDriver setup() throws IOException {

		logger.info("creating properties file object");
		prop = new Properties();

		logger.info("Giving log4j Path");
		String log4jpath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\log4j.properties";

		PropertyConfigurator.configure(log4jpath);
		logger.info("Giving data properties path");
		String datapropertiesfile = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Data.properties";

		FileInputStream fis = new FileInputStream(datapropertiesfile);

		prop.load(fis);

		logger.info("Getting browser Property File Data");
		
		//String browsername = System.getProperty("browser");
		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {

			logger.info("set Chrome driver path");
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
			logger.info("creating driver object for chrome");
			driver = new ChromeDriver();

		}

		else if (browsername.equals("firefox")) {
			logger.info("set Firefox driver path");
			System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver-v0.28.0-win64\\geckodriver.exe");
			logger.info("creating driver object for firefox");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {

		logger.info("Generating failure screenshot code");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\failedscreenshot\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}
}