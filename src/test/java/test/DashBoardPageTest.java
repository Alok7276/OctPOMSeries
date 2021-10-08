package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Constants;
import utils.ExcelUtil;

public class DashBoardPageTest extends BaseTest {
	@BeforeClass
	public void dashBoardPageSetup() {
		dashBoardPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void dashBoardPageTitleTest() {
		String title = dashBoardPage.getDashBoardPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void headerTest() {
		Assert.assertTrue(dashBoardPage.verifyHeaderExist());
	}

	@Test(priority = 3, dataProvider = "getCandidateTestData")
	public void addCandidateTest(String firstName, String middleName, String lastName, String emailId, String contactNo,
			String jobVacancy) throws InterruptedException {
		dashBoardPage.addCandidates(firstName, middleName, lastName, emailId, contactNo, jobVacancy);
	}

	@DataProvider
	public Object[][] getCandidateTestData() {
		return ExcelUtil.getTestData(Constants.CANDIDATE_SHEET_NAME);
	}
}
