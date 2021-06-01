package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinations"},
    tags = "@SimpleAlert",
    plugin = {"pretty"},
    monochrome = true
)

public class Activity6Runner {
    //This is intentionally blank
}