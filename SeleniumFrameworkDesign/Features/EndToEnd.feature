
@tag
Feature: Checking the Order Functionality of the Ecommerce Website
  I want to use this template for my feature file

Background:
Given I landed on the Ecommerce Website

  @Regression
  Scenario Outline: Checking the End to End Functionality of the Ecommerce
    Given I want to Register a Account With all Details fname "<firstName>" lname "<lastName>" email "<email>" mob "<mobile>" pass "<password>" conpass "<confirmPass>" occ "<Occupation>" in the  Register page and message is "Account Created Successfully" displayed
    And I logged into website with userName "VenkateshAngara6008@gmail.com" and Password "Angara@123" in login page
    When I  add the products "<Product>" to cart from cart page and popup "Product Added To Cart" is displayed
    And I click on cart to cartPage and check the product "<Product>" is in cart page
    And  I checkout the product to paymentPage and enter details "<mobile>""First100" "India" "322"
    Then  verify the message "THANKYOU FOR THE ORDER." is Displayed

    Examples: 
       | firstName  | lastName | email                     | mobile    | password |confirmPass|Occupation| Product        |
       | Venkatesh  | Angara   | VenkateshAngara6008@gmail.com|9542322769|Angara@123|Angara@123 |Student   | ADIDAS ORIGINAL|
     
