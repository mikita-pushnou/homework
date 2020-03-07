package junitcucumber;

import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SendSteps {
    private static final String INBOX_URL = "https://e.mail.ru/inbox/";
    private static final String LOGIN = "mikita.pushnou";
    private static final String PASSWORD = "!@Umwbar1";
    private static final String RECEIVER = "test3@mail.com";
    private LoginPage loginPage;
    private SendPage sendPage;
    private WebDriver webDriver;
    private EyesRunner runner;
    private WebElement lettersSent;
    private Eyes eyes;

    public SendSteps() {
        System.setProperty("webdriver.chrome.driver", "../../chromedriver");
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
        sendPage = new SendPage(webDriver);
    }

    @Before
    public void before() {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get("http://mail.ru");
        loginPage = new LoginPage(webDriver);
        runner = new ClassicRunner();

        eyes = new Eyes(runner);
        eyes.setMatchLevel(MatchLevel.LAYOUT);
        eyes.setApiKey("lmgXUpJbhSQNZcgJ0upVdhgdrTJ3FSdWUsAlDd5Frqk110");
        eyes.open(webDriver, "Lesson 14", "Send mail");
        loginPage.enterLogin(LOGIN);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickEnterButton();
    }

    @Given("^I am on inbox application page$")
    public void loadInboxPage() {
        webDriver.get(INBOX_URL);
    }

    @When("^I click create new message$")
    public void iClickCreateNewMessage() {
        sendPage.composeLetter();
        sendPage.expandForm();
    }

    @Then("^I create the first screenshot$")
    public void iCreateTheFirstScreenshot() {
        eyes.setMatchLevel(MatchLevel.LAYOUT);
        eyes.checkWindow("First screenshot");
    }

    @When("^I populate all the required fields with valid data$")
    public void iPopulateAllTheRequiredFieldsWithValidData() {
        sendPage.enterReceiver(RECEIVER);
        sendPage.decreaseForm();

    }

    @Then("^I create the second screenshot$")
    public void iCreateTheSecondScreenshot() {
        eyes.setMatchLevel(MatchLevel.LAYOUT);
        eyes.checkWindow("Second screenshot");
    }

    @When("^I click send button$")
    public void iClickSendButton() throws InterruptedException {
        Thread.sleep(3000);
        sendPage.expandForm();
        sendPage.clickFirstButton();
        sendPage.clickSecondButton();
    }

    @Then("^I create the third screenshot$")
    public void iCreateTheThirdScreenshot() {
        eyes.setMatchLevel(MatchLevel.LAYOUT);
        eyes.checkWindow("Third screenshot");
        eyes.closeAsync();
        eyes.abortIfNotClosed();
        TestResultsSummary allTestResults = runner.getAllTestResults();
        System.out.println(allTestResults);
        for (int i = 0; i < allTestResults.getAllResults().length; i++) {
            Assert.assertTrue(allTestResults.getAllResults()[i].getTestResults().isPassed());
        }
    }

    @After
    public void after() {
        webDriver.quit();
    }
}
