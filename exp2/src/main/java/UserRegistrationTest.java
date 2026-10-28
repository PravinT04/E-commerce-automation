import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class UserRegistrationTest {

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

        System.out.println("Opening Automation Exercise Website...");
        driver.get("https://automationexercise.com/");
        pause(3);

        System.out.println("Opening Signup Page...");
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        pause(3);

        String email = "john" + System.currentTimeMillis() + "@gmail.com";

        System.out.println("Entering Name...");
        driver.findElement(By.name("name")).sendKeys("John Doe");
        pause(2);

        System.out.println("Entering Email...");
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(email);
        pause(2);

        System.out.println("Clicking Signup...");
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
        pause(4);

        // Personal Information
        driver.findElement(By.id("id_gender1")).click();
        pause(1);

        driver.findElement(By.id("password")).sendKeys("Password123");
        pause(1);

        new Select(driver.findElement(By.id("days"))).selectByVisibleText("10");
        pause(1);

        new Select(driver.findElement(By.id("months"))).selectByVisibleText("May");
        pause(1);

        new Select(driver.findElement(By.id("years"))).selectByVisibleText("2002");
        pause(1);

        // Address Information
        driver.findElement(By.id("first_name")).sendKeys("John");
        pause(1);

        driver.findElement(By.id("last_name")).sendKeys("Doe");
        pause(1);

        driver.findElement(By.id("company")).sendKeys("ABC Technologies");
        pause(1);

        driver.findElement(By.id("address1")).sendKeys("Salem");
        pause(1);

        new Select(driver.findElement(By.id("country"))).selectByVisibleText("India");
        pause(1);

        driver.findElement(By.id("state")).sendKeys("Tamil Nadu");
        pause(1);

        driver.findElement(By.id("city")).sendKeys("Salem");
        pause(1);

        driver.findElement(By.id("zipcode")).sendKeys("636001");
        pause(1);

        driver.findElement(By.id("mobile_number")).sendKeys("9876543210");
        pause(1);

        System.out.println("Creating Account...");
        driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();

        pause(5);

        // Screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Files.copy(
                src.toPath(),
                new File("RegistrationSuccess.png").toPath(),
                StandardCopyOption.REPLACE_EXISTING);

        System.out.println("==================================");
        System.out.println("REGISTRATION SUCCESSFUL");
        System.out.println("Email Used : " + email);
        System.out.println("Screenshot Saved");
        System.out.println("==================================");

        pause(5);

        driver.quit();

        System.exit(0);
    }
}