#Author: sarankum6@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Mobile search Validation

  @tag1
  Scenario: Validating Mobile purchase
    Given user need to lauch flipkart application
    And user needs to enter the credential details and click on login
    When user needs to search for mobile in search box 
    And user needs to select the required mobile phone
    And user needs to place the selected mobile in add to cart
    Then user will be navigate into add to cart window 
    And user needs to check the order update and place the order    