package cucumberRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\OleksandrRashevchenk\\IdeaProjects\\CucumberBDDQestit\\src\\test\\java\\features",glue = {"stepDefinitions"  })
public class TestRunner {
}
