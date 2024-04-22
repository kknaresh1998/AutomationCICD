
@tag
Feature: Purchase the order from E-commerce site
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive test of submitting the order
    Given I logged in with username <username> and password <password>
    When I add product <productName> to cart
    And checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage

    Examples: 
      | username             | password    | productName  |
      |naresh12345@gmail.com |Naresh@12345 | Zara coat 3  |
