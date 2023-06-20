Feature: 001 accountRegistration -001-  Check SignUp functionalities are working as expected

  Scenario Outline: Verify valid error message is displayed when invalid email address is given

    When user sees element ACCOUNT_REGISTRATION_VIEW_STUDY_DRIVE_LOGO
    And user clicks on element CONTINUE_WITH_EMAIL_BUTTON
    And user writes value "<INVALID_EMAIL>" in element EMAIL_ADDRESS_INPUT_FIELD
    And user sees text "Sign up or log in with your email." in element REGISTRATION_TITLE
    And user clicks on element CONTINUE_BUTTON
    Then user sees text "Please enter a valid email address" in element EMAIL_ADDRESS_ERROR_MESSAGE

    Examples:
      | INVALID_EMAIL |
      | testing@123   |
      | testing.com   |
      |               |

  Scenario: Verify user sees Study Drive Home Screen after signing up successfully

    When user sees element ACCOUNT_REGISTRATION_VIEW_STUDY_DRIVE_LOGO
    And user clicks on element CONTINUE_WITH_EMAIL_BUTTON
    And user sees text "Sign up or log in with your email." in element REGISTRATION_TITLE
    And user writes value "rkbhavana17@gmail.com" in element EMAIL_ADDRESS_INPUT_FIELD
    And user clicks on element CONTINUE_BUTTON
    And user writes value "test_username" in element USERNAME_INPUT_FIELD
    And user writes value "test_password" in element PASSWORD_INPUT_FIELD
    And user clicks on element SIGN_UP_BUTTON
    And user sees element SIGN_UP_PROGRESS_SPINNER
    Then user sees text "What are you studying?" in element STUDY_DETAILS_VIEW
    And user sees text "Tell us and we'll find your modules and the best study materials for you" in element STUDY_DETAILS_SECOND_TITLE
    When user clicks on element SELECT_UNIVERSITY_SEARCH_INPUT_FIELD
    And user writes value "987654321" in element SEARCH_UNIVERSITY_INPUT_FIELD
    And user clicks on element SELECT_UNIVERSITY_FROM_SEARCH_RESULTS
    And user clicks on element SELECT_FIELD_OF_STUDIES_INPUT_FIELD
    And user clicks on element SELECT_ENGINEERING_BUTTON
    And user clicks on element SELECT_STUDY_PROGRAM_INPUT_FIELD
    And user clicks on element SELECT_MECHATRONICS_BUTTON
    And user clicks on element SELECT_STARTING_SEMESTER_INPUT_FIELD
    And user clicks on element SELECT_SUMMER_2023_BUTTON
    And user clicks on element STUDY_DETAILS_CONTINUE_BUTTON
    Then user sees text "Studydrive values your privacy" in element STUDY_DRIVE_PRIVACY_TITLE
    When user clicks on element STUDY_DRIVE_PRIVACY_ACCEPT_ALL_BUTTON
    Then user sees text "Newsfeed" in element STUDY_DRIVE_NEWSFEED_TITLE
    And user sees element STUDY_DRIVE_TODO_LIST
    And user sees element STUDY_DRIVE_QUESTIONS_CARDS
    And user sees element STUDY_DRIVE_HOME_BUTTON