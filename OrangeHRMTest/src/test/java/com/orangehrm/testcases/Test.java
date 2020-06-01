package com.orangehrm.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	WebDriver driver;

	@org.testng.annotations.Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://ui.cogmento.com/");
		driver.findElement(By.name("email")).sendKeys("kjohny513@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Johny@933");
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		driver.findElement(By.xpath("//*[text()='Contacts'][@class='item-text']")).click();
		driver.get(driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		//driver.get(driver.getCurrentUrl());
		
		
		Thread.sleep(4000);
		//driver.quit();
	}
}
