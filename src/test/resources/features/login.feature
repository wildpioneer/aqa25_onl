Feature: Validation login functionality

  Scenario: Successful login
    Given init browser
    * open login page
    When user atrostyanko@gmail.com with password Qwertyu_1 log in
    * user clicks login button
    Then dashboard page is displayed

  Scenario: Wrong password
    Given init browser
    * open login page
    When user atrostyanko@gmail.com with password Qwertyu_2 log in
    * user clicks login button
    Then error "Email/Login or Password is incorrect. Please try again." is displayed

  Scenario: Wrong username
    Given init browser
    * open login page
    When user atrostyank1o@gmail.com with password Qwertyu_1 log in
    * user clicks login button
    Then error "Email/Login or Password is incorrect. Please try again." is displayed
