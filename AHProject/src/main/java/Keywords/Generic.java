package Keywords;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import reportings.ExtentManager;

public class Generic 
  {
	  public WebDriver driver;
	  public String projectpath = System.getProperty("user.dir");
      public FileInputStream fis;
      public Properties mainprop;
      public Properties childprop;
      public Properties orprop;
      public ExtentTest test;
      public SoftAssert softAssert;
      
	
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
	

	//reportingsfailure
		public void Reportfailure(String failuremsg)
		{
			softAssert.fail(failuremsg);                //failure in test ng report
			test.log(Status.FAIL, failuremsg);         // failure in extent report
			takescreenshot();
		}
		
		public void Softassert()
		{
			softAssert.assertAll();
		}
		
		 public void takescreenshot()
	     {
	    	 //filename of the screenshot
	    	 Date d = new Date();
	    	String screenshotfile= d.toString().replace(":", "_").replace(" ", "_ ")+".png";
	    	//take screenshot
	    	File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	
	    	
	    	try {
	    		//get the dynamic folder name
	    		
				FileUtils.copyFile(srcfile, new File (ExtentManager.Screenshotfolderpath+"//"+screenshotfile));
				
				//put screenshotfile in report mns attaching screenshot to the extent report
		    	test.log(Status.INFO, "screenshot->"+test.addScreenCaptureFromPath(ExtentManager.Screenshotfolderpath+"//"+screenshotfile));
		    	 
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	     }
			
			
			
		}

