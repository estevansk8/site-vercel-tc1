package org.example.teste;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.MercadoriaPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxBinary;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBasicUse {
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
    @DisplayName("Should open test Speed Site")
    public void shouldOpenSpeedSiteTest() {
        mercadoriaPage.navigateTo(BASE_URL);
    }

    @Test
    @DisplayName("Should found input descricao and send key")
    public void shouldFoundInputDescricaoAndSendKey() {
        mercadoriaPage.navigateTo(BASE_URL);
        //mercadoriaPage.clickMercadoriasButton();
        mercadoriaPage.setDescricao("Produto preenchido pelo PC");

        // Pausa de 3 segundos para visualização
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Should found input date and send key")
    public void shouldFoundInputDateAndSendKey() {
        mercadoriaPage.navigateTo(BASE_URL);
        //mercadoriaPage.clickMercadoriasButton();

        LocalDate date = LocalDate.of(2024, 6, 12);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(formatter);
        mercadoriaPage.setDate(formattedDate);

        // Pausa de 3 segundos para visualização
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Should found input peso and send key")
    public void shouldFoundInputPesoAndSendKey() {
        mercadoriaPage.navigateTo(BASE_URL);
        //mercadoriaPage.clickMercadoriasButton();
        mercadoriaPage.setPeso("10");

        // Pausa de 3 segundos para visualização
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Should found input codigo and send key")
    public void shouldFoundInputCodigoAndSendKey() {
        mercadoriaPage.navigateTo(BASE_URL);
        //mercadoriaPage.clickMercadoriasButton();
        mercadoriaPage.setCodigo("123");

        // Pausa de 3 segundos para visualização
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Should found input altura and send key")
    public void shouldFoundInputAlturaAndSendKey() {
        mercadoriaPage.navigateTo(BASE_URL);
        //mercadoriaPage.clickMercadoriasButton();
        mercadoriaPage.setAltura("20");

        // Pausa de 3 segundos para visualização
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Should found input largura and send key")
    public void shouldFoundInputLarguraAndSendKey() {
        mercadoriaPage.navigateTo(BASE_URL);
        //mercadoriaPage.clickMercadoriasButton();
        mercadoriaPage.setLargura("30");

        // Pausa de 3 segundos para visualização
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Should found input volume and send key")
    public void shouldFoundInputVolumeAndSendKey() {
        mercadoriaPage.navigateTo(BASE_URL);
        //mercadoriaPage.clickMercadoriasButton();
        mercadoriaPage.setVolume("6000");

        // Pausa de 3 segundos para visualização
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Should found input fragilidade and send key")
    public void shouldFoundInputFragilidadeAndSendKey() {
        mercadoriaPage.navigateTo(BASE_URL);
        //mercadoriaPage.clickMercadoriasButton();
        mercadoriaPage.setFragilidade("Frágil");

        // Pausa de 3 segundos para visualização
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

