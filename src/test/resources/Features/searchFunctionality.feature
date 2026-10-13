Feature: To validate the Flipkart Application
Background:

Given Launch the Flipkart Application
When close the popup
Then It should navigate to Home page

Scenario: To validate the search functionality

Given User enter the  text in the search field
When click on search button
Then It should navigate to search result page and display the relevent details 


