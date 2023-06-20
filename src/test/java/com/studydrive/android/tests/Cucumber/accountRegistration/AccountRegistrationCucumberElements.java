package com.studydrive.android.tests.Cucumber.accountRegistration;

import com.studydrive.android.tests.CucumberElement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
@Getter
public enum AccountRegistrationCucumberElements implements CucumberElement {

    ACCOUNT_REGISTRATION_VIEW_STUDY_DRIVE_LOGO(By.id("de.veedapp.veed.login_registration:id/logoTextImageView")),
    CONTINUE_WITH_EMAIL_BUTTON(By.id("de.veedapp.veed.login_registration:id/button_email_login")),
    REGISTRATION_TITLE(By.id("de.veedapp.veed.login_registration:id/subtitleTextView")),
    EMAIL_ADDRESS_INPUT_FIELD(By.xpath("//android.widget.EditText[@text='Enter your email']")),
    EMAIL_ADDRESS_ERROR_MESSAGE(By.xpath("//android.widget.TextView[@text='Please enter a valid email address']")),
    CONTINUE_BUTTON(By.id("de.veedapp.veed.login_registration:id/loadingButtonView")),
    SIGN_UP_VIEW_LOGIN_BUTTON(By.xpath("//android.widget.TextView[@text='Already have an account? Login.']")),
    LOGIN_VIEW_TITLE(By.id("de.veedapp.veed.login_registration:id/textViewLoginTitle")),
    LOGIN_VIEW_SIGN_UP_BUTTON(By.xpath("//android.widget.TextView[@text='New to Studydrive? Sign up.']")),
    ACCOUNT_REGISTRATION_VIEW_TITLE(By.id("de.veedapp.veed.login_registration:id/textViewRegistrationTitle")),
    USERNAME_INPUT_FIELD(By.xpath("//android.widget.EditText[@text='Enter username']")),
    PASSWORD_INPUT_FIELD(By.xpath("//android.widget.EditText[@text='Enter password']")),
    SIGN_UP_BUTTON(By.xpath("//android.widget.TextView[@text='Sign up']")),
    SIGN_UP_PROGRESS_SPINNER(By.id("android:id/progress")),

    ;
    private final By by;
}