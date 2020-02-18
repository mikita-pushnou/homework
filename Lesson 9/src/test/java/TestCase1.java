import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

public class TestCase1 {
    public static final String CITY = "Париж";
    public static final String MONTH_START = "February";
    public static final String MONTH_FINISH = "February";
    public static final int ADD_DAYS = 3;
    public static final int DURATION = 7;
    public static final int MAX_PRICE_FROM_RANGE = 119;

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

        search.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cheapest = driver.findElement(By.xpath("(//a[@data-id=\"pri-1\"])[1]"));
        cheapest.click();

        WebElement searchResult = driver.findElement(By.xpath("//div[contains(@data-et-click, \"customGoal\")]"));
        Boolean isDisplayedActualResult = searchResult.isDisplayed();

        //Check that such Hotels exist
        Assertions.assertTrue(isDisplayedActualResult);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> ratings = driver.findElements(By.xpath("//div[@data-score]"));
        double topRating = 1.0;
        for (WebElement rating : ratings) {
            if (!(rating.getAttribute("data-score").isEmpty()) && Double.valueOf(rating.getAttribute("data-score")) > topRating) {
                topRating = Double.valueOf(rating.getAttribute("data-score"));
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement topHotel = driver.findElement(By.xpath("//div[@data-score=\"" + topRating + "\"]"));
        topHotel.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            driver.switchTo().window(window);
        }

        WebElement hotelPrice = driver.findElement(By.xpath("(//div[contains(text(), \"BYN\")])[1]"));

        int hotelPriceActualResult = Integer.valueOf(hotelPrice.getText().replace("BYN ", "")) / DURATION;

        //Check if actual price is inside the price range
        Assertions.assertTrue(hotelPriceActualResult <= MAX_PRICE_FROM_RANGE);

        driver.quit();
    }
}
