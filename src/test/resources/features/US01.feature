@US01
Feature:User Registration
  Background:Go_to_Homepage
    Given user navigates to "https://managementonschools.com/"
  @US01_TC01
  Scenario Outline:user register successfully
    And user clicks on register link
    And user enters name "<name>"
    And user enters surname "<surname>"
    And user enters birthplace "<birth_place>"
    And user enters phone number "<phone_number>"
    And user clicks on radio button

    Examples: test_data
      | name | surname    | birth_place      | phone_number  |
      | Anna | Silver     | San Antonio      | 123-321-1243  |