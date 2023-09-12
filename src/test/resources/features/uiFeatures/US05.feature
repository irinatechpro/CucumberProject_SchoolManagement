@US05
Feature: Admins should be able to see and delete Deans

  Background: Login as Admin User

    Given Admin user is on The Managementon Schools website
    And clicks on Login link
    And sees the page has Login title
    When Admin user enters username on Login page "AdminProjectDot"
    And enters password on Login page "Project11+"
    And Admin user clicks on login button
    Then sees the "Admin Management" title

  @US05_TC01

  Scenario: TC01_Admin should be able to see Name, Gender, Phone Number, SSN and User Name information of Deans

    Given Admin user clicks on menu button
    And sees the menu list on the left hand side
    When user clicks on "Dean Management" link
    Then sees the Deans information

  @US05_TC03

  Scenario: TC03-Admin should be able to update Deans

    Given Admin user clicks on menu button
    And sees the menu list on the left hand side
    When user clicks on "Dean Management" link
    And goes to Add Dean section
    And enters name "<name>" on Add Dean section
    And enters surname "<surname>" on Add Dean section
    And enters birthplace "<birthplace>" on Add Dean section
    And clicks on Female for gender on Add Dean section
    And enters Date of Birth on Add Dean section
    And enters Phone number "<Phone number>" on Add Dean section
    And enters ssn number "<ssn number>" on Add Dean section
    And Admin user enters a new username "<username>" on Add Dean section
    And enters the password "Istabul1" on Add Dean section
    And user clicks on submit on Add Dean section
    Then sees the Dean Saved alert
    And Admin user goes to the last page of the dean list
    And goes to the last Dean created
    And clicks on Edit button on the Dean List
    And enters a new Dean name "<name>"
    And enters the password on the edit box "<Istanbul1>"
    And clicks on Female for gender on the edit box
    And Admin user clicks Submit button on the edit box
    Then sees the Dean updated Successful alert