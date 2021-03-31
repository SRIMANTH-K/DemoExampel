package ExtentReportUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ExtentReport {

	
	
	static ExtentReports extent;
	public static ExtentReports getfailedtestcasesreports() {

		
		String path = System.getProperty("user.dir") + "\\extentreports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Web Application Testing");
		reporter.config().setTheme(Theme.DARK);

		reporter.config().setReportName("QACLICK Academic Website");

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Srimanth");

		return extent;

	}

	

	}

