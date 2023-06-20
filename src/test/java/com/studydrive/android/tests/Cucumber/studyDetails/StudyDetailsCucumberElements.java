package com.studydrive.android.tests.Cucumber.studyDetails;

import com.studydrive.android.tests.CucumberElement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
@Getter
public enum StudyDetailsCucumberElements implements CucumberElement {

    BACK_BUTTON(By.id("de.veedapp.veed:id/backImageButton")),
    STUDY_DETAILS_VIEW(By.xpath("//android.widget.TextView[@text='What are you studying?']")),
    STUDY_DETAILS_SECOND_TITLE(By.id("de.veedapp.veed:id/selectStudiesSecondTitleView")),
    SEARCH_UNIVERSITY_INPUT_FIELD(By.xpath("//android.widget.EditText[@text='Search university']")),
    SELECT_UNIVERSITY_SEARCH_INPUT_FIELD(By.id("de.veedapp.veed:id/studyCustomEditText")),
    SELECT_UNIVERSITY_FROM_SEARCH_RESULTS(By.xpath("//android.widget.TextView[@text='987654321']")),
    SELECT_FIELD_OF_STUDIES_INPUT_FIELD(By.xpath("//android.widget.EditText[@text='Select field of studies']")),
    SELECT_ENGINEERING_BUTTON(By.xpath("//android.widget.TextView[@text='Engineering']")),
    SELECT_STUDY_PROGRAM_INPUT_FIELD(By.xpath("//android.widget.EditText[@text='Select study programme']")),
    SELECT_MECHATRONICS_BUTTON(By.xpath("//android.widget.TextView[@text='Mechatronics']")),
    SELECT_STARTING_SEMESTER_INPUT_FIELD(By.xpath("//android.widget.EditText[@text='Select starting semester']")),
    SELECT_SUMMER_2023_BUTTON(By.xpath("//android.widget.TextView[@text='Summer 2023']")),
    STUDY_DETAILS_CONTINUE_BUTTON(By.id("de.veedapp.veed:id/loadingButtonContinue"));
    private final By by;
}