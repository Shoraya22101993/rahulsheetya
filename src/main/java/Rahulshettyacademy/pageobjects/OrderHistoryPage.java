package Rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Rahulshettyacademy.reusablecomponents.AbstractComponent;

public class OrderHistoryPage extends AbstractComponent {
	WebDriver driver;
	
	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement>ProductNames;
	@FindBy(xpath="//li[@class='totalRow']/button")
	WebElement Checkoutbutton;
	
	public Boolean VerifyProductDisplay(String Products) {
		Boolean Match=ProductNames.stream().anyMatch(Cartitem->Cartitem.getText().equals(Products));
		return Match;	
		
	}


}
