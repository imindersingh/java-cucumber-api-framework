package com.imindersingh;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/html"},
        features = "src/test/resources/features",
        glue = "com.imindersingh.stepdefinitions")
public class RunCucumberTest {

    private final static String INTEGRATION = "integration";
    private final static String DEFAULT = "default";
    private final static String DEV = "dev";
    private final static String CONFIG_DIR = "config.dir";
    private final static String CONFIG_ENV = "config.env";
    private final static String CONFIG_DIR_PATH = "src/test/resources/config";

    @BeforeClass
    public static void setEnv() {
        System.setProperty(CONFIG_DIR, CONFIG_DIR_PATH);
        final String configuration = System.getProperty("profile");
        if (configuration.equalsIgnoreCase(DEV)) {
            System.setProperty(CONFIG_ENV, DEV);
        } else if (configuration.equalsIgnoreCase(INTEGRATION)) {
            System.setProperty(CONFIG_ENV, INTEGRATION);
        } else {
            System.setProperty(CONFIG_ENV, DEFAULT);
        }
    }
}
