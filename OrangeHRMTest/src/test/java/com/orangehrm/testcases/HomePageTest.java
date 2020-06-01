package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.ContactsPage;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage lp;
	HomePage hp;
	ContactsPage cp;

	public HomePageTest() {
		super();
	}

	// Test cases should be separated -- independent with each other
	// Before each test case -- launch the browser and login
	// @test -- execute test case
	// After each test case -- close the browser
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		cp=new ContactsPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String hpTitle = hp.verifyHomePageTitle();
		Assert.assertEquals(hpTitle, "Cogmento CRM", "Home page title not matched");
	}

	@Test(priority = 2)
	public void verifyUserNameLabelTest() {
		String userName = hp.verifyUserName();
		Assert.assertEquals(userName, "Johny K", "User name not matched");
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() throws InterruptedException
	{
		cp=hp.clickOnContactsLink();
		Thread.sleep(3000);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
