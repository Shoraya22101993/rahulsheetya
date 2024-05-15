package Rahulshettyacademy.rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Rahulshettyacademy.pageobjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public Landingpage landingpage;

public WebDriver intializeDriver() throws IOException {
	// properties class
	Properties prop=new Properties();
	// system.getproperty() create path from project level
	FileInputStream FIS=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Rahulshettyacademy\\resources\\GlobalData.properties");
	prop.load(FIS);
	String browserName=prop.getProperty("browser");
	
	if(browserName.equalsIgnoreCase("chrome")){
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	}
	// firefox
	else if(browserName.equalsIgnoreCase("firefox")){
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		}
	// edge 
	else if(browserName.equalsIgnoreCase("edge")){
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
}
@BeforeMethod(alwaysRun=true)
public Landingpage launchapp() throws IOException {
	WebDriver driver = intializeDriver();
	 landingpage=new Landingpage(driver);
	landingpage.Gotourl();
	return landingpage;
}

// data provider
public List<HashMap<String, String>> getjsondataToMap(String filepath) throws IOException {
	// read json to string
	String jsoncontent= FileUtils.readFileToString(new File(filepath),
			StandardCharsets.UTF_8);
	// convert string to hashmap using jackson data binding
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String, String>> data=mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>(){});
	return data;
	// return map({},{}}	
}
// screenshot
public String getScreenshot(String testCaseName,WebDriver driver)throws IOException{
	TakesScreenshot ts= (TakesScreenshot)driver;
	File Source=ts.getScreenshotAs(OutputType.FILE);
	File file=new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
	FileUtils.copyFile(Source,file);
	return System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png";
}
@AfterMethod(alwaysRun=true)
public void teardown() {
	driver.close();
}
}
