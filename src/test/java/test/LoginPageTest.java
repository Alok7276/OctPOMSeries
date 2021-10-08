package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "OrangeHRM");
	}

	@Test(priority = 2)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Test(priority = 3)
	public void logoTest() {
		Assert.assertTrue(loginPage.isLogoExist());
	}

	@Test(priority = 4)
	public void loginTest() {
		dashBoardPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}
}
