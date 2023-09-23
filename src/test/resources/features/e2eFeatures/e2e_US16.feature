  @E2E_US16
    Feature: The Vice Dean should be able to view the messages sent by users.
      @US16_API
        Scenario:Validate contactMessages on database
        Given send get request to get all messages
        Then validate ID, date, email , message, name, subject by API
      @US16_API_Deleted @US16_API
      Scenario: Validate deleted user on API
        Given send get request to get all messages
        Then validate message is deleted




      @US16_DB
  Scenario Outline:
      Given connect to database for DB
      When enter contact_massage
        Then validate message ID "<ID>", date "<date>", email "<email>", message "<message>", name "<name>", subject "<subject>" is edited
        Then verify ability to delete messages
        And close the connection for US19
        Examples:
          | ID | date      | email           | message    | name           | subject|
          |20  | 2023-09-02| yusuf@gmail.com | 1. message | yusuf          |test  |