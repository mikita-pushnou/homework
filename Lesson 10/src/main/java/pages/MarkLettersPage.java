package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarkLettersPage {
    @FindBy(xpath = "//div[@class=\"draggable\"]//a[1]")
    private WebElement firstMailInbox;

    @FindBy(xpath = "//div[@class=\"draggable\"]//a[2]")
    private WebElement secondMailInbox;

    @FindBy(xpath = "//div[@class=\"draggable\"]//a[3]")
    private WebElement thirdMailInbox;

    @FindBy(xpath = "(//div[@class=\"dropdown-actions\"])[1]")
    private WebElement more;

    @FindBy(xpath = "(//span[text()=\"Пометить флажком\"])[1]")
    private WebElement flag;

    private WebDriver driver;

    public MarkLettersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void flagLetterOne() {
        firstMailInbox.click();
        more.click();
        flag.click();
    }

    public void flagLetterTwo() {
        secondMailInbox.click();
        more.click();
        flag.click();
    }

    public void flagLetterThree() {
        thirdMailInbox.click();
        more.click();
        flag.click();
    }
}
