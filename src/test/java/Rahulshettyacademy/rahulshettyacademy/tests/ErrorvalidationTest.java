package Rahulshettyacademy.rahulshettyacademy.tests;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Rahulshettyacademy.pageobjects.Landingpage;
import Rahulshettyacademy.pageobjects.ProductCatlogue;
import Rahulshettyacademy.pageobjects.ProductOrderPage;
import Rahulshettyacademy.pageobjects.Productdetails;
import Rahulshettyacademy.rahulshettyacademy.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorvalidationTest extends BaseTest{
    @Test(groups={"ErrorHandling"})
	public void LoginErrorValidation() throws IOException,InterruptedException {
		// TODO Auto-generated method stub
		landingpage.Loginapp("anshika12@gmail.com","Iamking123@000");
		Assert.assertEquals("Incorrect email  password.",landingpage.getErrorMsg());
		
		
		
}
    @Test
    public void Producterrorvalidation() throws IOException,InterruptedException {
		// TODO Auto-generated method stub
    	String addproduct="ZARA COAT 3";
		ProductCatlogue productcatlogue= landingpage.Loginapp("anshika@gmail.com","Iamking@000");
		List<WebElement> Productlist=productcatlogue.getproductList();
		productcatlogue.addproducttocart(addproduct);
		Productdetails productdetailspage=productcatlogue.goToCartPage();
		Boolean match= productdetailspage.matchProduct("ZARA COAT 33");
		Assert.assertFalse(match);
    }
		
}
