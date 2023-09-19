@E2E_US05
Feature: Admins should be able to see and update Deans


  Background: Login as Admin User and go to Dean Management page

    Given go to the "https://managementonschools.com"
    Given click on login
    When Enter username "AdminProjectDot", password "Project11+"
    And click on login button
    And user click on menu button
    And click "Dean Management" link

  @UI_Test
  Scenario Outline:Register a new dean
    Given user sees the "Add Dean" title
    When Enter name "<name>", surname "<surname>",birth_place "<birth_place>", gender "<gender>", date_of_birth "<date_of_birth>",phone "<phone>",ssn "<ssn>",username "<username>",password"<password>"
    And user clicks on submit on Add Dean section
    Then sees the Dean Saved alert

    Examples:
      | username | birth_day  | birth_place | gender | name | phone_number | ssn         | surname | password |
      | johndoe  | 11-01-2017 | New York    | Female | Jane | 377-654-4487 | 179-35-7446 | Doe     | John.123 |

  @US05_TC01_DBTest

  Scenario Outline: Validate Admins can see Name, Gender, Phone Number, SSN and User Name information of Deans
    Given connect to database
    When get Dean via username "<username>"
    Then validate  name "<name>", surname "<surname>",birth_place "<birth_place>", gender "<gender>", date_of_birth "<date_of_birth>",phone "<phone>",ssn "<ssn>",username "<username>",password"<password>"
    And close the connection

    Examples:
      | username    | birth_day  | birth_place | gender | name | phone_number | ssn         | surname |
      | alvaro.howe | 2000-01-01 | New York    | 0      | John | 685 205 2829 | 721-73-5270 | Doe     |

  @US05_TC03_DBTest

  Scenario: Validate Admin can update Deans

    Given connect to database
    When get Dean via username "<username>"
    Then validate  name "<name>", surname "<surname>",birth_place "<birth_place>", gender "<gender>", date_of_birth "<date_of_birth>",phone "<phone>",ssn "<ssn>",username "<username>",password"<password>"
    And close the connection
