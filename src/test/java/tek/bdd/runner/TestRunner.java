package tek.bdd.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/CreateAccount.feature",
        glue = "tek.bdd.steps",
        dryRun = false,
        tags = "@userStory3",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "html:target/cucumber_report/index.html"
        }
)
public class TestRunner {
}
