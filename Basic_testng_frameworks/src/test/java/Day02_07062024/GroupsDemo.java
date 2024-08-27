package Day02_07062024;

import org.testng.annotations.Test;

public class GroupsDemo {
	
	@Test (groups = {"smoke"})
	public void test1() {
		System.out.println("test1 {\"smoke\"}");
	}
	@Test (groups = {"smoke","sanity"})
	public void test2() {
		System.out.println("test2 {\"smoke\",\"sanity\"}");
	}
	@Test (groups= {"smoke","sanity","regression"})
	public void test3() {
		System.out.println("test3 {\"smoke\",\"sanity\",\"regression\"}");
	}
	@Test (groups= {"regression"})
	public void test4() {
		System.out.println("test4 {\"regression\"}");
	}
	@Test (groups= {"smoke","regression"})
	public void test5() {
		System.out.println("test5 {\"smoke\",\"regression\"}");
	}
	
	@Test (groups= {"sanity","regression"})
	public void test6() {
		System.out.println("test6 {\"sanity\",\"regression\"}");
	}
	@Test (groups= {"stress"})
	public void test7() {
		System.out.println("test7 {\"stress\"}");
	}

}
