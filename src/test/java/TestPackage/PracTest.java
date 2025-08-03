package TestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracTest {

	public static void main(String[] args) {

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("ABC");
		driver.findElement(By.cssSelector("#alertbtn")).click();
		String alertText=driver.switchTo().alert().getText();
	    System.out.println("Alert Text: "+alertText);
	    driver.switchTo().alert().accept();
	}

}
