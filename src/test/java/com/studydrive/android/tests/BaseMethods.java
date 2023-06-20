package com.studydrive.android.tests;

import com.studydrive.android.tests.TestData.TestUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Log4j2
@RequiredArgsConstructor
public class BaseMethods {

    private static final int DEFAULT_TIMEOUT_SLEEP_DIVISOR = 30;
    private static final Duration DEFAULT_WEBDRIVER_WAIT_TIMEOUT = ofSeconds(30);
    public static Properties prop;
    private static AndroidDriver<AndroidElement> driver;

    @Before
    public static void setUp() throws IOException {

        prop = new Properties();
        try (FileInputStream ip = new FileInputStream(
                "src/test/java/com/studydrive/android/tests/Config/config.properties")) {
            prop.load(ip);
        }
        String studyDriveAbsolutePath = new File("src/" + prop.getProperty("STUDY_DRIVE_APP")).getAbsolutePath();

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("PLATFORM_NAME"));
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("PLATFORM_VERSION"));
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DEVICE_NAME"));
        cap.setCapability(MobileCapabilityType.APP, studyDriveAbsolutePath);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("AUTOMATION_NAME"));
        cap.setCapability("appPackage", prop.getProperty("APP_PACKAGE"));
        cap.setCapability("autoGrantPermissions", "true");

        driver = new AndroidDriver<>(new URL(prop.getProperty("APPIUM_SERVER")), cap);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {

        driver.closeApp();
        driver.quit();
    }

    protected AndroidElement findElement(By by) {

        return driver.findElement(by);
    }

    protected AndroidElement findElement(CucumberElement element) {

        return findElement(element.getBy());
    }

    public void writeInElement(String value, CucumberElement element) {

        findElement(element).sendKeys(value);
    }

    public WebElement getAssuredVisibleElement(CucumberElement element) {

        return getAssuredVisibleElement(element.getBy());
    }

    public WebElement getAssuredVisibleElement(By by) {

        return getAssuredVisibleElement(by, DEFAULT_WEBDRIVER_WAIT_TIMEOUT);
    }

    public WebElement getAssuredVisibleElement(By by, Duration timeout) {

        WebElement element = expectationFulfilledAfterWait(visibilityOfElementLocated(by), timeout);
        assertThat("Element '" + by + "' not visible after waiting", element, notNullValue());
        return element;
    }

    public void clickButton(CucumberElement button) {

        WebElement clickableElement = getAssuredClickableElement(button);
        clickButton(button.toString(), clickableElement);
    }

    public boolean visibleAfterWaiting(By selector) {

        return visibleAfterWaiting(selector, DEFAULT_WEBDRIVER_WAIT_TIMEOUT);
    }

    boolean visibleAfterWaiting(By selector, Duration timeout) {

        return expectationFulfilledAfterWait(visibilityOfElementLocated(selector), timeout,
                timeout.dividedBy(DEFAULT_TIMEOUT_SLEEP_DIVISOR)) != null;
    }

    @Nullable
    public <T> T expectationFulfilledAfterWait(ExpectedCondition<T> webElementExpectedCondition) {

        return expectationFulfilledAfterWait(webElementExpectedCondition, DEFAULT_WEBDRIVER_WAIT_TIMEOUT);
    }

    @Nullable
    public <T> T expectationFulfilledAfterWait(ExpectedCondition<T> webElementExpectedCondition, Duration timeout) {

        return expectationFulfilledAfterWait(webElementExpectedCondition, timeout,
                timeout.dividedBy(DEFAULT_TIMEOUT_SLEEP_DIVISOR));
    }

    @Nullable
    public <T> T expectationFulfilledAfterWait(ExpectedCondition<T> webElementExpectedCondition, Duration timeout,
                                               Duration sleep) {

        try {
            return new WebDriverWait(driver, timeout.getSeconds(), sleep.getSeconds()).until(
                    webElementExpectedCondition);
        } catch (TimeoutException e) {
            log.error("Condition not fulfilled after waiting {}: {}", timeout, webElementExpectedCondition);
            return null;
        }
    }

    @NotNull
    WebElement getAssuredClickableElement(CucumberElement cucumberElement) {

        return getAssuredClickableElement(cucumberElement.getBy());
    }

    @NotNull
    WebElement getAssuredClickableElement(By by) {

        WebElement element = expectationFulfilledAfterWait(elementToBeClickable(by));
        assertThat(by + " not clickable after waiting", element, notNullValue());
        return element;
    }

    void clickButton(String buttonName, WebElement clickable) {

        try {
            log.debug("Clicking element \"{}\"", buttonName);
            clickable.click();
        } catch (WebDriverException e) {
            String message = e.getMessage();
            if (message == null || !message.contains("is not clickable at point")) {
                throw e;
            }
            // Element is clickable (i.e. present, visible and enabled) but covered by some other element.
            // So it is save to click via JavaScript
            message = message.split("\n")[0]; // Only first line is relevant
            log.info("Clicking \"{}\" via JavaScript, because element.click() failed: {}", buttonName, message);
            javaScriptClick(clickable);
        }
    }

    protected void javaScriptClick(WebElement element) {

        try {
            JavascriptExecutor executor = driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (RuntimeException e) {
            log.error("Error while clicking \"{}\" via JavaScript", element, e);
        }
    }
}