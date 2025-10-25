Feature: Virus Test Form Submission

  Scenario Outline: Submit form with all valid inputs <Index>
    Given the user is on the Virus Test page
    When the user fills the form with Age60: "<Age60>", Age10: "<Age10>", Living: "<Living>", Contact: "<Contact>", and Symptoms: "<Symptoms>"
    And clicks on submit
    Then the resultant message should be displayed

    Examples:
  |  Index | Age60 | Age10 | Living | Contact | Symptoms                                        |
  |    1   | Yes   | No    | Alone  | Yes     | Persistent cough                                |
  |    2   | No    | Yes   | Family | No      | Feeling tired or week                           |
  |    3   | Yes   | No    | Alone  | Yes     | Runny nose                                      |
  |    4   | No    | No    | Family | Yes     | Head ache                                       |
  |    5   | Yes   | No    | Alone  | No      | Loss of taste or smell                          |
  |    6   | No    | No    | Family | Yes     | Feeling tired or week,Head ache                 |
  |    7   | Yes   | Yes   | Alone  | No      | Persistent cough,Loss of taste or smell         |
  |    8   | No    | No    | Family | No      |                                                 |

  Scenario: Submit form with no input
    Given the user is on the Virus Test page
    When the user clicks on submit
    Then appropriate validation errors should be displayed