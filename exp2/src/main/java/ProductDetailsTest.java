import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ProductDetailsTest {

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
        System.out.println("PRODUCT DETAILS TEST");
        System.out.println("==================================");

        // Open Website
        System.out.println("Opening SauceDemo...");
        driver.get("https://www.saucedemo.com/");
        pause(3);

        // Login
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

        // Open Product
        System.out.println("Opening First Product...");
        driver.findElement(By.className("inventory_item_name"))
                .click();

        pause(4);

        // Read Product Details
        String productName = driver.findElement(By.className("inventory_details_name")).getText();

        String productPrice = driver.findElement(By.className("inventory_details_price")).getText();

        String productDescription = driver.findElement(By.className("inventory_details_desc")).getText();

        System.out.println("----------------------------------");
        System.out.println("Product Name : " + productName);
        System.out.println("Product Price : " + productPrice);
        System.out.println("Description :");
        System.out.println(productDescription);
        System.out.println("----------------------------------");

        pause(3);

        // Navigate Back
        System.out.println("Navigating Back...");
        driver.navigate().back();

        pause(3);

        // Verify Product List
        WebElement title = driver.findElement(By.className("title"));

        if (title.isDisplayed()) {
            System.out.println("Returned to Product List Successfully");
        }

        pause(2);

        // Take Screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Files.copy(
                src.toPath(),
                new File("ProductDetails.png").toPath(),
                StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Screenshot Saved Successfully");

        pause(5);

        driver.quit();

        System.out.println("Browser Closed");
        System.out.println("Test Completed Successfully");

        System.exit(0);
    }
}