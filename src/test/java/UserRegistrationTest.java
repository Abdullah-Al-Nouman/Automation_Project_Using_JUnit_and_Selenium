import org.junit.jupiter.api.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserRegistrationTest {
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
    @DisplayName("Submit User Registration Form")
    public void testUserRegistration() throws InterruptedException {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName.toLowerCase() + "10@gmail.com";
        String phone = Utils.generateRandomPhoneNumber();
        String password = Utils.generateRandomPassword();

        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form");

        List<WebElement> formFields = driver.findElements(By.className("ur-frontend-field"));
        formFields.get(0).sendKeys(firstName);
        formFields.get(1).sendKeys(email);
        formFields.get(2).sendKeys(password);
        formFields.get(3).sendKeys(lastName);
        formFields.get(4).click();
        formFields.get(8).sendKeys(phone);

        List<WebElement> dobFields = driver.findElements(By.cssSelector("[type=text]"));
        WebElement dobInput = dobFields.get(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', '1999-10-19')", dobInput);

        formFields.get(10).sendKeys("Bangladeshi");
        formFields.get(11).click();

        Actions actions = new Actions(driver);
        for (int i = 0; i < 18; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        Utils.scroll(driver, 1500);

        formFields.get(28).click();
        Thread.sleep(2000);

        WebElement submitButton = driver.findElement(By.className("ur-submit-button"));
        submitButton.click();
        Thread.sleep(4000);
    }

    @AfterAll
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
