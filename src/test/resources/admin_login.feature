Feature: Admin login
  Function of login to admin panel

  Background: Admin is located in admin login form
    Given  Admin is located in admin login form

  Scenario: Login to admin panel with valid data
    When Fill login input
    And  Fill password input
    And  Click on login button
    Then Admin is redirected to admin panel

  Scenario: Login to admin panel with empty form
    When  Click on login button invalid data
    Then The notification about invalid login and password is displayed

  Scenario Outline: Login to admin panel with invalid login
    When Fill login input "<login>"
    And Fill password input
    And  Click on login button invalid data
    Then The notification about invalid data is displayed
    Examples:
      | login                                    |
      | f                                        |
      | Admin                                    |
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa |

  Scenario Outline: Login to admin panel with invalid password
    When Fill login input
    And  Fill password input "<password>"
    And  Click on login button invalid data
    Then The notification about invalid data is displayed
    Examples:
      | password                                 |
      | f                                        |
      | Admin                                    |
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa |

  Scenario: Admin undo login to home page
    When  Click on return home btn
    Then Redirect to home page