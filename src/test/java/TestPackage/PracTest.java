package TestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(utilities.ITestListenerUtil.class)
public class PracTest {
	public static WebDriver driver;
	@Test
	public void alertTest() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("ABC");
		driver.findElement(By.cssSelector("#alertbtn")).click();
		String alertText=driver.switchTo().alert().getText();
	    System.out.println("Alert Text: "+alertText);
	    driver.switchTo().alert().accept();
	    Assert.fail();
	}

}
