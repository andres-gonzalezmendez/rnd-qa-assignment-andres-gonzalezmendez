package com.petclinic.web.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.petclinic.web.steps",
    plugin = {"pretty", "html:src/test/resources/reports/web-test-report.html"}
)
public class RunCucumberTest {
}