Feature: User registration
  Function of user registration for e-commerce website

  Background: The user is located on registration page
    Given The user is located on home page
    When Hover over userBtn and click on sign up register

  Scenario: Sign up user with valid email and password
    And Fill out the register form with valid data
    And Accept formal consents
    Then User is redirect to home page
    But The register form is invisible to the user

  Scenario: Sign up user with empty data
    And Fill out the register form with empty data
    Then The notification about incorrect data is displayed

  Scenario: Sign up user with invalid password
    And Fill out the register form with invalid password
    And Accept formal consents
    Then The notification about incorrect password is displayed

  Scenario: Sign up user with invalid confirm password
    And Fill out the register form with invalid confirm password
    And Accept formal consents
    Then The notification about incorrect confirm password is displayed

  Scenario: Sign up user with invalid email
    And Fill out the register form with invalid email
    And Accept formal consents
    Then The notification about incorrect email is displayed

  Scenario: Sign up user with exist email
    And Fill out the register form with exist email
    And Accept formal consents
    Then The notification about exist email is displayed

  Scenario: Sign up user with invalid name
    And Fill out the register form with invalid name
    And Accept formal consents
    Then The notification about incorrect name is displayed

  Scenario: Sign up user with invalid last name
    And Fill out the register form with invalid last name
    And Accept formal consents
    Then The notification about incorrect last name is displayed

  Scenario: Sign up user without confirm formal consents