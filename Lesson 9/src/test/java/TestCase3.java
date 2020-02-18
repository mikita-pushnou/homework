import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.format.DateTimeFormatter;
import java.util.Set;

public class TestCase3 {

    public static final String CITY = "Париж";
    public static final String MONTH_START = "February";
    public static final String MONTH_FINISH = "February";
    public static final String LAST_NAME = "Doe";
    public static final String EMAIL = "test@email.com";
    public static final String ADDRESS = "some street";
    public static final String CITY_OF_LIVING = "some city";
    public static final String PHONE = "291111111";
    public static final String CARD = "4242 4242 4242 42";
    public static final String CVC = "123";
    public static final String ERROR_EXPECTED = "Whoops! Looks like you missed a few things – fill in these missing fields and continue:";
    public static final int ADD_DAYS = 3;
    public static final int DURATION = 7;
    public static final int ADULTS = 4;

    @Test
    public void testBooking() {
        String currentDate = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd"));

        System.setProperty("webdriver.chrome.driver", "../../chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");

        WebElement search = driver.findElement(By.xpath("//input[@type=\"search\"]"));
        search.sendKeys(CITY);

        WebElement datePicker = driver.findElement(By.xpath("//div[@class=\"xp__dates-inner\"]"));
        datePicker.click();

        WebElement checkIn = driver.findElement(By.xpath("//span[@aria-label=\"" + (Integer.valueOf(currentDate) + ADD_DAYS) + " " + MONTH_START + " 2020\"]"));
        checkIn.click();
        WebElement checkOut = driver.findElement(By.xpath("//span[@aria-label=\"" + (Integer.valueOf(currentDate) + ADD_DAYS + DURATION) + " " + MONTH_FINISH + " 2020\"]"));
        checkOut.click();

        WebElement guests = driver.findElement(By.xpath("//label[@id=\"xp__guests__toggle\"]"));
        guests.click();
        WebElement adults = driver.findElement(By.xpath("//button[@aria-label=\"Increase number of Adults\"]"));
        for (int i = 2; i < ADULTS; i++) {
            adults.click();
        }

        WebElement rooms = driver.findElement(By.xpath("//button[@aria-label=\"Increase number of Rooms\"]"));
        rooms.click();

        search.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement mostExpensive = driver.findElement(By.xpath("(//a[@data-id=\"pri-5\"])"));
        mostExpensive.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement pricesOrderDesc = driver.findElement(By.xpath("//a[@data-category=\"price\"]"));
        pricesOrderDesc.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cheapestHotel = driver.findElement(By.xpath("(//div[@data-hotelid])[1]"));
        cheapestHotel.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            driver.switchTo().window(window);
        }

        WebElement reserve = driver.findElement(By.xpath("//span[contains(text(),\"Reserve your\")] "));
        reserve.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement IWillReserve = driver.findElement(By.xpath("(.//button[@id=\"hp_book_now_button\"])[1]"));
        IWillReserve.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Select selectFirstRoom = new Select(driver.findElement(By.xpath("(//select[@class=\"ClickTaleSensitive\"])[3]")));
        selectFirstRoom.selectByIndex(1);
        Select selectSecondRoom = new Select(driver.findElement(By.xpath("(//select[@class=\"ClickTaleSensitive\"])[6]")));
        selectSecondRoom.selectByIndex(1);

        WebElement submit = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        submit.submit();

        WebElement lastName = driver.findElement(By.xpath("//input[@id=\"lastname\"]"));
        lastName.sendKeys(LAST_NAME);

        WebElement email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
        email.sendKeys(EMAIL);

        WebElement emailConfirm = driver.findElement(By.xpath("//input[@id=\"email_confirm\"]"));
        emailConfirm.sendKeys(EMAIL);

        WebElement finalDetails = driver.findElement(By.xpath("//button[@type=\"submit\" and @name=\"book\"]"));
        finalDetails.submit();

        WebElement address = driver.findElement(By.xpath("//input[@id=\"address1\"]"));
        address.sendKeys(ADDRESS);

        WebElement cityOfLiving = driver.findElement(By.xpath("//input[@id=\"city\"]"));
        cityOfLiving.sendKeys(CITY_OF_LIVING);

        WebElement phone = driver.findElement(By.xpath("//input[@id=\"phone\"]"));
        phone.sendKeys(PHONE);

        Select selectCardType = new Select(driver.findElement(By.xpath("//select[@id=\"cc_type\"]")));
        selectCardType.selectByIndex(2);

        WebElement card = driver.findElement(By.xpath("//input[@id=\"cc_number\"]"));
        card.sendKeys(CARD);

        Select selectExpiration = new Select(driver.findElement(By.xpath("//select[@id=\"ccYear\"]")));
        selectExpiration.selectByIndex(2);

        WebElement cvc = driver.findElement(By.xpath("//input[@id=\"cc_cvc\"]"));
        cvc.sendKeys(CVC);

        WebElement completeBooking = driver.findElement(By.xpath("(//button[@name=\"book\"])[1]"));
        completeBooking.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement errorMessage = driver.findElement(By.xpath("//span[@class=\"bui-alert__title\"]"));

        String errorActual = errorMessage.getText();

        Assertions.assertEquals(ERROR_EXPECTED, errorActual);

        //driver.quit();
    }
}

