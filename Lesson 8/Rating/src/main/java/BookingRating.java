import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookingRating {
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

        WebElement reviewScore = driver.findElement(By.xpath("//a[@data-id=\"review_score-90\"]"));
        reviewScore.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement firstHotel = driver.findElement(By.xpath("(//a[@class=\"hotel_name_link url\"])[1]"));
        firstHotel.click();

        WebElement hotelRating = driver.findElement(By.xpath("(//div[@class=\"bui-review-score__badge\"])[4]"));

        System.out.println("The rating of the chosen hotel is " + hotelRating.getText());

        driver.quit();
    }
}
