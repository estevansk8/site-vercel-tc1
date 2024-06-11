package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TesteBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        String chromeVersion = "125.0.6422.142";

        WebDriverManager.chromedriver().browserVersion(chromeVersion).setup();

        driver = new ChromeDriver(options);
        driver.get("https://site-vercel-tc1.vercel.app/index.html");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        faker = new Faker();
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
