package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OPLTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        initializeWebDriver();
        navigateToBaseUrl();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void testInserirMercadoria() {
        fillInFormWithTestData();
        submitForm();
        verifySuccessMessage();
    }

    private void initializeWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
    }

    private void navigateToBaseUrl() {
        String BASE_URL = "https://site-vercel-tc1.vercel.app/mercadorias/mercadorias.html";
        driver.get(BASE_URL);
    }

    private void closeWebDriver() {
        if (driver != null) {
            driver.quit();
        }
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
}
