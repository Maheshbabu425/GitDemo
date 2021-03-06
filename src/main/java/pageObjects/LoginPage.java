package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	WebDriver driver;
		
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By email=By.cssSelector("[id='user_email']");
	By passowrd=By.cssSelector("[type='password']");
	@FindBy(xpath = "//input[@type='submit']")
	WebElement login;

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(passowrd);
	}
	public WebElement getlogin()
	{
		return login;
	}
	
}
