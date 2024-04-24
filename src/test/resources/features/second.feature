Feature: Параметризированные тесты

  Scenario: Параметризация степов
    Given открыт браузер
    * страница логина открыта
    When user "atrostyanko@gmail.com" with password "Qwertyu_1" log in
    Then title is "All Projects"
    And project ID is 123

  Scenario: Параметризация степов с помощью RegEx
    Given открыт браузер
    * страница логина открыта
    When user "atrostyanko@gmail.com" with password "Qwertyu_1" log in
    Then title is All Projects
    And project ID is "123432"
    And all elements "are not" visible
    And all elements "are" visible
    And all elements are not visible

  Scenario Outline: Параметризация при помощи таблицы значений
    Given открыт браузер
    * страница логина открыта
    When user "<username>" with password "<password>" log in
    Then project ID is <prId>

    Examples:
      | username               | password  | prId |
      | atrostyanko@gmail.com  | Qwertyu_1 | 123  |
      | atrostyanko1@gmail.com | Qwertyu_2 | 124  |
      | atrostyanko2@gmail.com | Qwertyu_3 | 125  |

  Scenario: Параметризация шага с большим количеством данных
    Given открыт браузер
    * страница логина открыта
    When user logged in with
      | username | atrostyanko@gmail.com |
      | password | Qwertyu_1             |
      | age      | 45                    |
      | sex      | M                     |
    Then title is "All Projects"
    And project ID is 123

  Scenario: Параметризация с большим количеством данных в одном шаге
    Given открыт браузер
    * страница логина открыта
    When user logged in with 1
      | username               | password  | age | sex |
      | atrostyanko@gmail.com  | Qwertyu_1 | 45  | M   |
      | atrostyanko1@gmail.com | Qwertyu_2 | 54  | F   |
    Then title is "All Projects"
    And project ID is 123
