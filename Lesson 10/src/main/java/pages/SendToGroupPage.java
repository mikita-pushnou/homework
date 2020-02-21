package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendToGroupPage {
    @FindBy(xpath = "//span[@title=\"Написать письмо\"]")
    private WebElement composeLetterButton;

    @FindBy(xpath = "(//input[@type=\"text\"])[2]")
    private WebElement receivers;

    @FindBy(xpath = "//span[text()=\"Отправить\"]")
    private WebElement sendButton;

    @FindBy(xpath = "//button[@type=\"button\"]//span[text()=\"Отправить\"]")
    private WebElement sendFinalButton;

    private WebDriver driver;

    public SendToGroupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendToGroup(String listOfReceivers) {
        composeLetterButton.click();
        receivers.sendKeys(listOfReceivers);
        sendButton.click();
        sendFinalButton.click();
    }
}
