package org.example.teste;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.MercadoriaPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class TestInsertMercadoria {

    String BASE_URL = "https://site-vercel-tc1.vercel.app/mercadorias/mercadorias.html";
    WebDriver driver;
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
    @Test
    @DisplayName("Should submit mercadoria form")
    public void ShouldSubmitMercadoriaForm() {
        mercadoriaPage.navigateTo(BASE_URL);
        mercadoriaPage.fillForm("12345", "Teste de mercadoria", "2024-12-31", "10", "20", "30", "6000", "Frágil");
        mercadoriaPage.submitForm();

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

    @Test
    @DisplayName("Should show error when inserting non-numeric value in weight field")
    public void shouldShowErrorForNonNumericWeight() {
        mercadoriaPage.fillForm("12345", "Teste de mercadoria", "2024-12-31", "invalidWeight", "20", "30", "6000", "Frágil");
        mercadoriaPage.submitForm();

        String alertText = mercadoriaPage.waitForAlertAndGetText();
        Assertions.assertEquals("Erro: Peso deve ser um valor numérico", alertText);
    }
}
