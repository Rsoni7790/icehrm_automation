package icehrm_automation;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	     public  WebDriver driver;
			
			public void launchBrowser(String browser) 
			{
			switch(browser)	
			{
			case "chrome":
				WebDriverManager.chromedriver().setup();
		       driver= new ChromeDriver(setChromeOptions());
		       driver.manage().window().maximize();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				driver.manage().window().maximize();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				 driver=new FirefoxDriver();
				driver.manage().window().maximize();
			case "safar":
				WebDriverManager.safaridriver().setup();
				driver=new SafariDriver();
				break;
				default:
					WebDriverManager.chromedriver().setup();
					 driver=new ChromeDriver();
					driver.manage().window().maximize();
					break;
			}
				}
			public void enterText(By by, String text)
	          
			{try {
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
				wait.until(ExpectedConditions.presenceOfElementLocated(by));
				driver.findElement(by).sendKeys(text);
			}
			catch(Exception e)
			{e.printStackTrace();
				}
			}
			public void click(By by)
			{
				try {  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
				      wait.until(ExpectedConditions.elementToBeClickable(by));
				     driver.findElement(by).click();
				     }
				catch(Exception e)
				{e.printStackTrace();
				}
				}
			public ChromeOptions setChromeOptions() {
		        ChromeOptions option = new ChromeOptions();
		        option.addArguments("start-maximized");
		        option.addArguments("--remote-allow-origins=*");
		        option.addArguments("incognito");
		        option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-clocking"));
		         option.setAcceptInsecureCerts(true);
		        return option;
				}
			public void waitUntiltobeVisible()
			{
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
				wait.until(ExpectedConditions.presenceOfElementLocated(null));
				
				
			}
}
			


