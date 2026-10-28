import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class UserLoginTest {

    // Delay Method
    public static void pause(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        System.out.println("==================================");
        System.out.println("USER LOGIN TEST");
        System.out.println("==================================");

        System.out.println("Opening SauceDemo...");
        driver.get("https://www.saucedemo.com/");
        pause(3);

        System.out.println("Entering Username...");
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        pause(2);

        System.out.println("Entering Password...");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        pause(2);

        System.out.println("Clicking Login...");
        driver.findElement(By.id("login-button"))
                .click();
        pause(4);

        // Verify Login
        WebElement title = driver.findElement(By.className("title"));

        if (title.isDisplayed()) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }

        pause(2);

        // Screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Files.copy(
                src.toPath(),
                new File("LoginSuccess.png").toPath(),
                StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Screenshot Saved Successfully");

        pause(5);

        driver.quit();

        System.out.println("Browser Closed");

        System.exit(0);
    }
}