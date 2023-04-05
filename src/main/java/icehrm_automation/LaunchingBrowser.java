package icehrm_automation;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingBrowser {

        protected static  WebDriver driver;
		
		public void launchBrowser()
		{
			 WebDriverManager.edgedriver().setup();
             driver = new EdgeDriver(setChromeOptions());
             driver.get("https://cybersuccess.icehrm.com");
		    
		}
		public EdgeOptions setChromeOptions() {
	        EdgeOptions option = new EdgeOptions();
	        option.addArguments("start-maximized");
	        option.addArguments("--remote-allow-origins=*");
	        option.addArguments("incognito");
	        option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-clocking"));
	       	 option.setAcceptInsecureCerts(true);
	        return option;		
		}
		 public static void main(String args[]) {
			 LaunchingBrowser launch=new LaunchingBrowser();
			 launch.launchBrowser();
			String text=driver.findElement(By.xpath("https://cybersuccess.icehrm.com")).getText();
			System.out.println(text);
		 }

}