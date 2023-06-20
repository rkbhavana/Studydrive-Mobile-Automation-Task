package com.studydrive.android.tests;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

@RequiredArgsConstructor
public class CommonStepDefinitions {

    private final BaseMethods baseMethods;

    @ParameterType("[A-Za-z_]+\\w*")
    public CucumberElement element(String elementName) {

        return CucumberElementResolver.resolveCucumberElement(elementName);
    }

    @And("user clicks on element {element}")
    public void userClicksOnElement(CucumberElement element) {

        baseMethods.clickButton(element);
    }

    @And("user sees element {element}")
    public void userSeesElement(CucumberElement element) {

        baseMethods.getAssuredVisibleElement(element);
    }

    @And("user writes value {string} in element {element}")
    public void userWritesValueInElement(String value, CucumberElement element) {

        baseMethods.writeInElement(value, element);
    }

    @And("user sees text {string} in element {element}")
    public void usersSeesTextInTheElement(String text, CucumberElement element) {

        AndroidElement elementText = baseMethods.findElement(element);
        assertThat(elementText.getText(), Matchers.containsString(text));
    }
}