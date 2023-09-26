  @E2E_US16
  @US16
  Feature:The Vice Dean should be able to view the messages sent by users
    Background: Login As Vice Dean
      Given login as vice dean "Agent07" "11111111eW"
      And click Menu button
      And click Get All button
    @US16_TC01
    Scenario: Validate delete button on UI
      Then Verify Delete button is visible
    @US16_TC02
    Scenario:Validate contactMessages on UI
      Then verify message is visible
      Then verify Name is visible
      Then verify Email is visible
      Then verify Date is visible
      Then verify Subject is visible
    @US16_TC03
    Scenario: Validate deleted messages on UI
      Then verify ability to delete messages
  @E2E_US16_API
  Scenario:Validate contactMessages on API
        Given send get request to get all messages
        Then validate ID, date, email , message, name, subject by API
  @E2E_US16_API_Deleted @US16_API
  Scenario: Validate deleted messages on API
        Given send get request to get all messages
        Then validate message is deleted
  @E2E_US16_DB
  Scenario Outline:Validate entered message on DB
        Given connect to DB
        When get message
        Then validate body contains date "<date>", email "<email>", message "<message>", name "<name>", subject "<subject>"
    Examples:
      |   date          | email           | message    | name           | subject|
      | 2023-09-23      | mnop@ukr.net    |That's it   | Irina          |DBtesting|
#  1260	23 сент. 2023 г., 00:00:00	mnop@ukr.net	That's it	Irina	DBtesting
    @E2E_US16_DB_Deleted @US16_DB
    Scenario: Validate deleted message on DB
      Given connect to DB
      When get message via non-existing name "XXXIrina"
      Then validate  if the message is deleted
      And close the connection for US16

