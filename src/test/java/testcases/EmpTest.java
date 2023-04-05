package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import icehrm_automation.BaseClass;
import icehrm_automation.PropertyHandling;

public class EmpTest extends BaseClass {
	  
	 PropertyHandling propertyhandling;
	 
	 @BeforeClass
	 public void before()
	 {
		 propertyhandling=new PropertyHandling();
		 
	 }
	  @Test
	  public void login()
	  {
		  String url=propertyhandling.getPropertys("icehrmUrl");
		  launchBrowser("chrome") ;
		  driver.navigate().to(url);
		  String username=propertyhandling.getPropertys("icehrmUsername");
		  enterText(By.id("username"),username);
		  String password=propertyhandling.getPropertys("icehrmPassword");
		  enterText(By.id("password"),password);
		  click(By.xpath("//button[text()='Log in ']"));
		}
	  @Test
	  public void test()
	  {
		  String url=System.getProperty("icehrmUrl");
		  System.out.println(url);
	  }
	  

}
