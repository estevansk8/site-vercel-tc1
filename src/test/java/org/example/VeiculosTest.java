package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class VeiculosTest {
    private WebDriver driver;
    private VeiculosPage veiculosPage;
    protected WebDriverWait wait;

    @BeforeEach
    public void setup() {
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("https://site-vercel-tc1.vercel.app/veiculos/veiculos.html");

        veiculosPage = new VeiculosPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Should insert new vehicle and get success alert")
    public void shouldInsertNewVehicle() {
        veiculosPage.insertVehicleData();
        veiculosPage.clickInsert();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String textAlert = alert.getText();
        alert.accept();

        assertEquals("Cadastrado com sucesso!", textAlert);
    }
}
