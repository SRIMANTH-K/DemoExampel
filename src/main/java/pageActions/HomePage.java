package pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseTest;

public class HomePage extends BaseTest {

	public WebDriver driver;

	@FindBy(xpath = "//nav[@class='navbar-collapse collapse']/ul")

	WebElement Navigationbarcheck;

	public WebElement checkingnavigatiobar() {

		return Navigationbarcheck;

	}

	@FindBy(xpath = "//div[@class='text-center']/h2")

	WebElement checkingtext;

	public WebElement TextChecking() {

		return checkingtext;
	}

	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

}
