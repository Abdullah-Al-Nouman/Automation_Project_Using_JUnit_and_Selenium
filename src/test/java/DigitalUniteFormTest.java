import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DigitalUniteFormTest {
    WebDriver driver;
    Faker faker;

    @BeforeAll
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headed");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        faker = new Faker();
    }

    @Test
    @DisplayName("Submit Digital Unite Practice Form")
    public void testPracticeFormSubmission() throws InterruptedException {
        String randomName = faker.name().firstName();
        String email = randomName.toLowerCase() + "10@gmail.com";
        String phone = Utils.generateRandomPhoneNumber();

        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Utils.scroll(driver, 300);

        List<WebElement> formFields = driver.findElements(By.className("form-control"));
        formFields.get(0).sendKeys(randomName);
        formFields.get(1).sendKeys(phone);
        formFields.get(2).sendKeys("20-10-2024");
        formFields.get(3).sendKeys(email);
        formFields.get(4).sendKeys("This is a test message.");

        WebElement uploadField = driver.findElement(By.id("edit-uploadocument-upload"));
        uploadField.sendKeys(System.getProperty("user.dir") + "/src/test/resources/edu.jpg");
        Thread.sleep(3000);

        WebElement ageCheckbox = driver.findElement(By.id("edit-age"));
        ageCheckbox.click();
        Thread.sleep(5000);

        WebElement submitButton = driver.findElement(By.id("edit-submit"));
        submitButton.click();
        Thread.sleep(2000);

        WebElement confirmationMessage = driver.findElement(By.tagName("h1"));
        String actualMessage = confirmationMessage.getText();
        Assertions.assertEquals("Thank you for your submission!", actualMessage);
    }

    @AfterAll
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
