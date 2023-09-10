@US06
Feature: Deans should be able to create a Vice Dean account

  Background: go_homepage_and_login
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "Alexsandro"
    And user enters password "DeSouza25"
    And user clicks on login button

  @US06_TC01
  Scenario: With_Valid_Credentials
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify Vice Dean created successfully confirmation message
    Then close the application

  @US06_TC02
  Scenario: Name_Field_Left_Empty
    And enter Surname
    And enter Birth Place
    And select Male Gender
    And enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US06_TC03
  Scenario:Surame_Field_Left_Empty
    And enter Name
    And enter Birth Place
    And select Male Gender
    And enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US06_TC04
  Scenario:Birth_Place_Left_Empty
    And enter Name
    And enter Surname
    And select Male Gender
    And enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US06_TC05
  Scenario: Gender_Left_Empty
    And enter Name
    And enter Surname
    And enter Birth Place
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US06_TC06
  Scenario:Date_Of_Birth_Field_Left_Empty
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Male Gender
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US06_TC07
  Scenario:Phone_Number_Left_Empty
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Male Gender
    And enter date of birth
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US06_TC08
  Scenario:Ssn_Left_Empty
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Male Gender
    And enter date of birth
    And enter valid phone number
    And enter username
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US06_TC09
  Scenario:User_Name_Left_Empty
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Male Gender
    And enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter password
    And click submit button
    Then verify submit fails
    Then close the application

  @US06_TC10
  Scenario:User_Name_max_three_characters
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Male Gender
    And enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username "Ali"
    And enter password
    And click submit button
    Then verify user name should contains at least four characters
    Then verify submit fails
    Then close the application

  @US06_TC11
  Scenario:Password_with_max_7_characters
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Male Gender
    And enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password with only seven chars
    And click submit button
    Then verify password at least eight characters error message
    Then verify submit fails
    Then close the application

  @US06_TC12
  Scenario:Password_without_uppercase_characters
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Male Gender
    And enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password without uppercase chars
    And click submit button
    Then verify password One uppercase character error message
    Then verify submit fails
    Then close the application

  @US06_TC13
  Scenario:Password_without_lowercase_characters
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Male Gender
    And enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password without lowercase chars
    And click submit button
    Then verify password One lowercase character error message
    Then verify submit fails
    Then close the application

  @US06_TC14
  Scenario:Password_without_number
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Male Gender
    And enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password without numbers
    And click submit button
    Then verify password One number character error message
    Then verify submit fails
    Then close the application




