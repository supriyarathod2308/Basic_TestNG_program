package AssignmenTs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {
	WebDriver driver;
	
	@BeforeTest
	public void Setup(){
		
		driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
		
	@Test
	public void runtask() 
	{
		
		driver.findElement(By.xpath("//ul[@class='header links']/child::li[2]/a")).click() ;
		driver.findElement(By.id("email")).sendKeys("supriyaahmed10@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Peyu@5225");	
		driver.findElement(By.id("send2")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ea-stickybox-hide']")));
		driver.findElement(By.xpath("//div[@class='ea-stickybox-hide']")).click();

	}
//	@AfterTest
//	public void close() {
//		driver.close();
//	}
	
}
