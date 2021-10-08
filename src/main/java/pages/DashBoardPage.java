package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Constants;
import utils.ElementUtil;

public class DashBoardPage {

	public WebDriver driver;
	public ElementUtil elementUtil;

	private By header = By.xpath("//a[@id='welcome']");
	private By recruitment = By.xpath("//b[.='Recruitment']");
	private By candidate = By.xpath("//a[.='Candidates']");
	private By addCandidateBTn = By.id("btnAdd");
	private By fullName = By.id("addCandidate_firstName");
	private By middleName = By.id("addCandidate_middleName");
	private By lastName = By.id("addCandidate_lastName");
	private By email = By.id("addCandidate_email");
	private By contact = By.className("contactNo");
	private By listBox = By.className("vacancyDrp");
	private By saveBtn = By.id("btnSave");

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getDashBoardPageTitle() {
		return elementUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public boolean verifyHeaderExist() {
		return elementUtil.doIsDisplayed(header);
	}

	public void addCandidates(String fName, String mName, String lName, String emailId, String contactNo, String job)
			throws InterruptedException {
		elementUtil.twoLevelMenuHandle(recruitment, candidate);
		elementUtil.getElement(addCandidateBTn);
		elementUtil.doClick(addCandidateBTn);
		elementUtil.doSendKeys(this.fullName, fName);
		elementUtil.doSendKeys(this.middleName, mName);
		elementUtil.doSendKeys(this.lastName, lName);
		elementUtil.doSendKeys(this.email, emailId);
		elementUtil.doSendKeys(this.contact, contactNo);
		elementUtil.doSelectByVisibleText(listBox, job);
		elementUtil.doClick(saveBtn);

	}
}
