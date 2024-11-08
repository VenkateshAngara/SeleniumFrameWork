
@tag
Feature: Error message Validations of Ecommerce WebSite
  I want to use this template for my feature file


  @Regression
  Scenario Outline: Validation of Display messgae of Loginpage of the Ecommerce
  	Given I landed on the Ecommerce Website
    And I want to Register a Account With all Details fname "<firstName>" lname "<lastName>" email "<email>" mob "<mobile>" pass "<password>" conpass "<confirmPass>" occ "<Occupation>" in the  Register page and message is "Account Created Successfully" displayed
    And I logged into website with userName "Venkateshangara6005@gmail.com" and Password "Angara@123" in login page
    Then  verify the message "Incorrect email or password." is Displayed in Loginpage 

    Examples: 
       | firstName  | lastName | email                     | mobile    | password |confirmPass|Occupation| Product        |
       | Venkatesh  | Angara   | Venkateshangara6005@gmail.com |9542322769|Angara@123|Angara@123 |Student   | ADIDAS ORIGINAL|
     