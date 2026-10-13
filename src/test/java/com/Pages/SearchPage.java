package com.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Library;
import com.ReusableFunctions.SeleniumReusable;

public class SearchPage extends Library{
	
	SeleniumReusable se;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@name='q']")
	WebElement SearchText;
	public void Search(String Text)
	{
		se=new SeleniumReusable(driver);
		se.enterValue(SearchText, Text);
	}
	
	
	@FindBy(xpath="//html[@lang='en-IN']")
	WebElement homePage;
	public void homeScreen()
	{
		System.out.println(homePage.isDisplayed());
	}
	
	@FindBy(xpath="//html[@lang='en']")
	WebElement searchResult;
	public void result()
	{
		System.out.println(searchResult.isDisplayed());
		System.out.println(driver.getTitle());
	}
	
	public void clickSearch()
	{
		SearchText.sendKeys(Keys.ENTER);
	}
	

}
