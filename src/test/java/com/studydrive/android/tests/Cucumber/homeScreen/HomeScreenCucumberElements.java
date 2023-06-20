package com.studydrive.android.tests.Cucumber.homeScreen;

import com.studydrive.android.tests.CucumberElement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
@Getter
public enum HomeScreenCucumberElements implements CucumberElement {

    STUDY_DRIVE_NEWSFEED_TITLE(By.id("de.veedapp.veed:id/newsfeedHeaderTextView")),
    STUDY_DRIVE_TODO_LIST(By.id("de.veedapp.veed.community_content:id/todoLinearLayout")),
    STUDY_DRIVE_QUESTIONS_CARDS(By.id("de.veedapp.veed.community_content:id/questionCardViewWrapper")),
    STUDY_DRIVE_HOME_BUTTON(By.id("de.veedapp.veed:id/action_home"));
    private final By by;
}