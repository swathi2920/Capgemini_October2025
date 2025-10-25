Feature: State Pass Application

  Scenario Outline: When the user enters valid travel details for state pass <Index>
    Given the user is on the State Pass page
    When the user enters "<Name>", "<State>", "<Gender>", "<Email>", "<Mobile1>", "<Mobile2>", "<Mobile3>", "<Aadhaar>", "<Reason>", "<TravelBy>", "<AnythingToSay>","<Date>"
    And the user clicks the Submit button
    Then the user should see the submitted details in the confirmation view

    Examples:
   | Index | Name     | State        | Gender    | Email              | Mobile1 | Mobile2 | Mobile3 | Aadhaar      | Reason       | TravelBy | AnythingToSay              | Date      |
   |  1    | Soham    | Maharashtra  | Female    | sumap@mail.com     | 789     | 012     | 3456    | 123456789012 | Wedding      | Bus      | Need pass urgently         | 26/04/2021|
   |  2    | soham    | Goa          | Female    | sumap@mail.com     | 998     | 877     | 6655    | 234567890123 | Vaccination  | Train    | Need healthcheckup         | 12/02/2022|
   |  3    | soham    | Kerala       | Male      | ssumap@mail.com    | 887     | 766     | 5544    | 345678901234 | Interview    | Car      | Job interview letter       | 01/11/2020|
   |  4    | soham    | Gujarat      | Female    | saman@mail.com     | 776     | 655     | 4433    | 456789012345 | Funeral      | Bus      |                            | 22/06/2021|
   |  5    | soham    | Delhi        | Female    | sohamumap@mail.com | 766     | 544     | 3322    | 567890123456 | Exams        | Train    | Final semester exams       | 05/11/2022|
   |  6    | Soham    | Punjab       | Others    | sssumap@mail.com   | 912     | 345     | 6789    | 678901234567 | Wedding      | Car      | Wedding is tomorrow        | 12/09/2023|

  Scenario: When the user submits without any input
    Given the user is on the State Pass page
    When the user clicks the Submit button without filling the form
    Then the user should see a validation message

   Scenario: When the user submits with invalid Email
    Given the user is on the State Pass page
    When the user enters "Raju", "Goa", "Male", "231", "567", "876", "987", "234567888", "Wedding", "Bus", "Need to attend wedding","27/01/2024"
    And the user enters Invalid Email from Excel File
    And the user clicks the Submit button
   Then the user should see an email validation error
   
   


  # NEW SCENARIO FOR INVALID MOBILE NUMBER
  Scenario Outline: Submission with Invalid Mobile Number Format "<MobileType>"
    Given the user is on the State Pass page
    When the user enters valid personal and travel details: "<Name>", "<State>", "<Gender>", "<Email>", "<InvalidMobile1>", "<InvalidMobile2>", "<InvalidMobile3>", "<Aadhaar>", "<Reason>", "<TravelBy>", "<AnythingToSay>", "<Date>"
    And the user clicks the Submit button
    Then the user should see a clear validation error message for the mobile field

    Examples:
   | Index | Name     | State        | Gender    | Email              | Mobile1 | Mobile2 | Mobile3 | Aadhaar      | Reason       | TravelBy | AnythingToSay              | Date      |
   |  1    | Hamso    | Maharashtra  | Male      | Hamso@mail.com     | 1       | 04      | 34      | 123456789012 | Wedding      | Bus      | Need pass urgently         | 26/04/2021|
   |  2    | Henry    | Goa          | Female    | henry@mail.com     | 02      | 06      | 6       | 234567890123 | Vaccination  | Train    | Need healthcheckup         | 12/02/2022|
   |  3    | sohamm   | Goa          | Female    | sohamm@mail.com    | 05      | 02      | 8       | 234567890123 | Vaccination  | Train    | Need healthcheckup         | 13/02/2022|
   