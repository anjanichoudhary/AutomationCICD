
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidations
  Scenario Outline: Title of your scenario outline
  	Given I landed on Ecommerce Page
    When Logged in with username <name> and password <password>
    Then "Incorrect email password." message is displayed

    Examples: 
      | name  												| password 							|
      | indiafoodinvites@gmail.com	 	| Foodinvites			    	|
