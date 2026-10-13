package com.stepdefinition;

import java.io.IOException;

import com.BaseClass.Library;
import com.Pages.SearchPage;
import com.ReusableFunctions.SeleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchMobileTestCase extends Library {
	
	SearchPage sp;

	@Given("Launch the Flipkart Application")
	public void launch_the_flipkart_application() throws IOException {
		lauchApplication();
		
	}

	@When("close the popup")
	public void close_the_popup() {
		System.out.println(driver.getTitle());
	 
	}

	@Then("It should navigate to Home page")
	public void it_should_navigate_to_home_page() {
	    sp=new SearchPage(driver);
	    sp.homeScreen();
	}

	@Given("User enter the  text in the search field")
	public void user_enter_the_text_in_the_search_field() {
		sp.Search("mobile");
	   
	}

	@When("click on search button")
	public void click_on_search_button() {
	    sp.clickSearch();
	}

	@Then("It should navigate to search result page and display the relevent details")
	public void it_should_navigate_to_search_result_page_and_display_the_relevent_details() {
	    sp.result();
	    
	}


}
