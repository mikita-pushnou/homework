import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.UnmarkLettersPage;

import java.util.concurrent.TimeUnit;

public class UnmarkLettersPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private UnmarkLettersPage unmarkLettersPage;
    private static final String LOGIN = "xxx";
    private static final String PASSWORD = "xxx";
    private WebElement letterOneUnmarked;
    private WebElement letterTwoUnmarked;
    private WebElement letterThreeUnmarked;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "../../chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://mail.ru");
        loginPage = new LoginPage(driver);
        loginPage.login(LOGIN, PASSWORD);
    }

    @Test
    public void flagLetterOneTest() {
        unmarkLettersPage = new UnmarkLettersPage(driver);
        unmarkLettersPage.unflagLetterOne();
        letterOneUnmarked = driver.findElement(By.xpath("//span[@title=\"Пометить флажком\"]"));
        Assert.assertTrue(letterOneUnmarked.isDisplayed());
    }

    @Test
    public void flagLetterTwoTest() {
        unmarkLettersPage = new UnmarkLettersPage(driver);
        unmarkLettersPage.unflagLetterTwo();
        letterTwoUnmarked = driver.findElement(By.xpath("//span[@title=\"Пометить флажком\"]"));
        Assert.assertTrue(letterTwoUnmarked.isDisplayed());
    }

    @Test
    public void flagLetterThreeTest() {
        unmarkLettersPage = new UnmarkLettersPage(driver);
        unmarkLettersPage.unflagLetterThree();
        letterThreeUnmarked = driver.findElement(By.xpath("//span[@title=\"Пометить флажком\"]"));
        Assert.assertTrue(letterThreeUnmarked.isDisplayed());
    }

    @After
    public void after() {
        driver.close();
    }
}
