Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario: Login with correct username and password

    Given I navigate to the login page
    And I enter the  following information for the logging
     #  | username     | password    |
     #  |              |   |
     #  |              |   |
    When I click login buttom
    Then I should see the Home page

  Scenario: Login with correct username and password

    Given I navigate to the login page 2
    And I enter the users email address as email:admin
    And I enter the userName and Password S
      | username  | password    | Numero ||
      | <user1>   | <password1> |
      | <user2>   | <password2> |
      | <user3>   | <password3> |
    And I click login button
    Then I should see the userform page

