package Rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.reusablecomponents.AbstractComponent;

public class ProductCatlogue extends AbstractComponent {
	WebDriver driver;
	public ProductCatlogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css=".mb-3")
	List<WebElement> Product;
	By ProductBy =By.cssSelector(".mb-3");
	By addtocart=By.cssSelector(".card-body button:last-of-type");
	By toastappear=By.cssSelector("#toast-container");
	@FindBy(css=".ng-animating")
	WebElement Loader;
	public List<WebElement>getproductList() {
		Waitforelementappear(ProductBy);
		return Product;
		
	}
	public WebElement getproductbyname(String addproduct) {
		WebElement Prod=getproductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(addproduct)).findFirst().orElse(null);
		return Prod;
	}
   public void addproducttocart(String addproduct ) {
	   WebElement prod = getproductbyname(addproduct);
	   prod.findElement(addtocart).click();
	   Waitforelementappear(ProductBy);
	   Waitforelementdisappear(Loader);
   }
}
