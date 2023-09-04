
==================================================================
                FEATURES WRITING CONVENTION
==================================================================

if you are creating file for user story 1 then name your feature as --> US01.feature
At the very top use @US01 tag
Test cases must be written in the same feature file
Before each scenario, use new tag @US01_TC01

==================================================================
                CREATION OF STEP DEFINITIONS
==================================================================

PLEASE CHECK CommonStepDefs CLASS FIRST TO SEE IF YOU HAVE RELEVANT STEP DEFINED ALREADY

Create Step Definition Class to named after your test case --> US01_StepDefs

==================================================================
                    UTILITY FOLDERS
==================================================================

The utilities folder will contain a set of reusable scripts to
handle common test automation tasks:

------------------------------------------------------------------
    - ActionsUtils
        Helper methods for keyboard/mouse actions done via
        Selenium WebDriver
------------------------------------------------------------------
    - BrowserUtils
        Browser specific helpers like switching frames, windows,
        etc
------------------------------------------------------------------
    - ConfigReader
        For reading and parsing configuration files
------------------------------------------------------------------
    - DataProviderUtils
        Methods for data-driven testing using data providers
------------------------------------------------------------------
    - Driver
        Scripts for initializing the chosen browser driver
        like ChromeDriver
------------------------------------------------------------------
    - ExcelUtil
        Helper functions for reading/writing test data
        from Excel sheets
------------------------------------------------------------------
    - ExtentReports
        For generating HTML test reports using Extent Reports
------------------------------------------------------------------
    - JSUtils
        JavaScript helper methods for browser interactions
------------------------------------------------------------------
    - ListenerUtils
        Custom listener implementations for events like
        test retries
------------------------------------------------------------------
    - LoggerUtils
        Logging helper functions to print logs and debug info
------------------------------------------------------------------
    - MediaUtils
        Helper functions related to media capturing and comparison
------------------------------------------------------------------
    - WaitUtils
        Custom wait/sleep functions like explicit/fluent waits
------------------------------------------------------------------
Keeping these automated testing utilities separate improves
code reuse and reduces duplication across tests

==================================================================
           TIPS FOR CREATING PAGES FOR NEXT PROJECTS
==================================================================

- Use PascalCase for class names, such as LoginPage or CheckoutPage
  This is the standard convention in Java programming

- Name each class after the page it represents, like Homepage or
  AccountPage. This makes it easy to understand what each class is for

- For sub-pages, include the parent page name first,
  like LoginPage.ForgotPasswordPage.

- Do not use abbreviations, e.g. RegPage, instead RegistrationPage

- Add the word "Page" to the end of each page class
  such as HomePage or SettingsPage
  This makes it clear that these classes represent pages

- Use clear WebElement names that relate to page functionality
  such as enterUsername() or submitOrder(). This includes
  any method names

- Avoid unnecessarily long class or method names;
  keep them short but descriptive

==================================================================
           USEFUL TIPS FOR CREATING CONFIG FILES
==================================================================

- Browser settings: includes browser name and headless preferences

- Environment URLs: includes URLs for dev, test, staging,
                    and production environments

- Application credentials: includes usernames and passwords
                           for test accounts

- Test data: includes predefined values for use in tests

- Test run options: includes options for browser size,
                    headless or UI mode

- Reporting settings: includes report file path and
                      formats such as HTML

- Test grouping: includes the selection of which tests to include or exclude

- Test retry counts: includes the number of times to retry failures