package Keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

public class Application extends Validation
{

	 
	public Application() throws IOException 
	{
		mainprop = new Properties();
		childprop = new Properties();
		orprop = new Properties();
		
		try {
			fis = new FileInputStream(projectpath+"\\src\\test\\resources\\enviornment.properties");
			mainprop.load(fis);
			 String e = mainprop.getProperty("env");
			 
			 fis = new FileInputStream(projectpath+"\\src\\test\\resources\\"+e+".properties");
			 childprop.load(fis);
			 
			 fis = new FileInputStream(projectpath+"\\src\\test\\resources\\or.properties");
			 orprop.load(fis);
			 
		}
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		softAssert = new SoftAssert();
				
	}
	public void Login()
	{
		
	}
	public void SelectDateFormCalander()
	{
		
	}
	public void reportfailure(String failuremsg) 
	{
		softAssert.fail(failuremsg);
		test.log(Status.FAIL, failuremsg);
		
	}
	public void assertall() 
	{
		softAssert.assertAll();
		
	}

}
