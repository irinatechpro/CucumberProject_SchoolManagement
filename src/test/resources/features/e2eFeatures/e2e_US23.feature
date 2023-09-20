@e2e_US23
Feature: Admin should be able to create a vice dean


  @UI23
  Scenario:user register successfully
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "AdminProjectDot"
    And user enters password "Project11+"
    And user clicks on login button
    And click menu button
    And click Vice Dean Management Link
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
    And verify Vice Dean created successfully confirmation message
    Then close the application

  @US23_API @Api_viceDean

  Scenario: Admin created vice dean on API
    Given send get All vice dean request on API
    Then filter vice_dean Data using username and validate




