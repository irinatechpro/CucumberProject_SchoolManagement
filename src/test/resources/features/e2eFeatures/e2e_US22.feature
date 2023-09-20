@E2E
Feature: Admins should be able to be registered in the system

  Background: go_homepage_and_login
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "TestOfMyUS"
    And user enters password "TestTest2"
    And user clicks on login button

  @US22_TC01
  Scenario: With_Valid_Credentials
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
    Then verify Admin created successfully confirmation message
    Then close the application

  @Database_Test
  Scenario Outline: Validate registered user on database
    Given connect to database
    When get admin user via username
    Then validate username name phone_number ssn surname birth_place date_of_birth password
    And close the connection
    Examples:
      |  |
