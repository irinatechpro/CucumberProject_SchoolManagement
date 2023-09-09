@US01
Feature:User Registration
  Background:Go_to_Homepage
    Given user navigates to "https://managementonschools.com/"
  @US01_TC01
  Scenario Outline: user register successfully
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

  @US01_TC02
  Scenario Outline: user register successfully
    And user clicks on register link
    And user enters surname "<surname>"
    And user enters birthplace "San Antonio"
    And enter valid phone number
    And user clicks on radio button
    And user enter date of birth "01/01/2000"
    And enter valid SSN
    And user enters user name "<username>"
    And user enters password "Anna1234&"
    And user clicks on register button
    Then verify blank field required message

    Examples: test_data
      | name | surname    | birth_place      | phone_number  | date_of_birth | ssn_number  | username | password  |
      | Anna | Silver     | San Antonio      | 123-321-1243  | 01/01/2000    | 187-89-9765 | Anna     | Anna2323! |

  @US01_TC03
  Scenario Outline: user register successfully
    And user clicks on register link
    And user enters name "Anna"
    And user enters birthplace "San Antonio"
    And enter valid phone number
    And user clicks on radio button
    And user enter date of birth "01/01/2000"
    And enter valid SSN
    And user enters user name "<username>"
    And user enters password "Anna1234&"
    And user clicks on register button
    Then verify blank field required message

    Examples: test_data
      | name | surname    | birth_place      | phone_number  | date_of_birth | ssn_number  | username | password  |
      | Anna | Silver     | San Antonio      | 123-321-1243  | 01/01/2000    | 187-89-9765 | Anna     | Anna2323! |

  @US01_TC04
  Scenario Outline: user register successfully
    And user clicks on register link
    And user enters name "Anna"
    And user enters surname "<surname>"
    And enter valid phone number
    And user clicks on radio button
    And user enter date of birth "01/01/2000"
    And enter valid SSN
    And user enters user name "<username>"
    And user enters password "Anna1234&"
    And user clicks on register button
    Then verify blank field required message

    Examples: test_data
      | name | surname    | birth_place      | phone_number  | date_of_birth | ssn_number  | username | password  |
      | Anna | Silver     | San Antonio      | 123-321-1243  | 01/01/2000    | 187-89-9765 | Anna     | Anna2323! |


  @US01_TC05
  Scenario Outline: user register successfully
    And user clicks on register link
    And user enters name "Anna"
    And user enters surname "<surname>"
    And user enters birthplace "San Antonio"
    And enter invalid phone number
    And user clicks on radio button
    And user enter date of birth "01/01/2000"
    And enter valid SSN
    And user enters user name "<username>"
    And user enters password "Anna1234&"
    And user clicks on register button
    Then verify Invalid phone number alert is seen

    Examples: test_data
      | name | surname    | birth_place      | phone_number  | date_of_birth | ssn_number  | username | password  |
      | Anna | Silver     | San Antonio      | ------------  | 01/01/2000    | 187-89-9765 | Anna     | Anna2323! |

  @US01_TC07
  Scenario Outline: user register successfully
    And user clicks on register link
    And user enters name "Anna"
    And user enters surname "<surname>"
    And user enters birthplace "San Antonio"
    And enter valid phone number
    And user clicks on radio button
    And enter valid SSN
    And user enters user name "<username>"
    And user enters password "Anna1234&"
    And user clicks on register button
    Then verify blank field required message

    Examples: test_data
      | name | surname    | birth_place      | phone_number  | date_of_birth | ssn_number  | username | password  |
      | Anna | Silver     | San Antonio      | ------------  | 01/01/2000    | 187-89-9765 | Anna     | Anna2323! |

  @US01_TC08
  Scenario Outline: user register successfully
    And user clicks on register link
    And user enters name "Anna"
    And user enters surname "<surname>"
    And user enters birthplace "San Antonio"
    And enter valid phone number
    And user clicks on radio button
    And user enter date of birth "01/01/2000"
    And enter invalid ssn number
    And user enters user name "<username>"
    And user enters password "Anna1234&"
    And user clicks on register button
    Then verify Invalid SSN number alert is seen

    Examples: test_data
      | name | surname    | birth_place      | phone_number  | date_of_birth | ssn_number  | username | password  |
      | Anna | Silver     | San Antonio      | ------------  | 01/01/2000    | 187-89-9765 | Anna     | Anna2323! |

  @US01_TC09
  Scenario Outline: user register successfully
    And user clicks on register link
    And user enters name "Anna"
    And user enters surname "<surname>"
    And user enters birthplace "San Antonio"
    And enter valid phone number
    And user clicks on radio button
    And user enter date of birth "01/01/2000"
    And enter valid SSN
    And user enters password "Anna1234&"
    And user clicks on register button
    Then verify blank field required message

    Examples: test_data
      | name | surname    | birth_place      | phone_number  | date_of_birth | ssn_number  | username | password  |
      | Anna | Silver     | San Antonio      | ------------  | 01/01/2000    | 187-89-9765 | Anna     | Anna2323! |

  @US01_TC010
  Scenario Outline: user register successfully
    And user clicks on register link
    And user enters name "Anna"
    And user enters surname "<surname>"
    And user enters birthplace "San Antonio"
    And enter valid phone number
    And user clicks on radio button
    And user enter date of birth "01/01/2000"
    And enter valid SSN
    And user enters user name "<username>"
    And user enters password "Anna"
    And user clicks on register button
    Then verify invalid password message seen

    Examples: test_data
      | name | surname    | birth_place      | phone_number  | date_of_birth | ssn_number  | username | password  |
      | Anna | Silver     | San Antonio      | ------------  | 01/01/2000    | 187-89-9765 | Anna     | Anna2323! |


