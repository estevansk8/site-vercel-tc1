package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.example.TestBasicUse;


import java.io.File;

public class TestInsertMercadoria {
    String BASE_URL= "https://site-vercel-tc1.vercel.app/mercadorias/mercadorias.html";
    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    void setup() {
        TestConnection();
    }

    @AfterEach
    void tearDown(){

        driver.quit();
    }

    public void TestConnection() {
        // Caminhos para o Firefox e geckodriver
        String firefoxBinaryPath = "/snap/firefox/current/usr/lib/firefox/firefox";
        String geckoDriverPath = "/snap/firefox/current/usr/lib/firefox/geckodriver";

        // Configurando o binário do Firefox
        FirefoxBinary firefoxBinary = new FirefoxBinary(new File(firefoxBinaryPath));

        // Configurando o geckodriver
        System.setProperty("webdriver.gecko.driver", geckoDriverPath);

        // Configurando as opções do Firefox
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);

        // Criando a instância do WebDriver
        driver = new FirefoxDriver(options);
    }

    @Test
    @DisplayName("ShouldOpenSiteOpenMercadoriasInsertOne")
    public void ShouldOpenSiteOpenMercadoriasInsertOne() {
        driver.get(BASE_URL);
        TestBasicUse testBasicUse = new TestBasicUse();
        testBasicUse.setup();
        testBasicUse.ShouldOpenBrowserAndClickAtMercadoriasButtonTest();

    }

}
