package Day03_10062024;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTest implements ITestListener {
	
	public void onTestStart(ITestResult result) {
	   System.out.println("This is executing when test execution starts :" +result.getName());
	  }

	  public void onTestSuccess(ITestResult result) {
		  System.out.println("This is executing when test method pass :" +result.getName());
	  }

	  public void onTestFailure(ITestResult result) {
		  System.out.println("This is executing when test method is failed :" +result.getName());
	  }

	
	  public void onTestSkipped(ITestResult result) {
		  System.out.println("This is executing when test method is skipped :" +result.getName());
	  }

	
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 
	  }

	 
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	 
	  public void onStart(ITestContext context) {
		  System.out.println("Whenever execution starts :" );
	  }

	 
	  public void onFinish(ITestContext context) {
		  System.out.println("Whenever execution ends :");
	  }


}
