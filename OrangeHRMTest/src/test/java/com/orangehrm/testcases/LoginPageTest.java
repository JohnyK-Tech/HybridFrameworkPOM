package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage lp;
	HomePage homePage;	 
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		 lp=new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title=LoginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		homePage=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
	
}
