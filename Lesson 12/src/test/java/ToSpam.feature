Feature: Test to Spam page

  Scenario: Test positive to spam page
    Given I am on main application page
    When I login as correct user
    Then I see logout link

  Scenario Outline: Test negative login page
    Given I am on main application page
    When I login as user with "<name>" and "<password>"
    Then I see error message
    Examples: 
      | name   | password    |
      | X XX XX| 123345768   |
      | -----  |  hfgyt124jfk|
