package testCases;

import org.testng.annotations.Test;

import pageObjects.OneCognizant;
import pageObjects.WorldClockPage;
import testBase.BaseClass;

public class TC_02_TimezoneTest extends BaseClass{
	
	@Test(priority=1)
	public void timezonecheck() throws InterruptedException {
		WorldClockPage  wc = new WorldClockPage(driver);
		  wc.worldclock();
		  wc.localdate();
		  wc.localdateandtime();
		  wc.Timezonesvalidation();
		  wc.backtohomepage();
		  
	}

}
