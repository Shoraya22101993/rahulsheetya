package Rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Rahulshettyacademy.reusablecomponents.AbstractComponent;

public class Productdetails extends AbstractComponent {
	WebDriver driver;
	
	public Productdetails(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	private List<WebElement>Cartproducttitle;
	@FindBy(xpath="//li[@class='totalRow']/button")
	WebElement Checkoutbutton;
	
	public Boolean matchProduct(String Products) {
		Boolean Match=Cartproducttitle.stream().anyMatch(Cartitem->Cartitem.getText().equals(Products));
		return Match;	
		
	}
	public ProductOrderPage checkoutPage() {
		Checkoutbutton.click();
		ProductOrderPage productorderPage=new ProductOrderPage(driver);
		return productorderPage;
	}

}
