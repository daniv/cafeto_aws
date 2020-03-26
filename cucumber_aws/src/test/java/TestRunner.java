import io.cucumber.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        monochrome = true,
        strict = true,
        features = "src/test/resources/features",
        glue = {"stepdefs"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class TestRunner {

        private TestNGCucumberRunner testNGCucumberRunner;

        @BeforeClass(alwaysRun = true)
        public void setUpClass() {
                System.setProperty("webdriver.chrome.driver", "D:\\Energage\\Azure\\Repositories\\Energage.AutomationQA\\Chrome\\chromedriver.exe");
                testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        }

        @SuppressWarnings("unused")
        @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
        public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
                testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
        }

        /**
         * Returns two dimensional array of {@link PickleWrapper}s
         * with their associated {@link FeatureWrapper}s.
         *
         * @return a two dimensional array of scenarios features.
         */
        @DataProvider
        public Object[][] scenarios() {
                if (testNGCucumberRunner == null) {
                        return new Object[0][0];
                }
                return testNGCucumberRunner.provideScenarios();
        }

        @AfterClass(alwaysRun = true)
        public void tearDownClass() {
                if (testNGCucumberRunner == null) {
                        return;
                }
                testNGCucumberRunner.finish();
        }

}