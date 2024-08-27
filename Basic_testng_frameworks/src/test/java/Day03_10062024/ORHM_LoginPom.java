package Day03_10062024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ORHM_LoginPom {
	WebDriver driver;
	
	public ORHM_LoginPom(WebDriver driver) {
		this.driver=driver;
	}
	//Repository
	By usernm = By.name("username");
	By pass= By.name("password");
	By loginbtn= By.xpath("//button[@type='submit']");


	public void url() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	public void Enterusernm(String un) {
		driver.findElement(usernm).sendKeys(un);
		
	}
	
	public void Enterpass(String pwd) {
		driver.findElement(pass).sendKeys(pwd);
	}
	
	public void clickloginbtn() {
		driver.findElement(loginbtn).click();
	}
}