Feature: Test send page

  Scenario: Test positive send page
    Given I am on inbox application page
    When I click create new message
    Then I create the first screenshot
    When I populate all the required fields with valid data
    Then I create the second screenshot
    When I click send button
    Then I create the third screenshot

