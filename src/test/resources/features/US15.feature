@US15
Feature: Vice Deans should be able to create a student

  Background: go_MS_homepage_and_Login_as_Vice_Dean
    Given user navigates to "https://managementonschools.com/"
    #And user Login as Vice Dean
  @US15_TC01
  Scenario: With_Valid_Credentials
    #And click menu button
    #And click Student Management Link
    #Then enter surname

    Then enter date of birth
    Then enter valid phone number
    Then enter valid SSN
    Then enter username


  @US01_TC02
  Scenario:
    And
    And
    Then
    And