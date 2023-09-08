@US01
Feature:User Registration
  Background:Go_to_Homepage
    Given user navigates to "https://managementonschools.com/"
  @US01_TC01
  Scenario Outline: user register successfully
    And user clicks on register link
    And user enters name "<name>"
    And user enters surname "<surname>"
    And user enters birthplace "<birth_place>"
    And user enters phone number "<phone_number>"
    And user clicks on radio button
    And user enter date of birth "<date_of_birth>"
    And user enters ssn "<ssn_number>"
    And user enters username "<username>"
    And user enters password "<password>"
    And user clicks on register button
    Then verify Guest User registered alert is seen

    Examples: test_data
      | name | surname    | birth_place      | phone_number  | date_of_birth | ssn_number  | username | password  |
      | Anna | Silver     | San Antonio      | 123-321-1243  | 01/01/2000    | 187-89-9765 | Anna     | Anna2323! |