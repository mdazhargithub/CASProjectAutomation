package pageObjects;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class OneCognizant extends BasePage{

	public OneCognizant(WebDriver driver) {
		super(driver);
		
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	public void clickonecognizant() throws InterruptedException {
		String home_handle = driver.getWindowHandle();
		WebElement onecognizant = driver.findElement(By.xpath("//div[contains(text(),\"OneCognizant\")]"));
		// scroll till one cog
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", onecognizant);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),\"OneCognizant\")]")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),\"OneCognizant\")]")).click();
		Thread.sleep(2000);
		System.out.println("Clicked on OneCognizant link ");

		Set<String> all_handles = driver.getWindowHandles();
		Thread.sleep(3000);
		
		for (String handles : all_handles) {
			String st = driver.switchTo().window(handles).getTitle();
			Thread.sleep(3000);
			if (st.equals("OneCognizant")) {
				break;
			}
		}
		
		
		}
	
	public void viewallapps() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Switched to the new window ");
		Thread.sleep(9000);
		WebElement webapp = driver.findElement(By.className("viewAllHotAppsBtn"));
		// js.executeScript("document.getElementsByClassName('viewAllHotAppsBtn').scrollBy(0,1000)");
//		js.executeScript("arguments[0].scrollBy(0,1500);", webapp);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),\"View All Apps\")]")));
		Thread.sleep(3000);
		System.out.println("Checked View all apps link is clickable");
		WebElement viewall = driver.findElement(By.xpath("//div[contains(text(),\"View All Apps\")]"));
		js.executeScript("arguments[0].click();", viewall);

//      Validate A-Z Alphabets are displayed in App Store header.
		List<WebElement> all_alphabates = driver.findElements(By.xpath("//div[@class=\"aZHolder\"]/div"));
		String header_alphabates = "";
		for (int i = 0; i < all_alphabates.size() - 1; i++) {
			String alphabates = all_alphabates.get(i).getText();

			header_alphabates += alphabates;
		}
		System.out.println(header_alphabates);

		if (header_alphabates.toLowerCase().equals("abcdefghijklmnopqrstuvwxyz")) {
			System.out.println("All alphabates from A to Z verified ");
		} else {
			System.out.println("All alphabates from A to Z not found ");
		}
		System.out.println();

		// get random app details
		WebElement random_app_j = driver
				.findElement(By.xpath("//*[@id=\"divAppstoreContainer\"]/div[1]/div/div/div[2]/div/div[10]"));
		js.executeScript("arguments[0].click;", random_app_j);
		
//      Fetching apps details 		
		String  name_of_apps = driver.findElement(By.xpath("//*[@id=\"div_appFilteredList\"]/div/div/div/div[4]")).getText();
		System.out.println("App details"+name_of_apps);
		Thread.sleep(1000);

	}
	public void randomappscreenshot() {
		SoftAssert softassert = new SoftAssert();
		TakesScreenshot ts = ((TakesScreenshot) driver);
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File source2 = ts.getScreenshotAs(OutputType.FILE);
		// File dest2= new
		// File("C:\\Users\\2318407\\eclipse-workspace\\CASProject\\screenshots\\appscreenshot.png");
		// FileUtils.copyFile(source2, dest2);

		String targetpath = System.getProperty("user.dir") + "\\screenshots\\" + "appspic" + "_" + timeStamp + ".png";
		File dest2 = new File(targetpath);
		source2.renameTo(dest2);
		System.out.println("Screenshot of random apps taken ");
		System.out.println("Take all assertion ");
		softassert.assertAll();

	}
	
	
}
