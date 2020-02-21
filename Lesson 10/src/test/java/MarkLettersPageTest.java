import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MarkLettersPage;

import java.util.concurrent.TimeUnit;

public class MarkLettersPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private MarkLettersPage markLettersPage;
    private static final String LOGIN = "xxx";
    private static final String PASSWORD = "xxx";
    private WebElement letterOneMarked;
    private WebElement letterTwoMarked;
    private WebElement letterThreeMarked;

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
        markLettersPage = new MarkLettersPage(driver);
        markLettersPage.flagLetterOne();
        letterOneMarked = driver.findElement(By.xpath("//span[@title=\"Снять флажок\"]"));
        Assert.assertTrue(letterOneMarked.isDisplayed());
    }

    @Test
    public void flagLetterTwoTest() {
        markLettersPage = new MarkLettersPage(driver);
        markLettersPage.flagLetterTwo();
        letterTwoMarked = driver.findElement(By.xpath("//span[@title=\"Снять флажок\"]"));
        Assert.assertTrue(letterTwoMarked.isDisplayed());
    }

    @Test
    public void flagLetterThreeTest() {
        markLettersPage = new MarkLettersPage(driver);
        markLettersPage.flagLetterThree();
        letterThreeMarked = driver.findElement(By.xpath("//span[@title=\"Снять флажок\"]"));
        Assert.assertTrue(letterThreeMarked.isDisplayed());
    }

    @After
    public void after() {
        driver.close();
    }
}
