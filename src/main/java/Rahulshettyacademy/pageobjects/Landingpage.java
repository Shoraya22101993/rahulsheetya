package Rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import Rahulshettyacademy.reusablecomponents.AbstractComponent;

public class Landingpage extends AbstractComponent {
	WebDriver driver;
	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//@PageFactoryFinder
	@FindBy(id="userEmail")
	WebElement Useremail;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement Submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement errormsg;
	
	
public ProductCatlogue Loginapp(String  Username,String Password) {
	Useremail.sendKeys(Username);
	password.sendKeys(Password);
	Submit.click();	
	ProductCatlogue productcatlogue=new ProductCatlogue(driver);
	return productcatlogue;
}
public void Gotourl() {
	driver.get("https://www.rahulshettyacademy.com/client");
}
public String getErrorMsg() {
	WaitforWebelementappear(errormsg);
	return errormsg.getText();
}

}
