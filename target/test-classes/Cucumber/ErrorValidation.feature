
@tag
Feature: Error validation 
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce page
    When I logged in with username <username> and password <password>
    Then "Incorrect email or password." Message is displayed

    Examples: 
        | username             | password    | 
        |nares345@gmail.com |Naresh@15 |