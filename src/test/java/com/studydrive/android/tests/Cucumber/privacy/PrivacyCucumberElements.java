package com.studydrive.android.tests.Cucumber.privacy;

import com.studydrive.android.tests.CucumberElement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
@Getter
public enum PrivacyCucumberElements implements CucumberElement {

    STUDY_DRIVE_PRIVACY_TITLE(By.xpath("//android.widget.TextView[@text='Studydrive values your privacy']")),
    STUDY_DRIVE_PRIVACY_ACCEPT_ALL_BUTTON(By.xpath("//android.widget.TextView[@text='Accept all']")),

    ;
    private final By by;
}