package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class portifolioManagement extends BaseTest
{
  @Test
  public void createportifolio()
  {
	  test.log(Status.INFO, "createportifolio....");
	  //System.out.println("createportifolio");
	    app.reportfailure("test  faile");             // this line is for failure report msg in html report
	   app.assertall();
  }
  @Test
  public void deletportifolio()
  {
	  test.log(Status.INFO, "deletportifolio....");
  }
  @Test
  public void modifyportifolio()
  {
	  test.log(Status.INFO, "modifyportifolio....");
  }
}
