package tek.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.bdd.utilities.SeleniumUtility;

public class HooksSteps extends SeleniumUtility {

    @Before
    public void beforeEachScenario() {
        setupBrowser();
    }

    @After
    public void afterEachScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screeShot = takeScreenShot();
            scenario.attach(screeShot, "image/jpg", "failed_Scenario");
        }
            quitBrowser();

    }
}
