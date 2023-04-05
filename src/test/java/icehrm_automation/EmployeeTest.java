package icehrm_automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import loginpage.EmployeePage;
import loginpage.LoginPage;

public class EmployeeTest extends BaseClass {
	
	 PropertyHandling property;
	 EmployeePage employeePage;
	 LoginPage loginPage;
	 
	 @BeforeClass
	 public void beforClass()
	 {
		 property=new PropertyHandling();
		 launchBrowser(property.getPropertys("browser"));
		 driver.get(property.getPropertys("icehrmUrl"));
          loginPage=new LoginPage(driver);
          EmployeePage employeePage=new EmployeePage();
          String username=property.getPropertys("icehrmUsername");
          String password=property.getPropertys("icehrmPassword");
          loginPage.login(username, password);
	 }
	 @Test
	 public void verifySearchEmp() throws Throwable
	 {
		 click(employeePage.employeeMenu);
		 click(employeePage.employeeSub);
		// waitUntilElementIsClickable(employeePage.searchButton);
		 List<String> allEmpName=new ArrayList<>();
		 Thread.sleep(3000);
		 List<WebElement> allEmpDetails=driver.findElements(employeePage.allempinfo);
		    for(WebElement element:allEmpDetails)
		    {
		    	String firstname=element.getText();
		    	allEmpName.add(firstname);
		    	System.out.println(allEmpName);
		    }
		    String lastEmpName=allEmpName.get(allEmpDetails.size()-1);
		    System.out.println(lastEmpName);
		    enterText(employeePage.searchBox,lastEmpName);
		    click(employeePage.searchButton);
		    Thread.sleep(4000);

	        List<WebElement> searchEmpDetails = driver.findElements(employeePage.allempinfo);
	        for (WebElement element:searchEmpDetails) {
	            String firstName = element.getText();
	           Assert.assertEquals(firstName, lastEmpName);
		 }
	 }
	 
          @AfterClass
          public void fterClass()
          {
        	  driver.close();
          }
		 
	 }
	 
	
	


