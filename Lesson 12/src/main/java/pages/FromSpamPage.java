package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FromSpamPage {
    @FindBy(xpath = "//a[@href=\"/spam/\"]")
    private WebElement spamFolder;

    @FindBy(xpath = "//div[@class=\"dataset__items\"]//a[@class=\"llct js-letter-list-item llct_last\"]")
    private WebElement firstMailSpam;

    @FindBy(xpath = "//span[@title=\"Не спам\"]")
    private WebElement toInboxButton;

    private WebDriver driver;

    public FromSpamPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fromSpam() {
        spamFolder.click();
        try {
            firstMailSpam.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            firstMailSpam.click();
        }

        toInboxButton.click();
    }
}


