package Day05_12062024;

import java.io.FileInputStream;
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

public class KeywordDrivenFramework {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//=============================Similar as POM==============calling there class here==============		
		ORHM_LoginPom olin = new ORHM_LoginPom(driver);
		ORHM_LogoutPom olout = new ORHM_LogoutPom(driver);

		String filepath = "C:\\Users\\admin\\Desktop\\FormDemo.xlsx";
		FileInputStream fis = new FileInputStream(filepath); // reading the file
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // Enter the workbook
		XSSFSheet sheet = workbook.getSheet("keyword"); // enter the excel sheet

		int Rows = sheet.getLastRowNum();
		System.out.println("total number of rows :" + Rows);

		for (int i = 1; i <= Rows; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell Keys = row.getCell(1);

			System.out.println("Keywords--------->" + Keys);

			switch (Keys.toString()) {
			case "url":
				olin.url();
				System.out.println(" Url Keywords matched");
				break;
			case "Enterusernm":
				olin.Enterusernm("Admin");
				System.out.println(" Enterusernm Keywords matched");
				break;
			case "Enterpass":
				olin.Enterpass("admin123");
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
		fis.close();
	}
}
