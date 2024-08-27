package Day01_05062024;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsDemo {
	@BeforeSuite
	public void bsuite() {
		System.out.println("@BeforeSuite");
	}
	@BeforeTest
	public void btest() {
		System.out.println("@BeforeTest");
	}
	@BeforeClass
	public void bclass() {
		System.out.println("@Beforeclass");
	}
	@BeforeMethod
	public void bmethod() {
		System.out.println("@Beforemethod");
	}
	@Test
	public void test() {
		System.out.println("@Test");
	}
	@AfterMethod
	public void Amethod() {
		System.out.println("@aftermethod");
	}
	@AfterSuite
	public void Asuite() {
		System.out.println("@aftersuite");
	}
	@AfterClass
	public void Bclass() {
		System.out.println("@afterclass");
	}
	@AfterTest
	public void Atest() {
		System.out.println("@afterTest");
	}
	

}
