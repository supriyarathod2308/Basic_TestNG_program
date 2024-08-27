package Day05_12062024;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Day03_10062024.ORHM_LoginPom;
import Day03_10062024.ORHM_LogoutPom;

public class HybridDrivenFramework {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//=============================Similar as POM==============calling there class here==============		
		ORHM_LoginPom olin = new ORHM_LoginPom(driver);
		ORHM_LogoutPom olout = new ORHM_LogoutPom(driver);
		
//================================================================================================		
		String filepath="C:\\Users\\admin\\Desktop\\FormDemo.xlsx";
		
		FileInputStream fis= new FileInputStream(filepath);     //reading the file
		XSSFWorkbook workbook= new XSSFWorkbook(fis);           // Enter the workbook
		XSSFSheet datasheet= workbook.getSheet("Data");             // enter the excel sheet
		XSSFSheet Keysheet = workbook.getSheet("keyword");          // enter the excel sheet

		
		int dataRows= datasheet.getLastRowNum();
		System.out.println("total number of data rows :"+dataRows);
		
		int keyRows= Keysheet.getLastRowNum();
		System.out.println("total number of key rows :"+keyRows);
		
		for(int dr=1;dr<=dataRows;dr++) {
			XSSFRow drow= datasheet.getRow(dr);
			XSSFCell usernm = drow.getCell(0);
			XSSFCell passwd= drow.getCell(1);
			System.out.println("username ---->" +usernm +"                    password----->"+passwd);
			
			try {
			for (int kr = 1; kr <= keyRows; kr++) {
				XSSFRow krow = Keysheet.getRow(kr);
				XSSFCell Keys = krow.getCell(1);

				System.out.println("Keywords--------->" + Keys);
//=====================================================================================================				
				switch (Keys.toString()) {
				case "url":
					olin.url();
					System.out.println(" Url Keywords matched");
					break;
				case "Enterusernm":
					olin.Enterusernm(usernm.toString());
					System.out.println(" Enterusernm Keywords matched");
					break;
				case "Enterpass":
					olin.Enterpass(passwd.toString());
					System.out.println(" Enterpass Keywords matched");
					break;
				case "clickloginbtn":
					olin.clickloginbtn();
					System.out.println(" clickloginbtn Keywords matched");
					break;

	//====================different page=================================				
				case "clickProfile":
					olout.clickProfile();
					System.out.println(" clickProfile Keywords matched");
					break;
				case "clicklogoutbtn":
					olout.clicklogoutbtn();
					System.out.println(" clicklogoutbtn Keywords matched");
					break;
				default:
					System.out.println("invalid keywords");
				}

			}
			System.out.println("Valid test data");
		}
			catch (Exception e) {
				System.out.println("Invalid test case" );
				
				
			}
	
		}
		fis.close();
	}
}
