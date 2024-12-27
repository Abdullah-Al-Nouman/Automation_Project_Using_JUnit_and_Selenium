import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DhakaStockExchangeScraper {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headed");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    @DisplayName("Scrape Dhaka Stock Exchange Data")
    public void scrapeWebTable() throws IOException {

        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");

        // Find the rows in the table (using class name "table")
        List<WebElement> tableRows = driver.findElements(By.className("table")).get(1).findElements(By.tagName("tr"));


        try (FileWriter writer = new FileWriter("./src/test/resources/dse_data.txt", true)) {

            for (WebElement row : tableRows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));

                // Iterate over each cell and write its content to the file and print in the console
                for (WebElement cell : cells) {
                    String cellData = cell.getText();
                    writer.write(cellData + " ");
                    System.out.print(cellData + " ");
                }
                writer.write("\n");
                System.out.println();
            }
        }
    }

    @AfterAll
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }
}
