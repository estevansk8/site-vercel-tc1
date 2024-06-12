package org.example.tests;

import org.example.pages.VeiculoPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class VeiculoTests extends TesteBase {

    @Test
    @DisplayName("Should add a new vehicle")
    void shouldAddNewVehicle() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://site-vercel-tc1.vercel.app/index.html");

        WebElement headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='header.html']")));
        driver.switchTo().frame(headerIframe);

        WebElement vehicleLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='veiculos/veiculos.html']")));
        vehicleLink.click();

        driver.switchTo().defaultContent();

        VeiculoPage veiculoPage = new VeiculoPage(driver);
        veiculoPage.getLicensePlateField().sendKeys(faker.letterify("??????"));
        veiculoPage.getCityField().sendKeys(faker.address().city());
        veiculoPage.getStateField().sendKeys(faker.address().state());

        Select selectType = new Select(veiculoPage.getTypeDropdown());
        selectType.selectByVisibleText("Urbano");

        veiculoPage.getBrandField().sendKeys(faker.company().name());
        veiculoPage.getModelField().sendKeys(faker.aviation().aircraft());
        veiculoPage.getYearField().sendKeys(faker.number().digits(4));

        Select selectFuel = new Select(veiculoPage.getFuelDropdown());
        selectFuel.selectByVisibleText("Gasolina");

        veiculoPage.getColorField().sendKeys(faker.color().name());
        veiculoPage.getMaxSpeedField().sendKeys(faker.number().digits(3));

        veiculoPage.getInsertButton().click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedText = "Cadastrado com sucesso!";
        assertThat(alertText).isEqualTo(expectedText);
        alert.accept();
    }

}
