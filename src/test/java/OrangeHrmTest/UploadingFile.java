package OrangeHrmTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import icehrm_automation.BaseClass;
import icehrm_automation.PropertyHandling;
import orangeHRM.OrangeHRM;

public class UploadingFile extends BaseClass{
	OrangeHRM orange;
	PropertyHandling properties;
	
	@BeforeClass 
	public void homePage() throws Throwable
	{ 
		
		properties=new PropertyHandling();
		launchBrowser(properties.getPropertys("browser"));
		driver.get(properties.getPropertys("orangeHrmUrl"));
		 orange=new OrangeHRM();
		enterText(orange.username,properties.getPropertys("orangeHrmUsername"));
		enterText(orange.password,properties.getPropertys("orangeHrmPassword"));
		click(orange.loginButton);
		click(orange.Pim);
		Thread.sleep(2000);
		click(orange.add);

	}
	
	 @Test
	 public void upload() throws Throwable
	 {
		   Thread.sleep(2000);
			enterText(orange.firstName,"ram");
			enterText(orange.lastName,"Soni");
			Thread.sleep(5000);
			click(orange.plus);
			Runtime.getRuntime().exec("C:\\Users\\rsoni\\OneDrive\\Documents\\upload123.exe");
			Thread.sleep(5000);
			click(orange.save);
	}
	 
	 @AfterClass
	 public void close() throws Throwable
	 { Thread.sleep(5000);
		driver.close(); 
	 }
	
}
