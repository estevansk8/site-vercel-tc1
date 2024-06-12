package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransportePage {
    WebDriver driver;

    public TransportePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPlateDropdown() {
        return driver.findElement(By.id("iptPlaca"));
    }

    public WebElement getCodeDropdown() {
        return driver.findElement(By.id("iptCodigo"));
    }

    public WebElement getStartDateField() {
        return driver.findElement(By.id("iptDataInicio"));
    }

    public WebElement getEndDateField() {
        return driver.findElement(By.id("iptDataTermino"));
    }

    public WebElement getStartCityField() {
        return driver.findElement(By.id("iptCidadeInicio"));
    }

    public WebElement getEndCityField() {
        return driver.findElement(By.id("iptCidadeTermino"));
    }

    public WebElement getKilometersField() {
        return driver.findElement(By.id("iptQuilometros"));
    }

    public WebElement getInsertButton() {
        return driver.findElement(By.id("inserirTransporte"));
    }

    public WebElement getTransportDropdown() {
        return driver.findElement(By.id("iptTransporteAlterar"));
    }

    public WebElement getPlateField() {
        return driver.findElement(By.id("iptPlacaAlterar"));
    }

    public WebElement getCityField() {
        return driver.findElement(By.id("iptCidadeAlterar"));
    }

    public WebElement getStateField() {
        return driver.findElement(By.id("iptEstadoAlterar"));
    }

    public WebElement getCodeField() {
        return driver.findElement(By.id("iptCodigoAlterar"));
    }

    public WebElement getEndDateFieldAlterar() {
        return driver.findElement(By.id("iptDataTerminoAlterar"));
    }

    public WebElement getStartCityFieldAlterar() {
        return driver.findElement(By.id("iptCidadeInicioAlterar"));
    }

    public WebElement getEndCityFieldAlterar() {
        return driver.findElement(By.id("iptCidadeTerminoAlterar"));
    }

    public WebElement getKilometersFieldAlterar() {
        return driver.findElement(By.id("iptQuilometrosAlterar"));
    }

    public WebElement getUpdateButton() {
        return driver.findElement(By.id("alterarTransporte"));
    }
    public WebElement getDeleteButton() {
        return driver.findElement(By.id("excluirTransporte"));
    }
    public WebElement getDeleteTransportDropdown() {
        return driver.findElement(By.id("iptTransporte"));
    }
}
