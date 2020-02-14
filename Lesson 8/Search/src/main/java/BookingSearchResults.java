import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookingSearchResults {
    public static final String CITY = "Москва";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "../../../../../../Documents/Programming/Java/Automation/Selenium WebDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.booking.com");

        WebElement search = driver.findElement(By.xpath("//input[@type=\"search\"]"));
        search.sendKeys(CITY);

        WebElement datePicker = driver.findElement(By.xpath("//div[@class=\"xp__dates-inner\"]"));
        datePicker.click();

        WebElement checkIn = driver.findElement(By.xpath("//span[@aria-label=\"20 February 2020\"]"));
        checkIn.click();
        WebElement checkOut = driver.findElement(By.xpath("//span[@aria-label=\"21 February 2020\"]"));
        checkOut.click();

        search.submit();

        WebElement searchResult = driver.findElement(By.xpath("//div[contains(@data-et-click, \"customGoal\")]"));
        Boolean isDisplayed = searchResult.isDisplayed();

        System.out.println(isDisplayed ? "You can go to Moscow!" : "There is no available room");

        driver.close();
    }
}
