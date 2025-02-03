Feature: User registration
  Function of user registration for e-commerce website

  Background: The user is located on registration page
    Given The user is located on home page
    When Hover over userBtn and click on sign up register

  Scenario: Sign up user with valid email and password
    And Fill out the register form with valid data
    And Accept formal consents
    And Click on sign up button
    Then The register form is invisible to the user


  Scenario: Sign up user with empty data
    And Click on sign up button
    Then The notification about incorrect data is displayed

  Scenario Outline: Sign up user with invalid password
    And Fill out the register form with invalid password "<password>"
    And Accept formal consents
    And Click on sign up button
    Then The notification about incorrect password is displayed "<textError>"
    Examples:
      | password  | textError                             |
      | 123       | Password must be 8 characters long    |
      | 12345678  | Password requires a lowercase letter  |
      | 1234567a  | Password requires an uppercase letter |
      | 1234567aB | Password requires a symbol            |


  Scenario: Sign up user with invalid confirm password
    And Fill out the register form with invalid confirm password
    And Accept formal consents
    And Click on sign up button
    Then The notification about incorrect confirm password is displayed

  Scenario Outline: Sign up user with invalid email
    And Fill out the register form with invalid email "<email>"
    And Accept formal consents
    And Click on sign up button
    Then The notification about incorrect email is displayed "<errorText>"
    Examples:
      | email                 | errorText             |
      |                       | Required              |
      | test                  | Invalid email address |
      | test@test             | Invalid email address |
      | test.pl               | Invalid email address |
      | test@.pl              | Invalid email address |
      | testtest.pl           | Invalid email address |
      | @test.pl              | Invalid email address |
      | test@test.pl.         | Invalid email address |
      | test@-example.com     | Invalid email address |
      | test@sub.-domain.com  | Invalid email address |
      | test@sub.!domain.com  | Invalid email address |
      | test@sub.@domain.com  | Invalid email address |
      | test@sub.#domain.com  | Invalid email address |
      | test@sub.$domain.com  | Invalid email address |
      | test@sub.%domain.com  | Invalid email address |
      | test@sub.^domain.com  | Invalid email address |
      | test@sub.&domain.com  | Invalid email address |
      | test@sub.*domain.com  | Invalid email address |
      | test@sub.(domain.com  | Invalid email address |
      | test@sub.)domain.com  | Invalid email address |
      | test@sub.+domain.com  | Invalid email address |
      | test@sub. -domain.com | Invalid email address |
      | test@.subdomain.com   | Invalid email address |
      | test@subdomain-.com   | Invalid email address |
      | test@subdomain.com.   | Invalid email address |
      | test@subdomain..com   | Invalid email address |


  Scenario: Sign up user with exist email
    And Fill out the register form with exist email
    And Accept formal consents
    And Click on sign up button
    Then The notification about exist email is displayed

  Scenario Outline: Sign up user with invalid name
    And Fill out the register form with invalid name "<name>"
    And Accept formal consents
    And Click on sign up button
    Then The notification about incorrect name is displayed "<error>"
    Examples:
      | name                                     | error                         |
      |                                          | Required                      |
      | t                                        | Must be 3 characters or more  |
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa | Must be 30 characters or less |


  Scenario Outline: Sign up user with invalid last name
    And Fill out the register form with invalid last name "<lastName>"
    And Accept formal consents
    And Click on sign up button
    Then The notification about incorrect last name is displayed "<error>"
    Examples:
      | lastName                                 | error                         |
      |                                          | Required                      |
      | t                                        | Must be 3 characters or more  |
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa | Must be 30 characters or less |

  Scenario: Sign up user without confirm formal consents
    And Fill out the register form with valid data
    And Click on sign up button
    Then The notification about accept terms & Conditions is displayed