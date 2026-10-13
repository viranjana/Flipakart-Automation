package com.ReusableFunctions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BaseClass.Library;

public class SeleniumReusable extends Library{
	
	public SeleniumReusable(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterValue(WebElement element, String text)
	{
		try 
		{
			element.sendKeys(text);
		}
		catch(Exception e)
		{
			System.out.println("NO such element exception");
		}
	}
	
	public void click(WebElement element) {
		try {
			element.click();
		}
		catch(Exception e)
		{
			System.out.println("No such element exception");
		}
	
	}
	
	 public void getTitle()
	 {
		 try{
			 System.out.println(driver.getTitle());
		 }
		 catch(Exception e){
			 System.out.println("Could not get title");	 
		 }
	 }
	 public void screenShot(String path) {
		 TakesScreenshot ts= (TakesScreenshot) driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 try {
		        FileUtils.copyFile(source, new File(path));

		    } catch (IOException e) {

		        System.out.println("Failed to save screenshot: " + e.getMessage());
		        e.printStackTrace();
		    }
		 }
		 
	 }
	 
	 


