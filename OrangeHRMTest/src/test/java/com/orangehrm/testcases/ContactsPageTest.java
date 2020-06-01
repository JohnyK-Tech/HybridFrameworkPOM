package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.ContactsPage;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		cp = new ContactsPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		cp = hp.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(cp.verifyContactsLabel(), "Contacts page is not displayed.");
	}

	@Test(priority = 2)
	public void SelectSingleContactsTest() throws InterruptedException {
		driver.get(driver.getCurrentUrl());
		Thread.sleep(3000);
		cp.selectContactByName("test2 k");
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void SelectMultipleContactsTest() throws InterruptedException {
		driver.get(driver.getCurrentUrl());
		Thread.sleep(4000);
		cp.selectContactByName("test2 k");
		cp.selectContactByName("test k");
		Thread.sleep(2000);
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][]=TestUtil.getTestData("Contacts");
		return data;
	}
	
		
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String firstname,String lastname,String category,String descrip,String fullname) throws InterruptedException
	{
		driver.get(driver.getCurrentUrl());
		Thread.sleep(2000);
		cp.clickOnNew();
		//cp.createNewContact("John", "smith", "Contact", "Testing");
		cp.createNewContact(firstname, lastname, category, descrip);
		Assert.assertEquals(cp.checkCreatedContact(), fullname,"Contact is not created");
				
	}
	
	@DataProvider
	public Object[][] getCRMTestData1()
	{
		Object data[][]=TestUtil.getTestData("DeleteContact");
		return data;
	}
	
	//dependsOnMethods = {"validateCreateNewContact"}
	@Test(priority = 5 ,dataProvider = "getCRMTestData1")
	public void deleteContact(String fillName) throws InterruptedException
	{
		driver.get(driver.getCurrentUrl());
		Thread.sleep(2000);
		cp.selectContactByName(fillName);
		cp.deleteContact();
				
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
