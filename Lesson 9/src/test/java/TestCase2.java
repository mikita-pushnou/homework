import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.format.DateTimeFormatter;
import java.util.Set;

public class TestCase2 {
    public static final String CITY = "Париж";
    public static final String MONTH_START = "February";
    public static final String MONTH_FINISH = "February";
    public static final int ADD_DAYS = 3;
    public static final int DURATION = 7;
    public static final int ADULTS = 4;
    public static final int MIN_PRICE_FROM_RANGE = 952;

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

        WebElement hotelPrice = driver.findElement(By.xpath("(//div[contains(text(), \"BYN\")])[3]"));

        int hotelPriceActualResult = Integer.valueOf(hotelPrice.getText().replaceAll("\\D", "")) / DURATION;

        //Check if actual price is inside the price range
        Assertions.assertTrue(hotelPriceActualResult >= MIN_PRICE_FROM_RANGE);

        driver.quit();
    }
}
