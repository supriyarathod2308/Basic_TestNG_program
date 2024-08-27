package Day04_11062024;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenFramework {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
//=============================Reading the Data from Excel sheet===========================================
		
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
			System.out.println("username ---->" +usernm +"                    password----->"+passwd);
			
//==================================Implementing in  website ===============================================			
			try {
			driver.findElement(By.name("username")).sendKeys(usernm.toString());
			driver.findElement(By.name("password")).sendKeys(passwd.toString());
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			driver.findElement(By.className("oxd-userdropdown-tab")).click();
			driver.findElement(By.linkText("Logout")).click();
			
			System.out.println("valid test data");
			}
			catch (Exception e) {
				System.out.println("invalid test data");
				
				}
			
			}
			fis.close();
			
		}

	}

