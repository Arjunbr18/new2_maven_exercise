import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebpageTest {
    private static WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        // Ensure ChromeDriver is set in system properties or path
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Wait for the page title to contain "Sample Website"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://vinayakewit.github.io/MavenTest/");
        wait.until(ExpectedConditions.titleContains("Sample Website"));
    }

    @Test
    public void titleValidationTest() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Sample Website";

        // Validate the actual title matches the expected title
        Assert.assertEquals(actualTitle, expectedTitle, "The page title is not as expected.");
    }

    @AfterTest
    public void closeBrowser() {
        // Quit the browser after the test
        driver.quit();
    }
}
