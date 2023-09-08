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
    And choose Advisor Teacher
    And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter student username
    And enter father name
    And enter mother name
    And enter password
    And click submit button
    Then verify student created successfully confirmation message
    Then click last page button
    And verify student number created automatically
    Then close the application


  @US15_TC02
  Scenario: Name_Field_Left_Empty
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    And enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter father name
    And enter mother name
    And enter password
    And click submit button
    Then verify submit fails
