@US24
Feature: Admin should be able to create a teacher

  Background: go_homepage_and_login
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "AdminProjectDot"
    And user enters password "Project11+"
    And user clicks on login button
  @US24_TC01
  Scenario: With_Valid_Credentials
    And click menu button
    And click Teacher Management Link
    And choose Lesson
    And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And enter valid phone number
    And select is Advisor Teacher
    And select Male Gender
    Then enter date of birth
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    @US24_TC02
    Scenario: Invalid Password
      And click menu button
      And click Teacher Management Link
      And choose Lesson
      And enter Name
      And enter Surname
      And enter Birth Place
      And enter email
      And enter valid phone number
      And select is Advisor Teacher
      And select Male Gender
      Then enter date of birth
      And enter valid SSN
      And enter username
      And enter Invalid Password
      And click submit button
      Then verify passwordWithoutUpperCaseErrorMessage

      @US24_TC03
      Scenario: Missing Email
        And click menu button
        And click Teacher Management Link
        And choose Lesson
        And enter Name
        And enter Surname
        And enter Birth Place
      #  And enter email
        And enter valid phone number
        And select is Advisor Teacher
        And select Male Gender
        Then enter date of birth
        And enter valid SSN
        And enter username
        And enter password
        And click submit button
        Then verify the required message is visible





