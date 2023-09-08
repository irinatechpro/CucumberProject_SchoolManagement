@US04
Feature: Admin should be able to create a dean

  Background: go_homepage_and_login
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "AdminProjectDot"
    And user enters password "Project11+"
    And user clicks on login button
  @US04_TC01
  Scenario: With_Valid_Credentials
    And click menu button
    And click Dean Management Link
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify dean created successfully confirmation message
    Then click last page button
   # And verify dean exist on the list
     # And verify dean number created automaticaly
    Then close the application
