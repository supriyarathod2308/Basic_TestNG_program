package Day3_Pomcalling;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Day03_10062024.ORHM_LoginPom;
import Day03_10062024.ORHM_LogoutPom;

public class CallingPOM {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		ORHM_LoginPom olin= new ORHM_LoginPom(driver);
		ORHM_LogoutPom olout= new ORHM_LogoutPom(driver);
		
		olin.url();
		olin.Enterusernm("Admin");
		olin.Enterpass("admin123");
		olin.clickloginbtn();
		
		olout.clickProfile();
		olout.clicklogoutbtn();
		

	}

}
