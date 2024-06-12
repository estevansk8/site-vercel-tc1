package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @Test
    @DisplayName("Should show error message informing the plate already exists")
    public void shouldFailBecauseOfExistingPlate(){
        veiculosPage.insertVehicleDataKnowingPlate();
        veiculosPage.clickInsert();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.switchTo().defaultContent();
        final By plateXPath = By.xpath("//input[@id='iptPlaca']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(plateXPath));
        veiculosPage.insertVehicleDataKnowingPlate();
        veiculosPage.clickInsert();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert2 = driver.switchTo().alert();
        String textAlert = alert2.getText();
        System.out.println(textAlert);
        alert2.accept();

        assertEquals("Placa já cadastrada!", textAlert);
    }

    @Test
    @DisplayName("Should go to List All page and list vehicles")
    public void shouldListVehicles() throws InterruptedException {
        veiculosPage.insertVehicleData();
        veiculosPage.clickInsert();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement sidebar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='barralateral.html']")));
        driver.switchTo().frame(sidebar);
        veiculosPage.clickList();
        driver.switchTo().defaultContent();
        veiculosPage.clickSearch();

        final By listedVehiclesHeader = By.xpath("//*[@id='conteudoListagem']/div[1]/div[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(listedVehiclesHeader));
        assertTrue(driver.findElement(listedVehiclesHeader).isDisplayed(), "Listed vehicles header should be displayed after search");
    }

    @Test
    @DisplayName("Should delete vehicle and show success message")
    public void shoulDeleteAndShowSuccessAlert() throws InterruptedException {
        veiculosPage.insertVehicleDataKnowingPlate();
        veiculosPage.clickInsert();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        assertEquals("Cadastrado com sucesso!", alert.getText());
        alert.accept();

        WebElement sidebar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='barralateral.html']")));
        driver.switchTo().frame(sidebar);
        WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ul/li[3]/a")));
        delete.click();

        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.urlContains("excluir.html"));
        final By deletePlateInput = By.xpath("//*[@id=\"iptPlacaExcluir\"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(deletePlateInput));
        driver.findElement(deletePlateInput).sendKeys("EWQ9640");
        veiculosPage.clickDeleteItem();

        Alert deleteAlert = driver.switchTo().alert();
        String text = alert.getText();
        assertEquals("Placa excluída!", text);
    }
}
