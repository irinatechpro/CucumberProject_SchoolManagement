@US22
Feature: Admin should be able to add an admin

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

  @US22_TC02
  Scenario: Missing_Name
#    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US22_TC03
  Scenario: Missing_Surname
    And enter Name
#    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US22_TC04
  Scenario: Missing_Birthplace
    And enter Name
    And enter Surname
#    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US22_TC05
  Scenario: Missing_Gender
    And enter Name
    And enter Surname
    And enter Birth Place
#    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US22_TC06
  Scenario: Missing_Date_Of_Birth
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
#    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US22_TC07
  Scenario: Missing_Phone_Number
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
#    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US22_TC08
  Scenario: Missing_SSN
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
#    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US22_TC09
  Scenario: Missing_Username
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
#    And enter username
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US22_TC10
  Scenario: Missing_Password
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
#    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US22_TC11
  Scenario: Password_Without_Lowercase_Chars
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password without lowercase chars
    And click submit button
    Then verify submit fails
    Then close the application

  @US22_TC12
  Scenario: Password_Without_Uppercase_Chars
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password without uppercase chars
    And click submit button
    Then verify submit fails
    Then close the application

  @US22_TC13
  Scenario: Password_With_Seven_Chars
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password with only seven chars
    And click submit button
    Then verify submit fails
    Then close the application

  @US22_TC14
  Scenario: Password_Without_Number
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password without numbers
    And click submit button
    Then verify submit fails
    Then close the application
