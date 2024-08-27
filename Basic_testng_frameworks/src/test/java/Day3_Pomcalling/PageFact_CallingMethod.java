package Day3_Pomcalling;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Day03_10062024.PageFact_ORHMLogin;
import Day03_10062024.PageFact_ORHMLogout;

public class PageFact_CallingMethod {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		PageFact_ORHMLogin pfin= new PageFact_ORHMLogin(driver);
		PageFact_ORHMLogout pfout= new PageFact_ORHMLogout(driver);
		
		pfin.url();
		pfin.Enterusernm("Admin");
		pfin.Enterpass("admin123");
		pfin.clickloginbtn();
		
		pfout.clickProfile();
		pfout.clicklogoutbtn();
		
		driver.close();

	}

}
