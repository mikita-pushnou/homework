import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ToSpamPage;

import java.util.concurrent.TimeUnit;

public class ToSpamPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ToSpamPage spamPage;
    private static final String LOGIN = "xxx";
    private static final String PASSWORD = "xxx";
    private WebElement toSpamResult;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "../../chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://mail.ru");
        loginPage = new LoginPage(driver);
        loginPage.login(LOGIN, PASSWORD);
        spamPage = new ToSpamPage(driver);
        toSpamResult = driver.findElement(By.xpath("//div[@title=\"Mail.ru – больше, чем почта. Познакомьтесь с проектами Mail.ru Group\"]"));
    }

    @Test
    public void toSpamTest() {
        spamPage.toSpam();
        Assert.assertFalse(!toSpamResult.isDisplayed());
    }

    @After
    public void after() {
        driver.close();
    }
}
