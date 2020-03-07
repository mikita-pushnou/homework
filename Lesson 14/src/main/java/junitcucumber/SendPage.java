package junitcucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendPage {
    @FindBy(xpath = "//span[@title=\"Написать письмо\"]")
    private WebElement composeLetterButton;

    @FindBy(xpath = "(//input[@type=\"text\"])[2]")
    private WebElement receivers;

    @FindBy(xpath = "//span[text()=\"Отправить\"]")
    private WebElement sendButton;

    @FindBy(xpath = "//button[@type=\"button\"]//span[text()=\"Отправить\"]")
    private WebElement sendFinalButton;

    @FindBy(xpath = "//button[@data-promo-id=\"extend\"]")
    private WebElement expand;

    @FindBy(xpath = "//button[@data-promo-id=\"decrease\"]")
    private WebElement decrease;

    private WebDriver driver;

    public SendPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void composeLetter() {
        composeLetterButton.click();
    }

    public void expandForm() {
        expand.click();
    }

    public void decreaseForm() {
        decrease.click();
    }

    public void enterReceiver(String receiver) {
        receivers.sendKeys(receiver);
    }

    public void clickFirstButton() {
        sendButton.click();
    }

    public void clickSecondButton() {
        sendFinalButton.click();
    }
}