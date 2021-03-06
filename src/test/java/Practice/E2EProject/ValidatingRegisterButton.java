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

public class ValidatingRegisterButton extends Base {
	public WebDriver driver;
	public static Logger log =  LogManager.getLogger(Base.class.getName());

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

		// To check the register button is displayed on the landing page
		
		
		Assert.assertTrue(l.checkRegister().isDisplayed());
		System.out.println(l.checkRegister().getText());
		log.info("Checked. UI page having Register button");

	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
