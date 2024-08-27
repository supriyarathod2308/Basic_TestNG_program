package Day02_07062024;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> table=driver.findElements(By.xpath("//table[@name='BookTable']/child::tbody/child::tr/child::td"));
//===============================to print only one specific row put child::td[1] in above link
		
		System.out.println(table.size());
		
		for(int i=0;i<table.size();i++) {
			String tdata=table.get(i).getText();
			System.out.println(tdata);
		}

		//driver.close();
	}

}
