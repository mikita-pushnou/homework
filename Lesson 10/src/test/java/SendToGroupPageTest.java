import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SendToGroupPage;

import java.util.concurrent.TimeUnit;

public class SendToGroupPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private SendToGroupPage sendToGroupPage;
    private static final String LOGIN = "xxx";
    private static final String PASSWORD = "xxx";
    private static final String RECEIVERS = "test1@email.com, test2@email.com, test3@email.com";
    private WebElement lettersSent;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "../../chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://mail.ru");
        loginPage = new LoginPage(driver);
        loginPage.login(LOGIN, PASSWORD);
        sendToGroupPage = new SendToGroupPage(driver);
    }

    @Test
    public void sendToGroupTest() {
        sendToGroupPage.sendToGroup(RECEIVERS);
        lettersSent = driver.findElement(By.xpath("//a[@class=\"layer__link\"]"));
        Assert.assertTrue(lettersSent.isDisplayed());
    }

    @After
    public void after() {
        driver.close();
    }
}
