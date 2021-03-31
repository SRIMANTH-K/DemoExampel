package pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseTest;

public class LoginPage extends BaseTest {

	public WebDriver driver;

	@FindBy(xpath = "//*[@id='homepage']/header/div[1]/div/nav/ul/li[4]/a/span")

	WebElement login;

	public WebElement clicklogin() {

		return login;
	}

	@FindBy(xpath = "//*[@id='user_email']")
	WebElement email;

	public WebElement emailid() {

		return email;
	}

	@FindBy(xpath = "//*[@id='user_password']")
	WebElement password;

	public WebElement enterpass() {

		return password;
	}

	@FindBy(xpath = "//*[@id='hero']/div/form/div[3]/input")
	WebElement submit;

	public WebElement submit() {

		return submit;
	}

	@FindBy(xpath = "//*[@id='hero']/div/form/div[4]/a")
	WebElement forgot;

	public WebElement passwordforgot() {

		return forgot;
	}

	@FindBy(xpath = "//*[@id='user_email']")
	WebElement Reentermail;

	public WebElement enteringmailid() {

		return Reentermail;
	}

	@FindBy(xpath = "//*[@id='hero']/div/form/div[2]/input")
	WebElement sendinstructionsbutton;

	public WebElement givinginstruction() {

		return sendinstructionsbutton;
	}

	@FindBy(xpath = "//*[@id='navbarNav']/ul/li[3]/a")
	WebElement againclickloginbutton;

	public WebElement loginagain() {

		return againclickloginbutton;
	}

	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

}
