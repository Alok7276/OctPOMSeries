package test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import factory.DriverFactory;
import pages.DashBoardPage;
import pages.LoginPage;

public class BaseTest {

	WebDriver driver;
	Properties prop;
	DriverFactory df;
	LoginPage loginPage;
	DashBoardPage dashBoardPage;

	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = new Properties();
		prop = df.initProperties();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
