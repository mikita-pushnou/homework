package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnmarkLettersPage {
    @FindBy(xpath = "//div[@class=\"draggable\"]//a[1]")
    private WebElement firstMailInbox;

    @FindBy(xpath = "//div[@class=\"draggable\"]//a[2]")
    private WebElement secondMailInbox;

    @FindBy(xpath = "//div[@class=\"draggable\"]//a[3]")
    private WebElement thirdMailInbox;

    @FindBy(xpath = "(//div[@class=\"dropdown-actions\"])[1]")
    private WebElement more;

    @FindBy(xpath = "(//span[text()=\"Снять флажок\"])[1]")
    private WebElement unFlag;

    private WebDriver driver;

    public UnmarkLettersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void unflagLetterOne() {
        firstMailInbox.click();
        more.click();
        unFlag.click();
    }

    public void unflagLetterTwo() {
        secondMailInbox.click();
        more.click();
        unFlag.click();
    }

    public void unflagLetterThree() {
        thirdMailInbox.click();
        more.click();
        unFlag.click();
    }
}
