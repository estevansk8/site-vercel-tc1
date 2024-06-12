package org.example.teste;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.MercadoriaPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        driver = new FirefoxDriver();
        mercadoriaPage = new MercadoriaPage(driver);
        driver.get(BASE_URL);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


    @Test
    public void testInserirMercadoria() {
        mercadoriaPage.navigateTo(BASE_URL);
        mercadoriaPage.setCodigo("12345");
        mercadoriaPage.setDescricao("Teste de mercadoria");
        mercadoriaPage.setDate("2024-12-31");
        mercadoriaPage.setPeso("10");
        mercadoriaPage.setAltura("20");
        mercadoriaPage.setLargura("30");
        mercadoriaPage.setVolume("6000");
        mercadoriaPage.setFragilidade("Frágil");

        mercadoriaPage.submitForm();

        String resultado = mercadoriaPage.getResultadoText();
        assertEquals("Mercadoria inserida com sucesso!", resultado);
    }

    @Test
    @DisplayName("Should not accept non-numeric values in peso field")
    public void shouldNotAcceptNonNumericValuesInPesoField() {
        mercadoriaPage.navigateTo(BASE_URL);
        mercadoriaPage.clickMercadoriasButton();
        mercadoriaPage.setPeso("abc");

        // Tentar submeter o formulário e verificar a mensagem de erro esperada
        mercadoriaPage.submitForm();

        String resultado = mercadoriaPage.getResultadoText();
        assertTrue(resultado.contains("Erro: Peso deve ser um valor numérico"));
    }
}
