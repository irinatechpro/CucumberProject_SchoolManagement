@US05
Feature: Admins should be able to see and delete Deans

  Background: Login as Admin User

    Given Admin user is on The Managementon Schools website
    And clicks on Login link
    And sees the page has Login title
    When Admin user enters username "AdminProjectDot"
    And enters password "Project11+"
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
    And goes to Add Dean
    And enters name "<name>"
    And enters surname "<surname>"
    And enters birthplace "<birthplace>"
    And clicks on Female for gender
    And enters Date of Birth
    And enters Phone number "<Phone number>"
    And enters ssn number "<ssn number>"
    And Admin user enters a new username "<username>"
    And enters password "Istabul1"
    And user clicks on submit
    Then sees the Dean Saved alert
    And Admin user goes to the last page of the dean list
    And goes to the last Dean created
    And clicks on Edit button
    And enters a new Dean name "<name>"
    And enters the password in the edit box "<Istanbul1>"
    And clicks on Female for gender in the edit box
    And Admin user clicks Submit button
    And sees the Dean updated Successful alert














