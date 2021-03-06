package Practice.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import resources.Base;

public class ValidatingTitle extends Base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(Base.class.getName());

	
	
	@BeforeTest
	public void initiliaze() throws IOException
	{
		driver = initilizationBrowser();
		driver.get(prop.getProperty("url"));

	}
	
	
	@Test
	public void baseNavigationPage() throws IOException {
		//driver = initilizationBrowser();
		//driver.get(prop.getProperty("url"));

		LandingPage l = new LandingPage(driver);
		// Comparing the text from the browser with actual text
		String title = l.getTitle().getText();
		Assert.assertEquals(title, "FEATURED COURSES425");
		System.out.println(title);
		log.info("Title displayed successfully");

	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
