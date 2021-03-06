package Practice.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class Home extends Base {
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// h.baseNavigationPage();
	}

	
	@Test(dataProvider = "getData")
	public void baseNavigationPage(String Username, String Password) throws IOException {
		driver = initilizationBrowser();
		log.info("Driver is intialised");
		
		// driver.get("http://qaclickacademy.com/");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		driver.manage().window().maximize();
		log.info("Window Maximized");;
		driver.manage().deleteAllCookies();
		log.info("Coockies Deleted");

		// one is inheritance
		// Creating object to that class and invoke methods of it
		driver.findElement(By.xpath("//*[text()='NO THANKS']")).click();
		log.info("Alert box closed");

		LandingPage l = new LandingPage(driver);
	//	l.getLogin().click();
		LoginPage lp= l.getLogin();
		log.debug("login button clicked");

	//	LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getlogin().click();
		log.info("Successfully data loaded");

	}
	
	@DataProvider
	public Object[][] getData() {

		// Rows stands for how many different data types test should run
		// column stand for how many values per each test
		Object[][] data = new Object[1][2];
		data[0][0] = "mahesh@gmail.com";
		data[0][1] = "12345";
		//data[1][0]="babu@gmail.com";
		//data[1][1]="67890";

		return data;

	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
