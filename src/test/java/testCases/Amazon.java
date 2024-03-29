package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Amazon {
	@Test
	public void login () {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.com/");
		
		
	}

}
