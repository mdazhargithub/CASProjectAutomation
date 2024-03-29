package pageObjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class WorldClockPage  extends BasePage{
	
	public WorldClockPage(WebDriver driver) {
		super(driver);
			
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	public void validation() throws InterruptedException {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("O365_MainLink_Help_container")));		
		Actions act = new Actions(driver);
		WebElement user_element = driver.findElement(By.id("meInitialsButton"));
	    act.moveToElement(user_element).perform();
        act.doubleClick(user_element).build().perform();
	    Thread.sleep(3000);
	}
	
	public void accountscrenshot() throws InterruptedException {
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\2318407\\eclipse-workspace\\CASProject\\screenshots\\Accountdetails.png");
		try {
			FileUtils.copyFile(src, dest);
			System.out.println("Screenshot of Account details has been taken ");
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		String account_details = driver.findElement(By.xpath("//*[@id=\"mectrl_currentAccount_secondary\"]")).getText();
		Thread.sleep(1200);
		
		Assert.assertEquals(account_details, "2318407@cognizant.com");
		
		System.out.println("Account details of 2318407 validated");
			
		}
	
	public void worldclock() throws InterruptedException {
		Thread.sleep(1200);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement section = driver
				.findElement(By.xpath("//*[@id=\"spPageCanvasContent\"]/div/div/div/div/div/div[2]"));
		js.executeScript("arguments[0].scrollIntoView();", section);
		Thread.sleep(3000);

		WebElement world_clock = driver
				.findElement(By.xpath("//*[@id=\"spPageCanvasContent\"]/div/div/div/div/div/div[2]"));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"spPageCanvasContent\"]/div/div/div/div/div/div[2]")));
		Assert.assertEquals(world_clock.isDisplayed(), true);
		System.out.println("World clock display validated ");

	}
	
	public void localdate() throws InterruptedException {
		LocalDate date = LocalDate.now();
		String current_date = date.format(DateTimeFormatter.ofPattern("M/dd/yyyy"));
		System.out.println("Current local date is : " + current_date);

		Thread.sleep(2000);
		WebElement dateel = driver.findElement(By.xpath(
				"//*[contains(@id,'WorldClock')]/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/div[2]/div[2]"));

		Thread.sleep(2000);
		String exp_date = dateel.getText().split(" ")[1];
		System.out.println("Expected local date is : " + exp_date);
		Assert.assertEquals(current_date, exp_date, " Current date and Expected date found different");
		System.out.println("Expected and Current date validated");
		
	}
	
	public void localdateandtime() throws InterruptedException {
		LocalTime ist = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mma");
		String formated_time = ist.format(formatter);

		Thread.sleep(2000);
		WebElement time_element = driver.findElement(By.xpath(
				"//*[contains(@id,\"WebPart.WorldClock\")]/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/div[1]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[contains(@id,\"WebPart.WorldClock\")]/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/div[1]")));
		String exp_time = time_element.getText();
		System.out.println(formated_time + " : " + exp_time);
		Assert.assertEquals(formated_time, exp_time, "Expected and Current time found different");
	
}
	public void Timezonesvalidation() throws InterruptedException {
		
//      Fetching New York time from be cognizant
		WebElement nyk = driver.findElement(By.xpath(
				"//*[contains(@id,'WorldClock')]/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[1]/span[1]"));
		String exp_nyktime = nyk.getText().split("A|P")[0];
		System.out.println("Expected New York time is : " + exp_nyktime);
//      Fetching New York time zone difference from be cognizant
		WebElement nyk_diff = driver.findElement(By.xpath(
				"//*[contains(@id,\"WorldClock\")]/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[2]/div[1]"));
//      Checking New York time zone is displayed or not 		
		nyk_diff.isDisplayed();
		
		System.out.println("New York time zone difference section is successfully displayed");
		String exp_nyk_diff = nyk_diff.getText();
		System.out.println("New York time zone difference is : "+ exp_nyk_diff);
//      Fetching London time from be cognizant
		WebElement london = driver.findElement(By.xpath(
				"//*[contains(@id,\"WebPart.WorldClock\")]/div/div[2]/div/div/div/div/div[1]/div[2]/div/div/div/div[2]/div[1]"));
		String exp_londontime = london.getText().split("A|P")[0];
		System.out.println("Expected London time is : " + exp_londontime);
//      Fetching London time zone difference from be cognizant 
		WebElement london_diff = driver.findElement(By.xpath(
				"//*[contains(@id,\"WorldClock\")]/div/div[2]/div/div/div/div/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]"));
//      Checking london time difference is displayed or not
		london_diff.isDisplayed();
		
		System.out.println("London time zone difference section is successfully displayed");

		String exp_london_diff = london_diff.getText();
		System.out.println("London time difference is : " + exp_london_diff);

		// driver.switchTo().newWindow(WindowType.TAB);

		
		SoftAssert softassert = new SoftAssert();
		
//		driver.navigate().to("https://www.google.com");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("london time", Keys.ENTER);
//		Thread.sleep(2000);
		
//		 Fetching London time from Google data 
		
		Thread.sleep(1200);
		driver.navigate().to("https://www.google.com/search?q=london+time&sca_esv=c3f69c090f238cd5&source=hp&ei=bXrxZf2INpHF1e8Pz-CisAU&iflsig=ANes7DEAAAAAZfGIfTnBPDu9s0BLRbfdGzMDWol4n9gR&ved=0ahUKEwi98_zS_vCEAxWRYvUHHU-wCFYQ4dUDCA0&uact=5&oq=london+time&gs_lp=Egdnd3Mtd2l6Igtsb25kb24gdGltZUjqFVAVWOINcAB4AJABAJgBAKABAKoBALgBA8gBAPgBAZgCAKACAJgDAJIHAKAHAA&sclient=gws-wiz");
		Thread.sleep(1200);
		
		WebElement ellondon = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]"));
		Thread.sleep(2000);
		String act_londontime = ellondon.getText().split("a|p")[0];
		
//      Fetching New York time from Google data 

		Thread.sleep(1200);
		driver.navigate().to("https://www.google.com/search?q=new+york+time+now&sca_esv=c3f69c090f238cd5&source=hp&ei=bXrxZf2INpHF1e8Pz-CisAU&iflsig=ANes7DEAAAAAZfGIfTnBPDu9s0BLRbfdGzMDWol4n9gR&oq=New+&gs_lp=Egdnd3Mtd2l6IgROZXcgKgIIADIKEAAYgAQYigUYQzIKEAAYgAQYigUYQzINEC4YgAQYigUYQxixAzIKEAAYgAQYigUYQzIKEAAYgAQYigUYQzIKEAAYgAQYigUYQzIIEAAYgAQYsQMyChAAGIAEGIoFGEMyCBAuGIAEGLEDMgUQABiABEjXFVDTAliMB3AAeACQAQCYAeoDoAGZDaoBBzItMi4yLjG4AQHIAQD4AQGYAgWgArENqAIKwgIdEAAYgAQYigUY5QIY5QIY6gIYtAIYigMYtwMY1APCAgoQLhiABBiKBRhDwgIREC4YgAQYsQMYgwEYxwEY0QPCAgsQABiABBixAxiDAcICERAuGIAEGIoFGLEDGIMBGOUEmAPxA5IHBzItMi4yLjGgB-kp&sclient=gws-wiz");
		Thread.sleep(1200);

		WebElement elnewyork = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]"));
		Thread.sleep(2000);
		String nyktime = elnewyork.getText().split("a|p")[0];

//      Validating London time with google data 
		
		if (act_londontime.length() == 5) {
			String act_londontime1 = act_londontime.substring(0, 4);
			softassert.assertEquals(act_londontime1, exp_londontime, " Expected and Actual London time found different");
			System.out.println(
					"Actual London time is : " + act_londontime1 + "Expected London time is : " + exp_londontime);
		} else {
			String act_londontime2 = act_londontime.substring(0, 5);
			softassert.assertEquals(act_londontime2, exp_londontime, " Expected and Actual London time found different");
			System.out.println(
					"Actual London time is : " + act_londontime2 + "Expected London time is : " + exp_londontime);
		}

//      Validating New York time with google data 
		
		if (nyktime.length() == 5) {
			String act_nyktime1 = nyktime.substring(0, 4);
			softassert.assertEquals(act_nyktime1, exp_nyktime, " Expected and Actual New York time found different");
			System.out.println(
					"Actual New York time is : " + act_nyktime1 + "Expected New York time is : " + exp_nyktime);
		}

		else {
			String act_nyktime2 = nyktime.substring(0, 5);
			softassert.assertEquals(act_nyktime2, exp_nyktime, " Expected and Actual New York time found different");
			System.out.println(
					"Actual New York time is : " + act_nyktime2 + "Expected New York time is : " + exp_nyktime);
		}



		// SoftAssert softassert = new SoftAssert();
//     Validating london time zone difference		
		softassert.assertEquals(exp_london_diff, "5h 30m behind");
		System.out.println("Time zone difference validated for London");

//      Validate Time zone difference is displayed correctly for New York Location.
		softassert.assertEquals(exp_nyk_diff, "9h 30m behind");
		System.out.println("Time zone diference validated for New York time");
		
	}
//    Navigating back to home page 	
	public void backtohomepage() {
		driver.navigate().to("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
		System.out.println("Switched to home page again");
	}
	
	
	
}

