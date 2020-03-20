Feature: Test Login page

  Scenario: Test positive login page
    When I login as correct user
    Then I see logout link

  Scenario Outline: Test negative login page
    When I login as user with "<name>" and "<password>"
    Then I see error message
    Examples:
      | name          | password    |
      | mikita.pushnou| qwerty123   |