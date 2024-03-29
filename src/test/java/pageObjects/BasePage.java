package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class BasePage {

	WebDriver driver;
	
	public BasePage(WebDriver driver) // constructor to initialize the driver
	{
		this.driver=driver;

	}
}
