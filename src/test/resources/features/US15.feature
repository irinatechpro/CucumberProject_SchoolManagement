gi@US15
Feature: Vice Deans should be able to create a student

  Background: go_homepage_and_login
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "JGreen"
    And user enters password "JasonGreen1"
    And user clicks on login button
  @US15_TC01
  Scenario: With_Valid_Credentials
    And click menu button
    And click Student Management Link
    #Then enter surname

    Then enter date of birth
    Then enter valid phone number
    Then enter valid SSN
    Then enter username


  @US01_TC02
  Scenario:
