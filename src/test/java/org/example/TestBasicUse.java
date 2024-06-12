package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBasicUse {
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

        // Exemplo de navegação
        driver.get("https://www.google.com");
    }
    @Test
    @DisplayName("Should open test Speed Site")
    public void ShouldOpenSpeedSiteTest() {
        driver.get(BASE_URL);
    }

    @Test
    @DisplayName("Should open browser and click at 'mercadorias' button")
    public void ShouldOpenBrowserAndClickAtMercadoriasButtonTest() {
        driver.get(BASE_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe[src*='header.html']")));
        driver.switchTo().frame(iframe);

        WebElement mercadoriasButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href*='mercadorias/mercadorias.html']")));

        try {
            Thread.sleep(3000); // Pausa de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mercadoriasButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().defaultContent();
    }










    @Test
    public void testInserirMercadoria() {
        // Localize os elementos do formulário e preencha-os
        WebElement codigo = driver.findElement(By.name("codigo"));
        WebElement descricao = driver.findElement(By.name("descricao"));
        WebElement validade = driver.findElement(By.name("validade"));
        WebElement peso = driver.findElement(By.name("peso"));
        WebElement altura = driver.findElement(By.name("altura"));
        WebElement largura = driver.findElement(By.name("largura"));
        WebElement volume = driver.findElement(By.name("volume"));
        WebElement fragilidade = driver.findElement(By.name("fragilidade"));

        codigo.sendKeys("12345");
        descricao.sendKeys("Teste de mercadoria");
        validade.sendKeys("12/31/2024");
        peso.sendKeys("10");
        altura.sendKeys("20");
        largura.sendKeys("30");
        volume.sendKeys("6000");
        fragilidade.sendKeys("Frágil");

        WebElement inserirButton = driver.findElement(By.cssSelector("button[type='submit']"));
        inserirButton.click();

        // Verifique o resultado esperado (depende do comportamento da sua aplicação)
        WebElement resultado = driver.findElement(By.id("resultado"));
        assertEquals("Mercadoria inserida com sucesso!", resultado.getText());
    }
}