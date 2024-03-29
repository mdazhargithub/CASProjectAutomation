package testCases;

import org.testng.annotations.Test;

import pageObjects.OneCognizant;
import pageObjects.WorldClockPage;
import testBase.BaseClass;

public class TC_003_AlphabatesTest extends BaseClass {
	
	
	@Test(priority=2)
	public void alphabatescheck() throws InterruptedException {
		OneCognizant onec = new OneCognizant(driver);
		onec.clickonecognizant();
		onec.viewallapps();
		onec.randomappscreenshot();
		
	}

}
