package Keywords;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Generic 
  {
	  public WebDriver driver;
	  public String projectpath = System.getProperty("user.dir");
      public FileInputStream fis;
      public Properties mainprop;
      public Properties childprop;
      public Properties orprop;
      public ExtentTest test;
      
	
	public void OpenBrowser(String Browsername)
	{
		
		//test.log(Status.INFO, "opening browser :" +childprop.getProperty(Browsername));
		log("opening browser :" +childprop.getProperty(Browsername));
		//System.out.println("opening browser");
		
		if(childprop.getProperty(Browsername).equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if(childprop.getProperty(Browsername).equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
	}
	public void Navigate (String url)
	{
		 //test.log(Status.INFO, "Navigating url :" +childprop.getProperty(url));
		log("Navigating url :" +childprop.getProperty(url));
		driver.get(childprop.getProperty(url));
	}
	
	
	 public  WebElement getelement(String locatorkey) 
     {
    	 WebElement element = null;
    	 if(!isElementPresent(locatorkey));
    	 //report
    	 System.out.println("Element is not present"+ locatorkey);
    	 
    	 element = driver.findElement(getlocator(locatorkey));
    	 
			
		return element;
		
		
	}




     
   public  boolean isElementPresent(String locatorkey) 
   
   {
	   //test.log(Status.INFO, "check for element present :" +locatorkey);
	   log("check for element present :" +locatorkey);
	   
		//System.out.println("check for element present.....");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(getlocator(locatorkey)));
			
		} catch (Exception e) {
			
			return false;
		}
		return true;
	}
   
   public  By getlocator(String locatorkey)
   {
	   By by=null;
			   
	if(locatorkey.endsWith("_id")) {
		by=By.id(orprop.getProperty(locatorkey));
	}else if(locatorkey.endsWith("_name")) {
		by=By.name(orprop.getProperty(locatorkey));
	}else if(locatorkey.endsWith("_classname")) {
		by=By.className(orprop.getProperty(locatorkey));
	}else if(locatorkey.endsWith("_xpath")) {
		by=By.xpath(orprop.getProperty(locatorkey));
	}else if(locatorkey.endsWith("_linktext")) {
		by=By.linkText(orprop.getProperty(locatorkey));
	}else if(locatorkey.endsWith("_partiallinktext")) {
		by=By.partialLinkText(orprop.getProperty(locatorkey));
	}else if(locatorkey.endsWith("_css")) {
		by=By.cssSelector(orprop.getProperty(locatorkey));
	}
	return by;
	   
   }
   
   
	public void Click(String locatorkey)
	{
         getelement(locatorkey).click();
	}
	public void Select(String locatorkey,String optionkey)
	{
		getelement(locatorkey).sendKeys(childprop.getProperty(optionkey));
	}
	
	public void Type(String locatorkey, String Textkey)
	{
		getelement(locatorkey).sendKeys(childprop.getProperty(Textkey));
	}
	public String GetText()
	{
		return null;
		
	}
	public void closebrowser()
	{
		
	}
	public void setReport(ExtentTest test)
	{
		this.test =test;
	}
	//reportingsfunctions
	public void log(String msg)
	{
		test.log(Status.INFO, msg);
	}
	

}
