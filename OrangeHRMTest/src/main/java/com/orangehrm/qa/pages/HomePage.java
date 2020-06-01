package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.orangehrm.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//*[@class='user-display']") WebElement userName_lbl;
	@FindBy(xpath="//*[text()='Contacts'][@class='item-text']") WebElement contacts_lnk;
	@FindBy(xpath="//*[text()='Deals'][@class='item-text']") WebElement deals_lnk;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public String verifyUserName()
	{
		return userName_lbl.getText();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contacts_lnk.click();
		return new ContactsPage();
	}
	
	public DealsPage ClickOnDealsLink()
	{
		deals_lnk.click();
		return new DealsPage();
	}
	
	
}
