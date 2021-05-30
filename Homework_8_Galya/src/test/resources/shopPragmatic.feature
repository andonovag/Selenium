Feature: Admin area on Pragmatic's shop website
  As a administrator,
  I want to Login, Logout and check Forgotten password functionality on Pragmatic's shop

  Scenario: Successful Admin Login
    Given the admin is on Login Page
    When he enters "admin" as username
    And he enters "parola123!" as password
    And he clicks on the Login button
    Then ensure that admin login is successful and "Dashboard" is visible

  Scenario: Unsuccessful Admin Login
    Given the admin is on Login Page
    When he enters "dasfasdfasdf" as username
    And he enters "dasfkjdasfklflsdj" as password
    And he clicks on the Login button
    Then ensure that admin login is not successful and "No match for Username and/or Password." message is visible

  Scenario: Successful Message in Forgotten Password
    Given the admin is on Login Page
    When  he clicks on the Forgotten Password link
    And ensure that he is on Forgotten Password Page and "Forgot Your Password?" text is visible
    And he enters "milen.strahinski@pragmatic.bg" as e-mail address
    And he clicks on the Reset button
    Then ensure that successful message "An email with a confirmation link has been sent your admin email address." is visible

  Scenario: Unsuccessful Message in Forgotten Password
    Given the admin is on Login Page
    When  he clicks on the Forgotten Password link
    And ensure that he is on Forgotten Password Page and "Forgot Your Password?" text is visible
    And he enters "milen123@pragmatic.bg" as e-mail address
    And he clicks on the Reset button
    Then ensure that unsuccessful message "Warning: The E-Mail Address was not found in our records, please try again!" is visible

  Scenario: Cancel button in Forgotten Password
    Given the admin is on Login Page
    When  he clicks on the Forgotten Password link
    And ensure that he is on Forgotten Password Page and "Forgot Your Password?" text is visible
    And he clicks on the Cancel button
    Then ensure that he is back on the Login Page and text "Please enter your login details." is visible

  Scenario: Successful Admin Logout
    Given the admin is on Login Page
    When he enters "admin" as username
    And he enters "parola123!" as password
    And he clicks on the Login button
    And ensure that admin login is successful and "Dashboard" is visible
    And he clicks on the Logout button
    Then ensure that he is back on the Login Page and text "Please enter your login details." is visible







