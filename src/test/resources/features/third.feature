Feature: Use background and Rules

  Rule: Rule 1
    Background:
      Given открыт браузер
      * страница логина открыта

    Scenario: scenario 1
      When user "atrostyanko@gmail.com" with password "Qwertyu_1" log in
      Then title is "All Projects"
      And project ID is 123

    Scenario: scenario 2
      When user click to restore password
      Then restore password page is displayed

  Rule: Rule 2
    Background:
      Given открыт браузер

    Scenario: scenario 1
      When user "atrostyanko@gmail.com" with password "Qwertyu_1" log in
      Then title is "All Projects"
      And project ID is 123

    Scenario: scenario 2
      When user click to restore password
      Then restore password page is displayed
