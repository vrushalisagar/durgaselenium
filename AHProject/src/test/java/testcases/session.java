package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class session  extends BaseTest
{
  @Test
  public void dologin() 
  {
	 // System.out.println("dologin");
	 // test.log(Status.INFO, "Loging Inn....");
	  
	  app.log( "Loginin.....");
	  app.OpenBrowser("chromebrowser");
	  app.Navigate("rediffurl");
	  app.Click("signin_linktext");
	  app.Type("useremail_id", "rediffuser");
	  app.Type("userpassword_id","rediffpassword");
	  app.Click("submit_id");
	 // app.OpenBrowser("chromebrowser");
	//  app.Navigate("rediffurl");
	//  app.Click("signin_linktext");
	 // app.Type("useremail_id", "rediffuser");
	 // app.Type("userpassword_id", "rediffpassword");
	  //app.Click("submit_id");
	  
  }
  @Test
  public void dologout() 
  {
	  
	  //test.log(Status.INFO, "Loging out....");
	  app.log("Loging out....");
  }
}
