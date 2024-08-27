package Day03_10062024;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFact_ORHMLogout {

WebDriver driver;
	
	public PageFact_ORHMLogout(WebDriver idriver) {
		driver=idriver;
		PageFactory.initElements(driver, this);
	}
	//Repository
	@FindBy (className="oxd-userdropdown-tab") WebElement profile;
	@FindBy (linkText="Logout") WebElement logoutbtn;
	
	
	
//	//Repository
//		By Profile = By.className("");
//		
//		By logoutbtn= By.linkText("");
//
//
//		
//		public void clickProfile() {
//			driver.findElement(Profile).click();
//		}
//		
//		public void clicklogoutbtn() {
//			driver.findElement(logoutbtn).click();
//		}

	public void url() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	public void clickProfile() {
		profile.click();
		
	}
	
	public void clicklogoutbtn() {
		logoutbtn.click();
	}

}
