package junitcucumber.steps;

import core.browser.DriverManager;
import core.browser.DriverManagerFactory;
import core.configuration.Configuration;
import core.dbconnection.DBConnection;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junitcucumber.pages.LoginPage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    private static Logger logger = Logger.getLogger(LoginSteps.class);
    private static final String LOGIN = DBConnection.getDBUserCredentials().getLogin();
    private static final String PASSWORD = DBConnection.getDBUserCredentials().getPassword();
    private static final String MAIN_URL = Configuration.getMainUrl();
    private LoginPage loginPage;
    private WebDriver webDriver;
    private DriverManager driverManager;

    public LoginSteps() {
        driverManager = DriverManagerFactory.getManager(Configuration.getDriverType());
        webDriver = driverManager.getDriver();
        loginPage = new LoginPage(webDriver);
    }

    @Before
    public void before() {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get(MAIN_URL);
        logger.info("Just a log message");
    }

    @When("^I login as correct user$")
    public void loginAsCorrectUser() {
        loginPage.enterLogin(LOGIN);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickEnterButton();
    }

    @When("^I login as user with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLoginAsUserWithAnd(String name, String password) {
        loginPage.enterLogin(name);
        loginPage.enterPassword(password);
        loginPage.clickEnterButton();
    }

    @Then("I see logout link")
    public void seeLogoutLink() {
        Assert.assertTrue(loginPage.logoutLinkPresents());
    }

    @Then("^I see error message$")
    public void iSeeErrorMessage() {
        Assert.assertTrue(loginPage.logoutLinkErrorPresents());
    }

    @After
    public void afterClass() {
        driverManager.quitDriver();
    }
}
