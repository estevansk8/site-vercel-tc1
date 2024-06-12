package org.example.teste;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.MercadoriaPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.Locale;

public class TestAlterarMercadoria {
    String BASE_URL = "https://site-vercel-tc1.vercel.app/mercadorias/mercadorias.html";
    WebDriver driver;
    Faker faker = new Faker(new Locale("pt", "BR"));

    MercadoriaPage mercadoriaPage;
    @BeforeAll
    static void setupAll() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    void setup() {
        TestConnection();
        mercadoriaPage = new MercadoriaPage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    public void TestConnection() {
        String firefoxBinaryPath = "/snap/firefox/current/usr/lib/firefox/firefox";
        String geckoDriverPath = "/snap/firefox/current/usr/lib/firefox/geckodriver";
        FirefoxBinary firefoxBinary = new FirefoxBinary(new File(firefoxBinaryPath));
        System.setProperty("webdriver.gecko.driver", geckoDriverPath);
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        driver = new FirefoxDriver(options);
    }
}
