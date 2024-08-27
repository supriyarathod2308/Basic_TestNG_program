package AssignmenTs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Assignment_03 {
	WebDriver driver;
	@BeforeSuite
	public void setup() 
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/login.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	 
	}
	 
	@DataProvider(name="dataset")
	

	public Object[][] userData() {
		Object[][] Data=new Object[][] {
			{ "mngr137366", "jUgyjAn" },
			{ "mngr137370", "uvetahA" }, 
			{ "mngr137371", "utYmEqY" } 
			};
			return Data;
	}
	
	
	@Test(dataProvider="dataset")
	public void login(String email, String password) 
	{
		
		WebElement Email=driver.findElement(By.name("email"));
		Email.sendKeys(email);
		WebElement Password=driver.findElement(By.name("passwd"));
		Password.sendKeys(password);
		driver.findElement(By.name("SubmitLogin")).click();
		driver.navigate().back();
		Email.clear();
		Password.clear();
		
	}
	
	@AfterSuite
	public void closedriver() {
		driver.close();
	}

}
