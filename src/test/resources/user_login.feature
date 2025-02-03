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