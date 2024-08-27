package Day02_07062024;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	
	@DataProvider(name="Dataset")
	public Object[][]mobileData()
	{
		 Object[][] Data = new Object[3][2];
		 Data[0][0]="oppo Reno 11";
		 Data[0][1]="onePlus";
		 
		 Data[1][0]="iPhone 15";
		 Data[1][1]="pro max";
		 
		 Data[2][0]="Redmi";
		 Data[2][1]="note";
		 
		return Data;
	}
	
	
	@Test(dataProvider="Dataset")
	public void searchMobile(String brand,String model) {
//============================PopUps exception handling=============================	
		try {	
		WebElement closePopUp=driver.findElement(By.xpath("//span[@class='_30XB9F']"));
		if(closePopUp.isDisplayed()) {
			closePopUp.click();
			Thread.sleep(1000);
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
//====================================================================================	
		WebElement mobile=driver.findElement(By.name("q"));
		mobile.sendKeys(brand+" "+model);
		mobile.sendKeys(Keys.ENTER);
		driver.navigate().back();
		
}

	
	
	
	
	
	
//@AfterSuite
//public void closedriver()
//{
//	driver.close();	
//	
//	}
}
