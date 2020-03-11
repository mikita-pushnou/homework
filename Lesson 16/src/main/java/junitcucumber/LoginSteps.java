package junitcucumber;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dbconnection.DBConnection;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    private static final String MAIN_URL = "http://mail.ru";
    private static final String LOGIN = DBConnection.getDBUserCredentials().getLogin();
    private static final String PASSWORD = DBConnection.getDBUserCredentials().getPassword();
    private LoginPage loginPage;
    private WebDriver webDriver;

    public LoginSteps() {
        System.setProperty("webdriver.chrome.driver", "../../chromedriver");
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
    }

    @Given("^I am on main application page$")
    public void loadMainPage() {
        webDriver.get(MAIN_URL);
    }

    @When("^I login as correct user$")
    public void loginAsCorrectUser() {
        loginPage.enterLogin(LOGIN);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickEnterButton();
    }

    @Then("I see logout link")
    public void seeLogoutLink() {
        Assert.assertTrue(loginPage.logoutLinkPresents());
    }

    @After
    public void afterClass() {
        webDriver.quit();
    }
}
