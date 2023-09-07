@US13
Feature: Vice Deans should be able to create a teacher

  Background: go_homepage_and_login
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "JGreen"
    And user enters password "JasonGreen1"
    And user clicks on login button
  @US13_TC01
  Scenario: With_Valid_Credentials
    And click menu button
    And click Teacher Management Link
    And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    And verify teacher created successfully confirmation message