git@E2E
Feature:Prospective students should be able to register in the system

  @UI
  Scenario Outline: user register successfully
    Given user navigates to "https://managementonschools.com/"
    And user clicks on register link
    And user enters name "Anna"
    And user enters surname "<surname>"
    And user enters birthplace "San Antonio"
    And enter valid phone number
    And user clicks on radio button
    And user enter date of birth "01/01/2000"
    And enter valid SSN
    And user enters user name "<username>"
    And user enters password "Anna1234&"
    And user clicks on register button
    Then verify Guest User registered alert is seen

    Examples: test_data
      | name | surname    | birth_place      | phone_number  | date_of_birth | ssn_number  | username | password  |
      | Anna | Silver     | San Antonio      | 123-321-1243  | 01/01/2000    | 187-89-9765 | Anna     | Anna2323! |
  @API
  Scenario:

  @DB
  Scenario:
