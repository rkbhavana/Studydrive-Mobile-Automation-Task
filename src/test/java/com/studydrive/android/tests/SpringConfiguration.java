package com.studydrive.android.tests;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@CucumberContextConfiguration
public class SpringConfiguration {

    @Before
    public void setupCucumberSpringContext() {
        // Dummy method so cucumber will recognize this class as glue
        // and use its context configuration.
    }

    @Configuration
    @ComponentScan({"import com.studydrive.android.tests.Cucumber"})
    static class SpringContextConfiguration {

    }
}