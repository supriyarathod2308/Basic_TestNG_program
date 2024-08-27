package Day03_10062024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFact_ORHMLogin {

WebDriver driver;
	
	public PageFact_ORHMLogin(WebDriver idriver) {
		driver=idriver;
		PageFactory.initElements(driver, this);
	}
	//Repository
	@FindBy (name="username") WebElement usernm;
	@FindBy (name="password") WebElement pass;
	@FindBy (xpath="//button[@type='submit']") WebElement loginbtn;
	
	
	//By usernm = By.name("username");
	//By pass= By.name("password");
	//By loginbtn= By.xpath("");


	public void url() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	public void Enterusernm(String un) {
		usernm.sendKeys(un);
		
	}
	
	public void Enterpass(String pwd) {
		pass.sendKeys(pwd);
	}
	
	public void clickloginbtn() {
		loginbtn.click();
	}
}
