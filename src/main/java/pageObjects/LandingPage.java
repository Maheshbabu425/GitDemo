package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	
	public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	
	@FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	WebElement title;
	
	By register =By.xpath("//*[text()='Register']");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public LoginPage getLogin()
	{
	//	return driver.findElement(signin);           // Normal way of calling in page object model
		driver.findElement(signin).click();
		LoginPage lp= new LoginPage(driver);
		return lp;
	}
	
	public WebElement getTitle()
	{
		return title;
	}
	public WebElement checkRegister()
	{
		return driver.findElement(register);
	}
}
