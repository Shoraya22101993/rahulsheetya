package Rahulshettyacademy.reusablecomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Rahulshettyacademy.pageobjects.OrderHistoryPage;
import Rahulshettyacademy.pageobjects.Productdetails;

public class AbstractComponent {

	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[routerlink*='cart']")
	WebElement Cartbutton;
	@FindBy(css="[routerlink*='myorders']")
	WebElement OrderHeader;
	
	public Productdetails goToCartPage() {
		Cartbutton.click();
		Productdetails productdetailspage= new Productdetails(driver);
		return productdetailspage;
	}
	public OrderHistoryPage goToorderHistory() {
		OrderHeader.click();
		OrderHistoryPage orderhistorypage = new OrderHistoryPage (driver);
		return orderhistorypage;
	}
	public void Waitforelementappear(By findBy) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void WaitforWebelementappear(WebElement findBy) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	public void Waitforelementdisappear(WebElement  findBy) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(findBy));
	}
	public void Actionmethod(WebElement findBy,String Search) {
		Actions a= new Actions(driver);
		a.sendKeys(findBy,Search).build().perform();
	}
}
