package Day03_10062024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ORHM_LogoutPom {
	
WebDriver driver;
	
	public ORHM_LogoutPom(WebDriver driver) {
		this.driver=driver;
	}
	//Repository
	By Profile = By.className("oxd-userdropdown-tab");
	
	//By logoutbtn= By.linkText("Logout");
	By logoutbtn= By.xpath(" //ul[@class='oxd-dropdown-menu']/child::li[4]/descendant::a");          

	
	public void clickProfile() {
		driver.findElement(Profile).click();
	}
	
	public void clicklogoutbtn() {
		driver.findElement(logoutbtn).click();
	}

}
