package com.BaseClass;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Library {
	
	public static Properties prop;
	public static WebDriver driver;
	public void lauchApplication() throws IOException
	{
		//hardcoded filesystem path.it is machine/project-location dependent:
		//FileInputStream input =new FileInputStream("/Flipkart_Project/src/test/resources/Properties/config.properties");
		
		
		     // Load config.properties from classpath , because here code doesn't depend on where your project is located on your computer.
		InputStream input = getClass() .getClassLoader() .getResourceAsStream("Properties/config.properties");
		    // Check whether file was found 
		if (input == null) 
		{ 
			throw new IOException("config.properties file not found"); 
		}
		prop=new Properties();
		prop.load(input);
		
		String browser=prop.getProperty("browser");
		
		
			if(browser.equalsIgnoreCase("chrome"))
			{
				
				driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				
				driver=new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
			
				driver=new FirefoxDriver();
			}
			
			else
			{
				throw new IllegalArgumentException("invalid Browser:"+ browser);
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(prop.getProperty("url"));
			
			
		
	}
 
	public void tearDown()
	{
		driver.close();
	}
}
