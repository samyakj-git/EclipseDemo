package runnerFile;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"resources/features"},
		glue= {"stepDef"},
		monochrome=true,
		plugin = {"pretty","html:target/cucumber-reports/cucumber-html-reports"}
				//,"json:target/cucumber-reports/cucumber-html-reports/common"}
	)
public class APITestRunner {

}
 