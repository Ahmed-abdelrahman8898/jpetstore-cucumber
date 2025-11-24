Feature: User adding random items to cart

  As a user
  I want to login and add random items to Cart

  Background:
    Given the user opens the browser

      
  Scenario Outline: User adding random items to cart
    Given the user navigates to "<url>"
    Then  the user should land on the homepage
    Then  the user clicks on the Sign In link
    Then  the user enter the already picked random username and password
    When  the user click Login
    Then  the user is logged
    When  the user click randomly on any catalog
    Then  the catalog is displayed
    When  the user click randomly on any product
    Then  the product is displayed
    When the user click Add to Cart on any random variant
    Then the item is added and can seen in the cart
   

    Examples:
      | url                                                  |    
      | https://petstore.octoperf.com/actions/Catalog.action |
