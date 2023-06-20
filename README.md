# Studydrive Android Test Automation #

This project runs Automation Test Suites of User SignUp feature for Studydrive app in Android device

This Project uses the build tool Gradle. Please use the wrapper .gradlew instead of any gradle installation on your
local machine.

## Technologies/Frameworks used:

<ul>
<li>Java</li>
<li>Appium</li>
<li>TestNG</li>
<li>Gradle</li>
<li>Cucumber Framework</li>

</ul>

## Global gradle Settings ##

Add the following to your project `gradle.properties` to ensure gradle has enough heap space to work with this project:

~~~~
org.gradle.jvmargs=-Xmx1g
~~~~

### (Optional) Use Build Cache ###

The Gradle build cache is a cache mechanism that aims to save time by reusing outputs produced by other builds. The
build cache works by storing (locally or remotely) build outputs and allowing builds to fetch these outputs from the
cache when it is determined that inputs have not changed, avoiding the expensive work of regenerating them.

More info can be found here: [Gradle Build Cache](https://docs.gradle.org/current/userguide/build_cache.html)

Execute following to enable shared build caching for your builds:

```bash
echo "org.gradle.caching=true" >> ~/gradle.properties
```

## Appium Server setup ##

Install Appium Server. Start Appium server using default IP and port (0.0.0.0:4723).

## Enable USB debugging ##

Enable usb debugging inside the Android device and accept permission request from Appium Server.

https://developer.android.com/studio/debug/dev-options#enable

## apk in the project folder ##

copy apk to the src folder.

## Configure properties file ##

File config.properties at src/test/java/com/studydrive/android/tests/Config/config.properties is used to set up the
test. Available configurations are as following.

| Field Name       | Description                                                                                                                                                                                                                                                                                                           |
|------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| PLATFORM_NAME    | Which mobile OS platform to use                                                                                                                                                                                                                                                                                       |
| PLATFORM_VERSION     | Mobile OS version                                                                                                                                                                                                                                                                                                     |
| DEVICE_NAME         | The kind of mobile device or emulator to use                                                                                                                                                                                                                                                                          |
| AUTOMATION_NAME     | Which automation engine to use                                                                                                                                                                                                                                                                                        |
| APP_PACKAGE         | Java package of the Android app you want to run. By default this capability is received from the package manifest (@package attribute value)                                                                                                                                                                          |
| APPIUM_SERVER    | URL of the appium server                                                                                                                                                                                                                                                                                              |
| STUDY_DRIVE_APP      | Name of the apk file inside the src folder.                                                                                                                                                                                                                                                                           |

### Example: ###

~~~~
PLATFORM_NAME=Android
PLATFORM_VERSION=12
DEVICE_NAME=emulator-5554
AUTOMATION_NAME=uiautomator2
APP_PACKAGE=de.veedapp.veed
APPIUM_SERVER=http://127.0.0.1:4723/wd/hub
STUDY_DRIVE_APP=StudyDrive.apk
~~~~

## Cleaning & Building the project ##

To clean & Build the project you can run

~~~
./gradlew clean assemble
~~~

## Update or Re-fresh Gradle dependencies ##

Use the below command to update the dependencies

~~~
./gradlew build --refresh-dependencies
~~~

## To run Automated Test Scripts of User SignUp feature for Studydrive andriod app ##

Steps to follow:

1. Start the appium server
2. Go to feature file resources/cucumberFeatureFiles/001-accountRegistration/001_accountRegistration.feature
3. Run the feature file

or you can use the below command

~~~
./gradlew cucumber
~~~