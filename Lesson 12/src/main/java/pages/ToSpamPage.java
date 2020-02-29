package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToSpamPage {
    @FindBy(xpath = "//div[@class=\"draggable\"]//a[1]")
    private WebElement firstMailInbox;

    @FindBy(xpath = "//span[@title=\"Спам\"]")
    private WebElement toSpamButton;

    @FindBy(xpath = "//a[@href=\"/spam/\"]")
    private WebElement spamFolder;

    @FindBy(xpath = "//div[@class=\"dataset__items\"]//a[@class=\"llct js-letter-list-item llct_last\"]")
    private WebElement firstMailSpam;

    @FindBy(xpath = "//span[@title=\"Не спам\"]")
    private WebElement toInboxButton;

    private WebDriver driver;

    public ToSpamPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void toSpam() {
        firstMailInbox.click();
        toSpamButton.click();
    }

    public void fromSpam() {
        spamFolder.click();
        try {
            firstMailSpam.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            firstMailSpam.click();
        }

        try {
            toInboxButton.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            toInboxButton.click();
        }
    }
}
