package wrappers;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.DataInputProvider;
import utils.DataInputProvider1;

public class LearnexaWrappers extends GenericWrappers {
	
	public String browserName;
	public String dataSheetName;
	
	@BeforeSuite
	public void beforeSuite(){
		startResult();
	}

	@BeforeTest
	public void beforeTest(){
		loadObjects();
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("I am in Learnexa wrapper");
		test = startTestCase(testCaseName, testDescription);
		test.assignCategory(category);
		invokeApp(browserName);
	}
		
	@AfterSuite
	public void afterSuite(){
		endResult();
	}

	@AfterTest
	public void afterTest(){
		unloadObjects();
	}
	
	@AfterMethod
	public void afterMethod(){
		endTestcase();
		quitBrowser();
		
	}
	
	@DataProvider(name="fetchData")
	public  Object[][] getCSVdata() throws Exception{
		return DataInputProvider.getSheet(dataSheetName);		
	}	
	
	
}