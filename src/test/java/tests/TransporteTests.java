package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MercadoriasPage;
import pages.VeiculosPage;
import pages.TransportePage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class TransporteTests extends TesteBase {

    @Test
    @DisplayName("Should add a new transport")
    void shouldAddNewTransport() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/iframe[1]")));
        driver.switchTo().frame(headerIframe);

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/button[1]/a")));
        link.click();
        driver.switchTo().defaultContent();

        MercadoriasPage mercadoriasPage = new MercadoriasPage(driver);
        String merchandiseCode = faker.number().digits(6);
        mercadoriasPage.getCodeField().sendKeys(merchandiseCode);
        mercadoriasPage.getDescriptionField().sendKeys(faker.commerce().productName());
        mercadoriasPage.getExpirationDateField().sendKeys("2023-12-31");
        mercadoriasPage.getWeightField().sendKeys("10");
        mercadoriasPage.getHeightField().sendKeys("100");
        mercadoriasPage.getWidthField().sendKeys("50");
        mercadoriasPage.getVolumeField().sendKeys("5000");

        WebElement fragilityDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fragilidade")));
        Select selectFragility = new Select(fragilityDropdown);
        selectFragility.selectByVisibleText("Fragíl");

        WebElement insertButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='envolucro']/div[2]/button")));
        insertButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedText = "Cadastrado com sucesso!";
        assertThat(alertText).isEqualTo(expectedText);
        alert.accept();

        headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/iframe[1]")));
        driver.switchTo().frame(headerIframe);

        link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/button[2]/a")));
        link.click();
        driver.switchTo().defaultContent();

        VeiculosPage veiculosPage = new VeiculosPage(driver);
        String vehiclePlate = faker.letterify("??????");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptPlaca"))).sendKeys(vehiclePlate);
        veiculosPage.getCityField().sendKeys(faker.address().city());
        veiculosPage.getStateField().sendKeys(faker.address().state());

        Select selectType = new Select(veiculosPage.getTypeDropdown());
        selectType.selectByVisibleText("Urbano");

        veiculosPage.getBrandField().sendKeys(faker.company().name());
        veiculosPage.getModelField().sendKeys(faker.aviation().aircraft());
        veiculosPage.getYearField().sendKeys(faker.number().digits(4));

        Select selectFuel = new Select(veiculosPage.getFuelDropdown());
        selectFuel.selectByVisibleText("Gasolina");

        veiculosPage.getColorField().sendKeys(faker.color().name());
        veiculosPage.getMaxSpeedField().sendKeys(faker.number().digits(3));

        veiculosPage.getInsertButton().click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alertText = alert.getText();
        expectedText = "Cadastrado com sucesso!";
        assertThat(alertText).isEqualTo(expectedText);
        alert.accept();

        headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/iframe[1]")));
        driver.switchTo().frame(headerIframe);

        link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/button[3]/a")));
        link.click();
        driver.switchTo().defaultContent();

        TransportePage transportePage = new TransportePage(driver);
        Select plateDropdown = new Select(transportePage.getPlateDropdown());
        plateDropdown.selectByVisibleText(vehiclePlate);

        Select codeDropdown = new Select(transportePage.getCodeDropdown());
        codeDropdown.selectByVisibleText(merchandiseCode);

        transportePage.getStartDateField().sendKeys("2024-06-01");
        transportePage.getEndDateField().sendKeys("2024-06-10");
        transportePage.getStartCityField().sendKeys(faker.address().city());
        transportePage.getEndCityField().sendKeys(faker.address().city());
        transportePage.getKilometersField().sendKeys(faker.number().digits(3));

        transportePage.getInsertButton().click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alertText = alert.getText();
        expectedText = "Transporte Inserido com sucesso!";
        assertThat(alertText).isEqualTo(expectedText);
        alert.accept();
    }
    @Test
    @DisplayName("Should update an existing transport")
    void shouldUpdateExistingTransport() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/iframe[1]")));
        driver.switchTo().frame(headerIframe);

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/button[3]/a")));
        link.click();
        driver.switchTo().defaultContent();

        TransportePage transportePage = new TransportePage(driver);

        Select transportDropdown = new Select(transportePage.getTransportDropdown());
        transportDropdown.selectByIndex(0);

        String newStartDate = "2024-07-01";
        String newEndDate = "2024-07-10";
        String newStartCity = faker.address().city();
        String newEndCity = faker.address().city();
        String newKilometers = faker.number().digits(3);

        transportePage.getStartDateField().clear();
        transportePage.getStartDateField().sendKeys(newStartDate);
        transportePage.getEndDateField().clear();
        transportePage.getEndDateField().sendKeys(newEndDate);
        transportePage.getStartCityField().clear();
        transportePage.getStartCityField().sendKeys(newStartCity);
        transportePage.getEndCityField().clear();
        transportePage.getEndCityField().sendKeys(newEndCity);
        transportePage.getKilometersField().clear();
        transportePage.getKilometersField().sendKeys(newKilometers);

        WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("updateTransport")));
        updateButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedText = "Transporte atualizado com sucesso!";
        assertThat(alertText).isEqualTo(expectedText);
        alert.accept();

        transportDropdown = new Select(transportePage.getTransportDropdown());
        transportDropdown.selectByIndex(0); // Seleciona novamente o primeiro transporte

        assertThat(transportePage.getStartDateField().getAttribute("value")).isEqualTo(newStartDate);
        assertThat(transportePage.getEndDateField().getAttribute("value")).isEqualTo(newEndDate);
        assertThat(transportePage.getStartCityField().getAttribute("value")).isEqualTo(newStartCity);
        assertThat(transportePage.getEndCityField().getAttribute("value")).isEqualTo(newEndCity);
        assertThat(transportePage.getKilometersField().getAttribute("value")).isEqualTo(newKilometers);
    }

}
