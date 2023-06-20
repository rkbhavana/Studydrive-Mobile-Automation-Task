package com.studydrive.android.tests.Cucumber.appStartUp;

import com.studydrive.android.tests.CucumberElement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
@Getter
public enum AppStartUpCucumberElements implements CucumberElement {

    STUDYDRIVE_LOGO(By.id("de.veedapp.veed:id/imageViewLauncherLogo")),

    ;
    private final By by;
}