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
        // Especifique o caminho para o ChromeDriver se necessário
        System.setProperty("webdriver.chrome.driver", "/caminho/para/chromedriver");
        driver = new ChromeDriver();
        driver.get("file:///caminho/para/seu/arquivo/image.png"); // Caminho para o arquivo HTML local
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
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

