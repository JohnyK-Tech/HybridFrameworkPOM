package com.orangehrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\johny\\eclipse-workspace\\OrangeHRMTest\\src\\main\\java\\com\\orangehrm\\qa\\config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
			 driver=new ChromeDriver();
		} else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		
		e_driver =new EventFiringWebDriver(driver);
		eventListener =new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	public static void waitForElement(WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void sendKeys(WebElement element, String keys) {
	    for (int i = 0; i < keys.length(); i++){
	        element.sendKeys(Character.toString(keys.charAt(i)));
	        //waitUntil(attributeContains(element, "value", keys.substring(0, i)));
	    }
	}

}
