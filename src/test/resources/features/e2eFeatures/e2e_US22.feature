@E2E
Feature:Admins should be able to register in the system

  @Database_Test
  Scenario Outline: Validate registered user on database
    Given connect to database
    When get admin user via username "<username>"
    Then validate  username "<username>" gender "<gender>"  name "<name>" phone_number "<phone_number>"  ssn "<ssn>" surname "<surname>"
    And close the connection
    Examples:
      | username      | gender | name      | phone_number | ssn         | surname    |
      | mitchell.king | 1      | Brunilda  | 381 675 4791 | 477 07 7923 | Balistreri |

