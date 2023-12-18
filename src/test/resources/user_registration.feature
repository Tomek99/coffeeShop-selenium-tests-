Feature: User registration
  Function of user registration for e-commerce website

  Background: The user is located on registration page
    Given The user is located on home page
    When Hover over userBtn and click on sign up register

  Scenario: Sign up user with valid email and password
    And Fill out the register form with valid data and accept formal consents.
    Then User is redirect to home page
    But The register form is invisible to the user