package org.example.teste;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.MercadoriaPage;
import org.example.utils.TestDataGenerator;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestAlterarMercadoria {
    String BASE_URL = "https://site-vercel-tc1.vercel.app/mercadorias/alterar.html";
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
    @Test
    @DisplayName("Should dont find codigo")
    void shouldDontFindCodigo() {
        // Navigate to the Mercadoria page
        MercadoriaPage mercadoriaPage = new MercadoriaPage(driver);
        mercadoriaPage.navigateTo(BASE_URL);

        // Generate new data for update
        String newCodigo = TestDataGenerator.generateCodigo();
        String newDescricao = TestDataGenerator.generateDescricao();
        String newValidade = TestDataGenerator.generateDataValidade();
        String newPeso = TestDataGenerator.generatePeso();
        String newAltura = TestDataGenerator.generateAltura();
        String newLargura = TestDataGenerator.generateLargura();
        String newVolume = TestDataGenerator.generateVolume();
        String newFragilidade = TestDataGenerator.generateFragilidade();

        mercadoriaPage.fillForm(newCodigo, newDescricao, newValidade, newPeso, newAltura, newLargura, newVolume, newFragilidade);

        mercadoriaPage.submitForm();

        String alertText = mercadoriaPage.waitForAlertAndGetText();
        assertThat(alertText).isEqualTo("Código não encontrado!");

    }
    @Test
    @DisplayName("ShouldUpdateMercadoria")
    void ShouldUpdateMercadoria() {
        // Navigate to the Mercadoria page
        MercadoriaPage mercadoriaPage = new MercadoriaPage(driver);
        mercadoriaPage.navigateTo(BASE_URL);

        // Generate new data for update
        String newCodigo = TestDataGenerator.generateCodigo();
        String newDescricao = TestDataGenerator.generateDescricao();
        String newValidade = TestDataGenerator.generateDataValidade();
        String newPeso = TestDataGenerator.generatePeso();
        String newAltura = TestDataGenerator.generateAltura();
        String newLargura = TestDataGenerator.generateLargura();
        String newVolume = TestDataGenerator.generateVolume();
        String newFragilidade = TestDataGenerator.generateFragilidade();

        mercadoriaPage.fillForm(newCodigo, newDescricao, newValidade, newPeso, newAltura, newLargura, newVolume, newFragilidade);

        mercadoriaPage.submitForm();

        String alertText = mercadoriaPage.waitForAlertAndGetText();
        assertThat(alertText).isEqualTo("Código não encontrado!");

    }
}
