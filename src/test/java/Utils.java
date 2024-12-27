import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class Utils {
    public static void scroll(WebDriver driver, int height) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + height + ")");
    }

    public static String generateRandomPhoneNumber() {
        Random random = new Random();
        return "017" + (1000000 + random.nextInt(9000000));
    }

    public static String generateRandomPassword() {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String numeric = "0123456789";
        String specialChar = "!@#$%^&*";
        String allChar = upperCase + lowerCase + numeric + specialChar;

        StringBuilder password = new StringBuilder();
        Random random = new Random();
        password.append(upperCase.charAt(random.nextInt(upperCase.length())));
        password.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
        password.append(numeric.charAt(random.nextInt(numeric.length())));
        password.append(specialChar.charAt(random.nextInt(specialChar.length())));

        for (int i = 4; i < 8; i++) {
            password.append(allChar.charAt(random.nextInt(allChar.length())));
        }

        return password.toString();
    }
}
