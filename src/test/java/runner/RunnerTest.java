package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue={"stepDefination"},tags="@Regression",plugin="html:target/TestReport/test.html")
public class RunnerTest {

}
