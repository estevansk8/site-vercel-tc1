package org.example.teste;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.MercadoriaPage;
import org.example.utils.TestDataGenerator;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
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
import java.time.Instant;
import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.bouncycastle.crypto.tls.ContentType.alert;

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

        mercadoriaPage.fillForm(newCodigo,newDescricao,newValidade,newPeso,newAltura,newLargura,newVolume,newFragilidade);
        mercadoriaPage.submitForm();
        try {
            Thread.sleep(2000); // Pausa de 2 segundos (2000 milissegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String alertText = mercadoriaPage.waitForAlertAndGetText();
        assertThat(alertText).isEqualTo("Código não encontrado!");

    }
    @Test
    @DisplayName("Should update Mercadoria")
    void shouldUpdateMercadoria() {
        // Navigate to the Mercadoria page
        MercadoriaPage mercadoriaPage = new MercadoriaPage(driver);
        mercadoriaPage.navigateTo("https://site-vercel-tc1.vercel.app/mercadorias/mercadorias.html");

        // Generate new data for insertion
        String codigo = TestDataGenerator.generateCodigo();
        String descricao = TestDataGenerator.generateDescricao();
        String validade = TestDataGenerator.generateDataValidade();
        String peso = TestDataGenerator.generatePeso();
        String altura = TestDataGenerator.generateAltura();
        String largura = TestDataGenerator.generateLargura();
        String volume = TestDataGenerator.generateVolume();
        String fragilidade = TestDataGenerator.generateFragilidade();

        // Insert new Mercadoria
        mercadoriaPage.InsertMercadoria(codigo, descricao, validade, altura, fragilidade, peso, volume, largura);
        mercadoriaPage.waitForAlertAndAccept();

        String updatePeso = TestDataGenerator.generatePeso();
        String updateAltura = TestDataGenerator.generateAltura();
        String updateLargura = TestDataGenerator.generateLargura();
        String updateVolume = TestDataGenerator.generateVolume();

        mercadoriaPage.clickAlterar();

        mercadoriaPage.fillForm(codigo, descricao, altura, fragilidade, updateLargura, updatePeso, updateVolume, updateAltura);
        mercadoriaPage.submitForm();
        try {
            Thread.sleep(1000); // Pausa de 2 segundos (2000 milissegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String updateAlertText = mercadoriaPage.waitForAlertAndGetText();
        assertThat(updateAlertText).isEqualTo("Alterado com sucesso!");
    }
}
