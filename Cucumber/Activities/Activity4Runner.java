package testRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinations"},
    tags = "@activity1_4",
    plugin = { "pretty", "html:target/cucumber-reports/reports" },
    monochrome = true
)

public class Activity4Runner {}