package reportings;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	
		 static ExtentReports reports;
		 public static String Screenshotfolderpath;
		 
		 
		 public static ExtentReports getReports()
		 {
			 if(reports==null)
			 {
				 reports = new ExtentReports();
				 Date d = new Date();
				 System.out.println(d.toString().replaceAll(":", "-"));
				 String reportsfolder = d.toString().replaceAll(":", "-")+"//Screenshots";
				 
				 Screenshotfolderpath = System.getProperty("user.dir")+"//reports//"+ reportsfolder;
				 String reportfolderpath = System.getProperty("user.dir")+"//reports//"+ d.toString().replaceAll(":", "-")+"//Screenshot";
				 System.out.println(Screenshotfolderpath);
				 File f = new File (Screenshotfolderpath);
				 f.mkdirs();
				 
				 ExtentSparkReporter sparkreporter = new ExtentSparkReporter("reportfolderpath");
				 sparkreporter.config().setReportName("Production Regression Testing");
				 sparkreporter.config().setDocumentTitle("Automation Testing");
				 sparkreporter.config().setTheme(Theme.STANDARD);
				 sparkreporter.config().setEncoding("utf-8");
				 
				 
				 reports.attachReporter(sparkreporter);
			 }
			 
			 
			 
			return reports;
			 
		 }

	}
