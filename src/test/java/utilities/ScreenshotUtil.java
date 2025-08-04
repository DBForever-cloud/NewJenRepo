package utilities;



import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {
	public static  WebDriver driver;
	public static String getScreenshot(WebDriver driver, String methodName) {
		String timeStamp=new SimpleDateFormat("ddMMyyyyhhmmss").format(new Date());
		String path= System.getProperty("user.dir")+"\\Screenshots\\"+timeStamp+"_"+methodName+".png";
		TakesScreenshot ss= (TakesScreenshot) driver;
		File srcFile=ss.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(path);
		try {
			FileHandler.copy(srcFile, targetFile);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return path;
	}

}
