package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {
	
	public static ExtentReports reports;
	
	public static ExtentReports getReport() {
		
		if(reports==null) {
			String path= System.getProperty("user.dir")+"\\Report\\extentReport.html";
			ExtentSparkReporter spark= new ExtentSparkReporter(path);
			reports= new ExtentReports();
			reports.attachReporter(spark);
			reports.setSystemInfo("Tester", "Baishali");
			reports.setSystemInfo("OS", System.getProperty("os.name"));
		}
		
		return reports;
		
	}
	
	public static void openReport() throws IOException {
		String path= System.getProperty("user.dir")+"\\Report\\extentReport.html";
		try {
			File file= new File(path);
			if(file.exists()) {
				Desktop.getDesktop().browse(file.toURI());
				System.out.println("Report is Opened");
			}
			else {
				System.out.println("Report Not Opened");

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
