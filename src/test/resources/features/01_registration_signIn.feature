Feature: User Registration and Sign-In

  As a user
  I want to register a new account and sign in
  So that I can access my account on the JPetStore website

  Background:
    Given the user opens the browser

  Scenario Outline: User Registration
    Given the user navigates to "<url>"
    Then the user should land on the homepage
    When the user clicks on the Sign In link
    And the user clicks on button Register Now
    And the user fills the registration form with random values
    And the user saves the account information
   

    Examples:
      | url                                                  |    
      | https://petstore.octoperf.com/actions/Catalog.action |
      
      
  Scenario Outline: User Signing in
    Given the user navigates to "<url>"
    Then  the user should land on the homepage
    Then  the user clicks on the Sign In link
    Then   the user enter the already picked random username and password
    When  the user click Login
    Then  the user is logged
   

    Examples:
      | url                                                  |    
      | https://petstore.octoperf.com/actions/Catalog.action |
