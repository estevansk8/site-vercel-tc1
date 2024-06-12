package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VeiculoPage {
    private final WebDriver driver;

    public VeiculoPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLicensePlateField() {
        return driver.findElement(By.id("iptPlaca"));
    }

    public WebElement getCityField() {
        return driver.findElement(By.id("iptCidade"));
    }

    public WebElement getStateField() {
        return driver.findElement(By.id("iptEstado"));
    }

    public WebElement getTypeDropdown() {
        return driver.findElement(By.id("iptTipo"));
    }

    public WebElement getBrandField() {
        return driver.findElement(By.id("iptMarca"));
    }

    public WebElement getModelField() {
        return driver.findElement(By.id("iptModelo"));
    }

    public WebElement getYearField() {
        return driver.findElement(By.id("iptAno"));
    }

    public WebElement getFuelDropdown() {
        return driver.findElement(By.id("iptCombustiveis"));
    }

    public WebElement getColorField() {
        return driver.findElement(By.id("iptCor"));
    }

    public WebElement getMaxSpeedField() {
        return driver.findElement(By.id("iptVelocidade_maxima"));
    }

    public WebElement getInsertButton() {
        return driver.findElement(By.xpath("//button[@onclick='btnInserir()']"));
    }
}
