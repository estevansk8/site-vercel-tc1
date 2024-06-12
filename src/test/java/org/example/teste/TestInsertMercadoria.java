package org.example.teste;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.MercadoriaPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.Locale;

import org.example.utils.TestDataGenerator;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInsertMercadoria {

    String BASE_URL = "https://site-vercel-tc1.vercel.app/mercadorias/mercadorias.html";
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
        mercadoriaPage.navigateTo(BASE_URL);
        mercadoriaPage.fillForm("12345", "Teste de mercadoria", "2024-12-31", "invalidWeight", "20", "30", "6000", "Frágil");
        mercadoriaPage.submitForm();

        String alertText = mercadoriaPage.waitForAlertAndGetText();
        Assertions.assertEquals("Erro: Peso deve ser um valor numérico", alertText);
    }

    @Test
    @DisplayName("Should reject negative values in mercadoria form")
    public void shouldRejectNegativeValuesInMercadoriaForm() {
        mercadoriaPage.navigateTo(BASE_URL);

        String codigo = TestDataGenerator.generateCodigo();
        String descricao = faker.commerce().productName();
        String validade = "12/31/2024";
        String peso = String.valueOf(-faker.number().randomDouble(2, 1, 100)); // Valor negativo
        String altura = String.valueOf(-faker.number().numberBetween(1, 100)); // Valor negativo
        String largura = String.valueOf(-faker.number().numberBetween(1, 100)); // Valor negativo
        String volume = String.valueOf(-faker.number().numberBetween(1, 10000)); // Valor negativo
        String fragilidade = "Frágil";

        mercadoriaPage.fillForm(codigo, descricao, validade, peso, altura, largura, volume, fragilidade);
        try {
            Thread.sleep(2000); // Pausa de 2 segundos (2000 milissegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mercadoriaPage.submitForm();
        try {
            Thread.sleep(2000); // Pausa de 2 segundos (2000 milissegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String errorMessage = mercadoriaPage.getErrorMessage();

        assertTrue(errorMessage.contains("Valores negativos não são permitidos"), "Erro esperado ao submeter valores negativos");
    }

    @Test
    @DisplayName("Should reject blank code in mercadoria form")
    public void shouldRejectBlankCodeInMercadoriaForm() {
        mercadoriaPage.navigateTo(BASE_URL);

        String codigo = "";
        String descricao = faker.commerce().productName();
        String validade = "12/31/2024";
        String peso = String.valueOf(faker.number().randomDouble(2, 1, 100));
        String altura = String.valueOf(faker.number().numberBetween(1, 100));
        String largura = String.valueOf(faker.number().numberBetween(1, 100));
        String volume = String.valueOf(faker.number().numberBetween(1, 10000));
        String fragilidade = "Frágil";

        mercadoriaPage.fillForm(codigo, descricao, validade, peso, altura, largura, volume, fragilidade);
        mercadoriaPage.submitForm();
        try {
            Thread.sleep(2000); // Pausa de 2 segundos (2000 milissegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Verify if an error message is displayed
        String errorMessage = mercadoriaPage.getErrorMessage();

        assertTrue(errorMessage.contains("Code cannot be blank"), "Expected error when submitting form with blank code");
    }
}
