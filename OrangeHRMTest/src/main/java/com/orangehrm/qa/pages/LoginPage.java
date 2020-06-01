package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory - OP
	
	@FindBy(name="email") WebElement EmailAddress_inpt;
	@FindBy(name="password") WebElement Password_inpt;
	@FindBy(xpath="//*[text()='Login']") WebElement Login_btn;
	@FindBy(xpath="//a[contains(text(),'Sign Up')]") WebElement SignUp_lnk;
	
	//Initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public static String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd)
	{
		EmailAddress_inpt.sendKeys(un);
		Password_inpt.sendKeys(pwd);
		Login_btn.click();
		    	
		return new HomePage();
	}

	

	
	
	
}
