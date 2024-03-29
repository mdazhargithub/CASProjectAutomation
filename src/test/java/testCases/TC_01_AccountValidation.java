package testCases;

import org.testng.annotations.Test;

import pageObjects.OneCognizant;
import pageObjects.WorldClockPage;
import testBase.BaseClass;

public class TC_01_AccountValidation extends BaseClass{
	

	@Test(priority=0)
	  public void accountinfovalidation() throws InterruptedException {

		WorldClockPage  wc = new WorldClockPage(driver);
		  wc.validation();
		  wc.accountscrenshot();
	  }

}
