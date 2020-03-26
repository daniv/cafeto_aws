package stepdefs;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions implements En {
    final static Logger logger = LoggerFactory.getLogger(StepDefinitions.class);
    private WebDriver driver;


    public StepDefinitions() {
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);



        Given("^I am on the \"([^\"]*)\" page on URL \"([^\"]*)\"$", (String arg0, String url) ->
        {
            logger.info(() -> "Navigating to page " + arg0);
            driver.get(url);
        });
        And("^I select the \"([^\"]*)\" Menu$", (String arg0) -> {
            WebElement account = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("My Account ")));
            account.click();
            WebElement accountSettings = driver.findElement(By.linkText("Account Settings"));
            accountSettings.click();
        });
        And("^I should see \"([^\"]*)\" message$", (String arg0) -> {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin_head")));
        });
        When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$", (String arg0, String userName) -> {
            logger.info(() -> "Filling element " + arg0);
            WebElement userEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("resolving_input")));
            userEmail.sendKeys(userName);
        });
        And("^I click on the \"([^\"]*)\" button$", (String arg0) -> {
            WebElement next = wait.until(ExpectedConditions.elementToBeClickable(By.id("next_button")));
            next.click();
        });
        And("^I fill the password \"([^\"]*)\"$", (String arg0) -> {
            WebElement pwd = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password")));
            pwd.sendKeys(arg0);
        });
        And("^I click on the SigIn button$", () -> {
            WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.id("signInSubmit-input")));
            submit.click();
        });
        Then("^I am on the \"([^\"]*)\" page on URL \"([^\"]*)\"$", (String arg0, String arg1) -> {
            wait.until(ExpectedConditions.urlToBe("https://console.aws.amazon.com/billing/home?#/account"));
        });
    }
}
