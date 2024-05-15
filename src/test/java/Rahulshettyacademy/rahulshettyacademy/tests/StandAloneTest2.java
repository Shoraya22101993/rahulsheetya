package Rahulshettyacademy.rahulshettyacademy.tests;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Rahulshettyacademy.pageobjects.OrderHistoryPage;
import Rahulshettyacademy.pageobjects.ProductCatlogue;
import Rahulshettyacademy.pageobjects.ProductOrderPage;
import Rahulshettyacademy.pageobjects.Productdetails;
import Rahulshettyacademy.rahulshettyacademy.TestComponents.BaseTest;

public class StandAloneTest2 extends BaseTest{
	String addproduct="ZARA COAT 3";
    @Test(dataProvider="getdata",groups={"Purchaseorder"})
	public void Endtoendtest(HashMap<String,String> input) throws IOException,InterruptedException {
		// TODO Auto-generated method stub
		ProductCatlogue productcatlogue= landingpage.Loginapp(input.get("Email"),input.get("Password"));
		List<WebElement> Productlist=productcatlogue.getproductList();
		productcatlogue.addproducttocart(input.get("Productname"));
		Productdetails productdetailspage=productcatlogue.goToCartPage();
		Boolean match= productdetailspage.matchProduct(input.get("Productname"));
		Assert.assertTrue(match);
		ProductOrderPage productorderPage=productdetailspage.checkoutPage();
		productorderPage.productorder(input.get("Shipcountry"));
		Assert.assertTrue(productorderPage.Confirmationmessage().equalsIgnoreCase("Thankyou for the order."));
		
		
}
    @Test(dependsOnMethods={"Endtoendtest"})
    public void GotoOrderHistory() {
    	ProductCatlogue productcatlogue= landingpage.Loginapp("anshika@gmail.com","Iamking@000");
    	OrderHistoryPage orderhistorypage=productcatlogue.goToorderHistory();
    	Assert.assertTrue(orderhistorypage.VerifyProductDisplay(addproduct));
    	
    	
    }
    @DataProvider
    public Object[][] getdata() throws IOException {
    	List<HashMap<String,String>> data= getjsondataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Rahulshettyacademy\\rahulshettyacademy\\Testdata\\productorder.json");
		return new Object [] [] {{data.get(0)},{data.get(1)}};
    }
}
    
 /*  // parametrize data through array
  *  @DataProvider
    public Object[][] getdata() {
    	return new Object [][] {{"anshika@gmail.com","Iamking@000","ZARA COAT 3","india"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL","india"}};
}
*/
 /*  @DataProvider
   public Object[][] getdata() {
	   HashMap<Object,Object> hm = new HashMap<Object,Object>();
	   hm.put("Email","anshika@gmail.com" );
	   hm.put("Password","Iamking@000" );
	   hm.put("Productname","ZARA COAT 3");
	   hm.put("Shipcountry", "india");
	   HashMap<Object,Object> hm1 = new HashMap<Object,Object>();
	   hm1.put("Email","shetty@gmail.com" );
	   hm1.put("Password","Iamking@000" );
	   hm1.put("Productname","ADIDAS ORIGINAL");
	   hm1.put("Shipcountry", "india");
	   return new Object [][] {{hm},{hm1}};
	   
   }
    */
    
    
    
    
