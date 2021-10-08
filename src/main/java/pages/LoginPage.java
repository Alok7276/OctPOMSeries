package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Constants;
import utils.ElementUtil;

public class LoginPage {

	public WebDriver driver;
	public ElementUtil elementUtil;

	private By emailId = By.id("txtUsername");
	private By password = By.id("txtPassword");
	private By loginBtn = By.id("btnLogin");
	private By logo = By.xpath("//img[@src='/webres_6051af48107ce6.31500353/themes/default/images/login/logo.png']");
	private By forgotPwdLink = By.xpath("//a[.='Forgot your password?']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	public boolean isForgotPwdLinkExist() {
		return elementUtil.doIsDisplayed(forgotPwdLink);
	}

	public boolean isLogoExist() {
		return elementUtil.doIsDisplayed(logo);
	}

	public String getLoginPageTitle() {
		return elementUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public DashBoardPage doLogin(String un, String pwd) {
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		return new DashBoardPage(driver);

	}
}
