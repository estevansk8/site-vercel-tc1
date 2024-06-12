package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MercadoriasPage;
import pages.VeiculosPage;
import pages.TransportePage;

import java.time.Duration;
import java.util.List;

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
    @DisplayName("Should add and then update a transport")
    void shouldAddAndUpdateTransport() throws InterruptedException {
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

        headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/iframe[1]")));
        driver.switchTo().frame(headerIframe);

        link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/button[3]/a")));
        link.click();
        driver.switchTo().defaultContent();

        WebElement sidebarIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='barralateral.html']")));
        driver.switchTo().frame(sidebarIframe);

        WebElement alterarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Alterar')]")));
        alterarLink.click();
        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.urlToBe("https://site-vercel-tc1.vercel.app/transporte/alterar.html"));

        transportePage = new TransportePage(driver);

        Select transportDropdown = new Select(transportePage.getTransportDropdown());
        transportDropdown.selectByIndex(1);

        WebElement endDateField = transportePage.getEndDateFieldAlterar();
        endDateField.clear();
        endDateField.sendKeys("2024-06-15");

        WebElement startCityField = transportePage.getStartCityFieldAlterar();
        startCityField.clear();
        startCityField.sendKeys("New Start City");

        WebElement endCityField = transportePage.getEndCityFieldAlterar();
        endCityField.clear();
        endCityField.sendKeys("New End City");

        WebElement kilometersField = transportePage.getKilometersFieldAlterar();
        kilometersField.clear();
        kilometersField.sendKeys("500");

        WebElement updateButton = transportePage.getUpdateButton();
        updateButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alertText = alert.getText();
        expectedText = "Alterado com sucesso!";
        assertThat(alertText).isEqualTo(expectedText);
        alert.accept();
    }
    @Test
    @DisplayName("Should delete a transport")
    void shouldDeleteTransport() throws InterruptedException {
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
        String vehiclePlate = "aaa";
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

        String startDate = "2024-05-28";
        transportePage.getStartDateField().sendKeys("28052024");
        transportePage.getEndDateField().sendKeys("10062024");
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

        headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/iframe[1]")));
        driver.switchTo().frame(headerIframe);

        link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/button[3]/a")));
        link.click();
        driver.switchTo().defaultContent();

        WebElement sidebarIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='barralateral.html']")));
        driver.switchTo().frame(sidebarIframe);

        WebElement excluirLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Excluir')]")));
        excluirLink.click();
        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.urlToBe("https://site-vercel-tc1.vercel.app/transporte/excluir.html"));

        transportePage = new TransportePage(driver);

        Select transportDropdown = new Select(transportePage.getDeleteTransportDropdown());
        String transportIdentifier = vehiclePlate + " - " + merchandiseCode + " - " + startDate;
        transportDropdown.selectByVisibleText(transportIdentifier);

        WebElement deleteButton = transportePage.getDeleteButton();
        deleteButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alertText = alert.getText();
        expectedText = "Excluído com sucesso!";
        assertThat(alertText).isEqualTo(expectedText);
        alert.accept();
    }
    @Test
    @DisplayName("Should list all transports")
    void shouldListAllTransports() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/iframe[1]")));
        driver.switchTo().frame(headerIframe);

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/button[1]/a")));
        link.click();
        driver.switchTo().defaultContent();

        MercadoriasPage mercadoriasPage = new MercadoriasPage(driver);
        String merchandiseCode1 = faker.number().digits(6);
        mercadoriasPage.getCodeField().sendKeys(merchandiseCode1);
        mercadoriasPage.getDescriptionField().sendKeys(faker.commerce().productName());
        mercadoriasPage.getExpirationDateField().sendKeys("2023-12-31");
        mercadoriasPage.getWeightField().sendKeys("10");
        mercadoriasPage.getHeightField().sendKeys("100");
        mercadoriasPage.getWidthField().sendKeys("50");
        mercadoriasPage.getVolumeField().sendKeys("5000");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fragilidade")));
        WebElement fragilityDropdown = driver.findElement(By.id("fragilidade"));
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
        String vehiclePlate1 = "aaa";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptPlaca"))).sendKeys(vehiclePlate1);
        veiculosPage.getCityField().sendKeys(faker.address().city());
        veiculosPage.getStateField().sendKeys(faker.address().state());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptTipo")));
        WebElement typeDropdown = driver.findElement(By.id("iptTipo"));
        Select selectType = new Select(typeDropdown);
        selectType.selectByVisibleText("Urbano");

        veiculosPage.getBrandField().sendKeys(faker.company().name());
        veiculosPage.getModelField().sendKeys(faker.aviation().aircraft());
        veiculosPage.getYearField().sendKeys(faker.number().digits(4));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptCombustiveis")));
        WebElement fuelDropdown = driver.findElement(By.id("iptCombustiveis"));
        Select selectFuel = new Select(fuelDropdown);
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
        plateDropdown.selectByVisibleText(vehiclePlate1);

        Select codeDropdown = new Select(transportePage.getCodeDropdown());
        codeDropdown.selectByVisibleText(merchandiseCode1);

        String startDate1 = "2024-05-28";
        transportePage.getStartDateField().sendKeys("28052024");
        transportePage.getEndDateField().sendKeys("10062024");
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

        headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/iframe[1]")));
        driver.switchTo().frame(headerIframe);

        link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/button[1]/a")));
        link.click();
        driver.switchTo().defaultContent();

        String merchandiseCode2 = faker.number().digits(6);
        mercadoriasPage.getCodeField().sendKeys(merchandiseCode2);
        mercadoriasPage.getDescriptionField().sendKeys(faker.commerce().productName());
        mercadoriasPage.getExpirationDateField().sendKeys("2023-12-31");
        mercadoriasPage.getWeightField().sendKeys("10");
        mercadoriasPage.getHeightField().sendKeys("100");
        mercadoriasPage.getWidthField().sendKeys("50");
        mercadoriasPage.getVolumeField().sendKeys("5000");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fragilidade")));
        fragilityDropdown = driver.findElement(By.id("fragilidade"));
        selectFragility = new Select(fragilityDropdown);
        selectFragility.selectByVisibleText("Fragíl");

        insertButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='envolucro']/div[2]/button")));
        insertButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alertText = alert.getText();
        expectedText = "Cadastrado com sucesso!";
        assertThat(alertText).isEqualTo(expectedText);
        alert.accept();

        headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/iframe[1]")));
        driver.switchTo().frame(headerIframe);

        link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/button[2]/a")));
        link.click();
        driver.switchTo().defaultContent();

        String vehiclePlate2 = "bbb";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptPlaca"))).sendKeys(vehiclePlate2);
        veiculosPage.getCityField().sendKeys(faker.address().city());
        veiculosPage.getStateField().sendKeys(faker.address().state());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptTipo")));
        typeDropdown = driver.findElement(By.id("iptTipo"));
        selectType = new Select(typeDropdown);
        selectType.selectByVisibleText("Urbano");

        veiculosPage.getBrandField().sendKeys(faker.company().name());
        veiculosPage.getModelField().sendKeys(faker.aviation().aircraft());
        veiculosPage.getYearField().sendKeys(faker.number().digits(4));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptCombustiveis")));
        fuelDropdown = driver.findElement(By.id("iptCombustiveis"));
        selectFuel = new Select(fuelDropdown);
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

        plateDropdown = new Select(transportePage.getPlateDropdown());
        plateDropdown.selectByVisibleText(vehiclePlate2);

        codeDropdown = new Select(transportePage.getCodeDropdown());
        codeDropdown.selectByVisibleText(merchandiseCode2);

        String startDate2 = "2024-05-29";
        transportePage.getStartDateField().sendKeys("29052024");
        transportePage.getEndDateField().sendKeys("11062024");
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

        headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/iframe[1]")));
        driver.switchTo().frame(headerIframe);

        link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/button[3]/a")));
        link.click();
        driver.switchTo().defaultContent();

        WebElement sidebarIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='barralateral.html']")));
        driver.switchTo().frame(sidebarIframe);

        WebElement listarTodosLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Listar Todos')]")));
        listarTodosLink.click();
        driver.switchTo().defaultContent();

        WebElement pesquisarButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("pesquisarTodos")));
        pesquisarButton.click();

        List<WebElement> transportCards = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='conteudoListagem']/div[contains(@class, 'card')]")));
        assertThat(transportCards).hasSize(2);
    }
    @Test
    @DisplayName("Should list one transport")
    void shouldListOneTransport() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/iframe[1]")));
        driver.switchTo().frame(headerIframe);

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/button[1]/a")));
        link.click();
        driver.switchTo().defaultContent();

        MercadoriasPage mercadoriasPage = new MercadoriasPage(driver);
        String merchandiseCode1 = faker.number().digits(6);
        mercadoriasPage.getCodeField().sendKeys(merchandiseCode1);
        mercadoriasPage.getDescriptionField().sendKeys(faker.commerce().productName());
        mercadoriasPage.getExpirationDateField().sendKeys("2023-12-31");
        mercadoriasPage.getWeightField().sendKeys("10");
        mercadoriasPage.getHeightField().sendKeys("100");
        mercadoriasPage.getWidthField().sendKeys("50");
        mercadoriasPage.getVolumeField().sendKeys("5000");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fragilidade")));
        WebElement fragilityDropdown = driver.findElement(By.id("fragilidade"));
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
        String vehiclePlate1 = "aaa";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptPlaca"))).sendKeys(vehiclePlate1);
        veiculosPage.getCityField().sendKeys(faker.address().city());
        veiculosPage.getStateField().sendKeys(faker.address().state());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptTipo")));
        WebElement typeDropdown = driver.findElement(By.id("iptTipo"));
        Select selectType = new Select(typeDropdown);
        selectType.selectByVisibleText("Urbano");

        veiculosPage.getBrandField().sendKeys(faker.company().name());
        veiculosPage.getModelField().sendKeys(faker.aviation().aircraft());
        veiculosPage.getYearField().sendKeys(faker.number().digits(4));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptCombustiveis")));
        WebElement fuelDropdown = driver.findElement(By.id("iptCombustiveis"));
        Select selectFuel = new Select(fuelDropdown);
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
        plateDropdown.selectByVisibleText(vehiclePlate1);

        Select codeDropdown = new Select(transportePage.getCodeDropdown());
        codeDropdown.selectByVisibleText(merchandiseCode1);

        String startDate1 = "2024-05-28";
        transportePage.getStartDateField().sendKeys("28052024");
        transportePage.getEndDateField().sendKeys("10062024");
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

        headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/iframe[1]")));
        driver.switchTo().frame(headerIframe);

        link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/button[3]/a")));
        link.click();
        driver.switchTo().defaultContent();

        WebElement sidebarIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='barralateral.html']")));
        driver.switchTo().frame(sidebarIframe);

        WebElement listarUmLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Listar Um')]")));
        listarUmLink.click();
        driver.switchTo().defaultContent();

        Select listarUmDropdown = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptTransporteListarUm"))));
        listarUmDropdown.selectByVisibleText(vehiclePlate1 + " - " + merchandiseCode1 + " - " + startDate1);

        WebElement transportCard = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='conteudoListagemAlterar']/div[@class='card']")));
        assertThat(transportCard.getText()).contains("Placa: " + vehiclePlate1 + " - Código: " + merchandiseCode1);
    }
    @Test
    @DisplayName("Should detect error when registering transport with empty plate field")
    void shouldDetectErrorWithEmptyPlateField() throws InterruptedException {
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

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fragilidade")));
        WebElement fragilityDropdown = driver.findElement(By.id("fragilidade"));
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptPlaca"))).sendKeys("");
        veiculosPage.getCityField().sendKeys(faker.address().city());
        veiculosPage.getStateField().sendKeys(faker.address().state());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptTipo")));
        WebElement typeDropdown = driver.findElement(By.id("iptTipo"));
        Select selectType = new Select(typeDropdown);
        selectType.selectByVisibleText("Urbano");

        veiculosPage.getBrandField().sendKeys(faker.company().name());
        veiculosPage.getModelField().sendKeys(faker.aviation().aircraft());
        veiculosPage.getYearField().sendKeys(faker.number().digits(4));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptCombustiveis")));
        WebElement fuelDropdown = driver.findElement(By.id("iptCombustiveis"));
        Select selectFuel = new Select(fuelDropdown);
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
        plateDropdown.selectByVisibleText("");

        Select codeDropdown = new Select(transportePage.getCodeDropdown());
        codeDropdown.selectByVisibleText(merchandiseCode);

        transportePage.getStartDateField().sendKeys("28052024");
        transportePage.getEndDateField().sendKeys("10062024");
        transportePage.getStartCityField().sendKeys(faker.address().city());
        transportePage.getEndCityField().sendKeys(faker.address().city());
        transportePage.getKilometersField().sendKeys(faker.number().digits(3));

        transportePage.getInsertButton().click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alertText = alert.getText();
        String expectedErrorMessage = "Placa não pode estar vazia!";
        assertThat(alertText).isEqualTo(expectedErrorMessage);
        alert.accept();
    }
    @Test
    @DisplayName("Should not allow transport with empty merchandise code")
    void shouldNotAllowTransportWithEmptyMerchandiseCode() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/iframe[1]")));
        driver.switchTo().frame(headerIframe);

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/button[2]/a")));
        link.click();
        driver.switchTo().defaultContent();

        VeiculosPage veiculosPage = new VeiculosPage(driver);
        String vehiclePlate = "ccc";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptPlaca"))).sendKeys(vehiclePlate);
        veiculosPage.getCityField().sendKeys(faker.address().city());
        veiculosPage.getStateField().sendKeys(faker.address().state());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptTipo")));
        WebElement typeDropdown = driver.findElement(By.id("iptTipo"));
        Select selectType = new Select(typeDropdown);
        selectType.selectByVisibleText("Urbano");

        veiculosPage.getBrandField().sendKeys(faker.company().name());
        veiculosPage.getModelField().sendKeys(faker.aviation().aircraft());
        veiculosPage.getYearField().sendKeys(faker.number().digits(4));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iptCombustiveis")));
        WebElement fuelDropdown = driver.findElement(By.id("iptCombustiveis"));
        Select selectFuel = new Select(fuelDropdown);
        selectFuel.selectByVisibleText("Gasolina");

        veiculosPage.getColorField().sendKeys(faker.color().name());
        veiculosPage.getMaxSpeedField().sendKeys(faker.number().digits(3));

        veiculosPage.getInsertButton().click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedText = "Cadastrado com sucesso!";
        assertThat(alertText).isEqualTo(expectedText);
        alert.accept();

        headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/iframe[1]")));
        driver.switchTo().frame(headerIframe);

        link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/button[1]/a")));
        link.click();
        driver.switchTo().defaultContent();

        MercadoriasPage mercadoriasPage = new MercadoriasPage(driver);
        mercadoriasPage.getCodeField().sendKeys("");
        mercadoriasPage.getDescriptionField().sendKeys(faker.commerce().productName());
        mercadoriasPage.getExpirationDateField().sendKeys("2023-12-31");
        mercadoriasPage.getWeightField().sendKeys("10");
        mercadoriasPage.getHeightField().sendKeys("100");
        mercadoriasPage.getWidthField().sendKeys("50");
        mercadoriasPage.getVolumeField().sendKeys("5000");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fragilidade")));
        WebElement fragilityDropdown = driver.findElement(By.id("fragilidade"));
        Select selectFragility = new Select(fragilityDropdown);
        selectFragility.selectByVisibleText("Fragíl");

        WebElement insertButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='envolucro']/div[2]/button")));
        insertButton.click();

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
        codeDropdown.selectByVisibleText("");

        String startDate = "2024-05-28";
        transportePage.getStartDateField().sendKeys("28052024");
        transportePage.getEndDateField().sendKeys("10062024");
        transportePage.getStartCityField().sendKeys(faker.address().city());
        transportePage.getEndCityField().sendKeys(faker.address().city());
        transportePage.getKilometersField().sendKeys(faker.number().digits(3));

        transportePage.getInsertButton().click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alertText = alert.getText();
        String expectedErrorMessage = "Código da mercadoria não pode estar vazio!";
        assertThat(alertText).isEqualTo(expectedErrorMessage);
        alert.accept();
    }
}
