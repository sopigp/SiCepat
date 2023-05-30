Feature: Acceptance critearia for checkout products

  Scenario: As a user can checkout product
    Given User open the browser and navigate to www.saucedemo.com
    When I retrieves the username and password values
    And I saves the values into variables
    And I logs in using the saved username and password
    Then I should be successfully logged in
    When I choose Swag Labs product
    And I retrieves the price of Swag Labs product
    And I click Add to cart button
    And I click the cart icon on header
    Then the price of Swag Labs on checkout is same with the price from detail product page
    And I click Checkout button
    And I enter "Sofie" into firstname field
    And I enter "Gita Pratiwi" into lastname field
    And I enter "16916" into zip field
    And I click Continue button
    And I click Finish button



