package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import icehrm_automation.BaseClass;
import icehrm_automation.PropertyHandling;
import loginpage.LoginPage;

public class LoginTest extends BaseClass {
	
	PropertyHandling property;
	LoginPage loginpage;

	
	@BeforeClass
	public void start()
	{
		property=new PropertyHandling();
		//loginpage=new LoginPage();
		launchBrowser(property.getPropertys("browser")) ;
		driver.get(property.getPropertys("icehrmUrl"));
     }
	@DataProvider
	public Object[][] getLoginData()
	{
		Object[][] data=new Object[][] {
			{"admin123","admin","Login Failed"},
			{"admin","admin1234","Login Failed"},
			{"admin123","2zuzfakn","Login Failed"},
			{" "," "," "},
			{"  ","2zuzfakn"," "},
			{"admin"," "," "},
			{"admin","@zuzfakn","Login Passed"},
		};
		return data;
	}
	@Test(dataProvider="getLoginData")
	public void verifyLogin(String username,String password,String errorMsg) throws Throwable
	{
		loginpage.login(username,password);
		waitUntiltobeVisible();
		if(!username.isEmpty() && !password.isEmpty())
		Thread.sleep(2000);
		{String errorMsg1=driver.findElement(loginpage.errorMsg).getText();
		try {Thread.sleep(2000);
			Assert.assertEquals(errorMsg1,errorMsg);
		}
		catch(Exception e)
		{
			System.out.println(driver.getTitle());
		}
		}
	}
}
	

	
	


