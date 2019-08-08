Feature: Login

-Business Rule
-User should be a registered user.
-User with registered username can login via the login page.

-ToDo list
-Perfoming successful login with valid data
-Checking login feature for invalid data
-Performing datadriven testing for valid data - positive testing
Background:
Given user is on loginpage


Scenario: login with valid data

When user enters valid username
And user enters valid password
And user clicks on login button
Then user is redirected to homepage

Scenario Outline: DataDriven with valid data
When user enters valid <username> and valid <password>
And clicks login button
Then user is shown homepage
Examples:
|username|password|
|lalitha|password123|
|admin|password456|



