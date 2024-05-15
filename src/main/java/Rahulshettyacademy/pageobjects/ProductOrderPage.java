package Rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.reusablecomponents.AbstractComponent;

public class ProductOrderPage extends AbstractComponent {
    WebDriver driver;
	public ProductOrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
  
  @FindBy(css="[placeholder='Select Country']")
  WebElement Country;
  By results=By.cssSelector(".ta-results");
  @FindBy(xpath="//button[contains(@class,'ta-item')][2]")
  WebElement Shippedcountry;
  @FindBy(css=".action__submit")
  WebElement Submitbutton;
  @FindBy(css=".hero-primary")
  WebElement confirmation;
  
  public void productorder(String searchcountry) {
	  Actionmethod(Country,searchcountry);
	  Waitforelementappear(results);
	  Shippedcountry.click();
	  Submitbutton.click();
  }
  public String Confirmationmessage() {
	  String confirmmessage=confirmation.getText();
	  return confirmmessage;
  }
}
