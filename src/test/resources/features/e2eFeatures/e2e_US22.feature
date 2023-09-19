@E2E
Feature:Admins should be able to register in the system

  @Database_Test @Api_admin
  Scenario Outline: Validate registered user on database
    Given connect to database
    When get admin user via username "<username>"
    Then validate  username "<username>" gender "<gender>"  name "<name>" phone_number "<phone_number>"  ssn "<ssn>" surname "<surname>"
    And close the connection
    Examples:
      | username      | gender | name      | phone_number | ssn         | surname    |
      | Admin | 0      | Admin  | 555 444 4321 | 987 99 9999 | Admin |

