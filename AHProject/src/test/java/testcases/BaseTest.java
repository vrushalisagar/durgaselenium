package testcases;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Keywords.Application;
import reportings.ExtentManager;

public class BaseTest
{
	public  Application app; // object creating coz we have to use all keyword classes
	public static ExtentReports rep;
	public static ExtentTest test;
	
  @BeforeTest
  public void BeforeTest(ITestContext context) throws Exception  
  {
	  app = new Application();
	  context.setAttribute("app", app);
	  System.out.println("BeforeTest");
	  
	  //initialising reporting for the test
	   rep = ExtentManager.getReports();
	  test= rep.createTest(context.getCurrentXmlTest().getName());//in xml suit in method whatever test is executing
	                                                              // that testname capturing here
	  app.setReport(test);
	  context.setAttribute("report", rep);
	  context.setAttribute("test", test);
	  
  }                              
  
  @BeforeMethod
  public void BeforeMethod(ITestContext context) 
  {
	  System.out.println("BeforeMethod");
	  app = (Application)context.getAttribute("app");
	  
	 rep=(ExtentReports) context.getAttribute("report");
	 test = (ExtentTest)context.getAttribute("test");
	  
	  
  }
  @AfterTest
 public void quit() {
	  if(rep !=null)
		  rep.flush();
  }
}
