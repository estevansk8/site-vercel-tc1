package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class VeiculosPage extends Base {

    public VeiculosPage(WebDriver driver) {
        super(driver);
    }

    Random random = new Random();
    int anoInicio = 1900;
    int anoFim = 2024;

    String plate = faker.bothify("???-####");
    String city = faker.address().city();
    String state = faker.address().state();
    String make = faker.lorem().word();
    String model = faker.lorem().word();
    int yearInt = anoInicio + random.nextInt(anoFim - anoInicio + 1);
    String year = String.valueOf(yearInt);
    String color = faker.color().name();
    String speed = faker.bothify("###");

    private final By veiculosButtonXPath = By.xpath("//button[contains(text(),'Veiculos')]");
    private final By sideBariFrame = By.xpath("//*[@id=\"barralateral\"]/iframe");
    private final By listXPath = By.xpath("/html/body/ul/li[4]/a");
    private final By searchXPath = By.xpath("//*[@id=\"envolucro\"]/div[2]/button");
    private final By deleteXPath = By.xpath("/html/body/ul/li[3]/a");
    private final By deleteItemXPath = By.xpath("//*[@id=\"envolucro\"]/div[2]/button");
    private final By plateXPath = By.xpath("//input[@id='iptPlaca']");
    private final By cityXPath = By.xpath("//input[@id='iptCidade']");
    private final By stateXPath = By.xpath("//input[@id='iptEstado']");
    private final By typeXPath = By.xpath("//select[@id='iptTipo']");
    private final By makeXPath = By.xpath("//input[@id='iptMarca']");
    private final By modelXPath = By.xpath("//input[@id='iptModelo']");
    private final By yearXPath = By.xpath("//input[@id='iptAno']");
    private final By fuelXPath = By.xpath("//select[@id='iptCombustiveis']");
    private final By colorXPath = By.xpath("//input[@id='iptCor']");
    private final By speedXPath = By.xpath("//input[@id='iptVelocidade_maxima']");
    private final By insertXPath = By.xpath("//button[contains(text(),'Inserir')]");

    public void goToVehicle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(veiculosButtonXPath));
        driver.findElement(veiculosButtonXPath).click();
    }

    public void insertVehicleData() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(plateXPath));
        driver.findElement(plateXPath).sendKeys(plate);
        driver.findElement(cityXPath).sendKeys(city);
        driver.findElement(stateXPath).sendKeys(state);
        driver.findElement(makeXPath).sendKeys(make);
        driver.findElement(modelXPath).sendKeys(model);
        driver.findElement(yearXPath).sendKeys(year);
        driver.findElement(colorXPath).sendKeys(color);
        driver.findElement(speedXPath).sendKeys(speed);
    }

    public void insertVehicleDataKnowingPlate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(plateXPath));
        driver.findElement(plateXPath).sendKeys("EWQ9640");
        driver.findElement(cityXPath).sendKeys(city);
        driver.findElement(stateXPath).sendKeys(state);
        driver.findElement(makeXPath).sendKeys(make);
        driver.findElement(modelXPath).sendKeys(model);
        driver.findElement(yearXPath).sendKeys(year);
        driver.findElement(colorXPath).sendKeys(color);
        driver.findElement(speedXPath).sendKeys(speed);
    }

    public void clickInsert() {
        driver.findElement(insertXPath).click();
    }

    public void clickList(){
        driver.findElement(listXPath).click();
    }

    public void clickSearch(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchXPath));
        driver.findElement(searchXPath).click();
    }

    public void clickDelete(){
        driver.findElement(deleteXPath).click();
    }

    public void clickDeleteItem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteItemXPath));
        driver.findElement(deleteItemXPath).click();
    }
}
