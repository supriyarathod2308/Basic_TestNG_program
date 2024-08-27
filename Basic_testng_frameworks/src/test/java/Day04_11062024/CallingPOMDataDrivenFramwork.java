package Day04_11062024;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Day03_10062024.ORHM_LoginPom;
import Day03_10062024.ORHM_LogoutPom;

public class CallingPOMDataDrivenFramwork {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//=============================Similar as POM==============calling there class here==============		
		ORHM_LoginPom olin= new ORHM_LoginPom(driver);
		ORHM_LogoutPom olout= new ORHM_LogoutPom(driver);
		olin.url();
		
//=============================Reading the Data from Excel sheet==========================================
		
		String filepath="C:\\Users\\admin\\Desktop\\FormDemo.xlsx";
		
		FileInputStream fis= new FileInputStream(filepath);     //reading the file
		XSSFWorkbook workbook= new XSSFWorkbook(fis);           // Enter the workbook
		XSSFSheet sheet= workbook.getSheet("Data");             // enter the excel sheet
		
		
		int Rows= sheet.getLastRowNum();
		System.out.println("total number of rows :"+Rows);
		
		for(int i=1;i<=Rows;i++) {
			XSSFRow row= sheet.getRow(i);
			XSSFCell usernm = row.getCell(0);
			XSSFCell passwd= row.getCell(1);
			XSSFCell results =row.createCell(2);
			System.out.println("username ---->" +usernm +"                    password----->"+passwd);
			
//==================================Implementing in  website ===============================================
			try {
				olin.Enterusernm(usernm.toString());
				olin.Enterpass(passwd.toString());
				olin.clickloginbtn();
				
				olout.clickProfile();
				olout.clicklogoutbtn();
				
			
				System.out.println("valid data");
				results.setCellValue("Valid data");
			}
			catch (Exception e) {
				
				String errormsg= driver.findElement(By.xpath("//div[@id='app']/descendant::p[1]")).getText();
				System.out.println("invalid data");
				results.setCellValue(errormsg);
			
			}
			
			
			
		}
		fis.close();
		FileOutputStream fos=new FileOutputStream(filepath);
		workbook.write(fos);

	}
}
