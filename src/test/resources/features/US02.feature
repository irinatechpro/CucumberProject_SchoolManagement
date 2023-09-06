@US02
Feature:

  Background:
  Given user goes to url
  @US02_TC01
  Scenario:
  When User clicks on the login link
  And User sends the user name
    And User sends the password
    And User clicks on the login button
    Then Verify if the user logged in

  @US02_TC02
  Scenario:
  When Click on the Menu Button
  And Open the Main menu
  And Click on the Guest User
  And Open the Guest user List
  And Click on Delet button
    Then Verify if the user is deleted

