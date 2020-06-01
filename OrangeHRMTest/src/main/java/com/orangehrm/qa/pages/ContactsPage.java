package com.orangehrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	
	
	@FindBy(xpath="//div[text()='Contacts']") WebElement contacts_lbl;
	@FindBy(xpath="//button[text()='New']") WebElement new_btn;
	@FindBy(name="first_name") WebElement firstName;
	@FindBy(name="last_name") WebElement lastName;
	@FindBy(name="description") WebElement description;
	@FindBy(xpath="//button[text()=\"Save\"]") WebElement save_btn;
	@FindBy(xpath="//*[@name='category'][@role='listbox']") WebElement category_list;
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']") WebElement newContact_lbl;
	
	@FindBy(xpath="//*[@class='ui selection upward dropdown']") WebElement actions_list;
	@FindBy(xpath="//*[text()='Delete']") WebElement delete_opt;
	@FindBy(xpath="//*[@class=\"ui basic icon left attached button\"]") WebElement actionConfirm;
	@FindBy(xpath="//button[text()='Delete']") WebElement deleteConfirm;
	
	
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		return contacts_lbl.isDisplayed();
	}
	
	public void selectContactByName(String name)
	{
		driver.findElement(By.xpath("//td[text()='"+name+"']")).click();
	}
	
	public void clickOnNew()
	{
		new_btn.click();
	}
	
	public void selectCategory(String category)
	{
		category_list.click();
		driver.findElement(By.xpath("//*[ text()='"+category+"']")).click();
	}
	
	public void createNewContact(String firstname,String lastname,String category,String descrip) throws InterruptedException 
	{
		sendKeys(firstName, firstname);
		//firstName.sendKeys(firstname);
		//lastName.sendKeys(lastname);
		sendKeys(lastName, lastname);
		selectCategory(category);
		description.sendKeys(descrip);
		save_btn.click();
		Thread.sleep(2000);
				
	}
	
	public String checkCreatedContact()
	{
		String title= newContact_lbl.getText();
		System.out.println(title);
		return title;
	}
	
	public void deleteContact() throws InterruptedException
	{
		actions_list.click();
		delete_opt.click();
		actionConfirm.click();
		deleteConfirm.click();
		Thread.sleep(4000);
		
	}
	
	
}
