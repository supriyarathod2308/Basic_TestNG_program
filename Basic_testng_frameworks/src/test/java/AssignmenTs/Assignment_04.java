package AssignmenTs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Assignment_04 {
	WebDriver driver;

	//public static void main(String[] args) throws IOException {
	
		@BeforeSuite
		public void setup() 
		{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/V4/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
//==========================fetching data from excelsheet===========================================
		@Test
		public void data() throws IOException {
		String filepath="C:\\Users\\admin\\Desktop\\AssignmentData_04.xlsx";
		FileInputStream fis= new FileInputStream(filepath);
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet= workbook.getSheet("UserData");
		
		int Rows= sheet.getLastRowNum();
		System.out.println(Rows);
		
		for(int i=1;i<=Rows;i++) {
			XSSFRow row= sheet.getRow(i);
			XSSFCell usernm= row.getCell(0);
			XSSFCell passwd=row.getCell(1);
			
			System.out.println(usernm +" " +passwd);
		
//=============================================implement in website=======================================
		
			driver.findElement(By.name("uid")).sendKeys(usernm.toString());
			driver.findElement(By.name("password")).sendKeys(passwd.toString());
			driver.findElement(By.name("btnLogin")).click();
			Alert a=driver.switchTo().alert();
			a.accept();
			}
		}

		@AfterSuite
		public void run()
		{
		driver.close();
		}
}



