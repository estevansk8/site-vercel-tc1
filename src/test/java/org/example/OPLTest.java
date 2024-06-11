package org.example;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OPLTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private Faker faker;
    private final String BASE_URL = "https://site-vercel-tc1.vercel.app/mercadorias/mercadorias.html";

    @BeforeEach
    public void setUp() {
        System.out.println("Setting up driver");

        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chrome-linux64/chrome");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    @DisplayName("Should open and close chrome browser using Manager")
    void shouldOpenAndCloseChromeBrowserUsingManager() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void testInserirMercadoria() {
        fillInFormWithTestData();
        submitForm();
        verifySuccessMessage();
    }

    @Test
    public void testGetSiteTitle() {
        String title = getSiteTitle();
        assertEquals("Speed", title); // Substitua "Expected Title" pelo título esperado do site
    }

    private void fillInFormWithTestData() {
        setInputFieldByName("codigo", "12345");
        setInputFieldByName("descricao", "Teste de mercadoria");
        setInputFieldByName("validade", "12/31/2024");
        setInputFieldByName("peso", "10");
        setInputFieldByName("altura", "20");
        setInputFieldByName("largura", "30");
        setInputFieldByName("volume", "6000");
        setInputFieldByName("fragilidade", "Frágil");
    }

    private void setInputFieldByName(String fieldName, String value) {
        WebElement field = driver.findElement(By.name(fieldName));
        field.sendKeys(value);
    }

    private void submitForm() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    private void verifySuccessMessage() {
        WebElement successMessage = driver.findElement(By.id("resultado"));
        assertEquals("Mercadoria inserida com sucesso!", successMessage.getText());
    }

    private String getSiteTitle() {
        driver.get(BASE_URL);
        return driver.getTitle();
    }
}
