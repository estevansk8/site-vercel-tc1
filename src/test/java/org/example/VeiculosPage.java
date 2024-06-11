package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Random;

public class VeiculosPage extends Base{

    public VeiculosPage(SafariDriver driver) {
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
    int year = anoInicio + random.nextInt(anoFim - anoInicio + 1);
    String color = faker.color().name();
    String speed = faker.bothify("###");

    By plateXPath = By.xpath("//input[@id='iptPlaca']");
    By cityXPath = By.xpath("//input[@id='iptCidade']");
    By stateXPath = By.xpath("//input[@id='iptEstado']");
    By typeXPath = By.xpath("//select[@id='iptTipo']");
    By makeXPath = By.xpath("//input[@id='iptMarca']");
    By modelXPath = By.xpath("//input[@id='iptModelo']");
    By yearXPath = By.xpath("//input[@id='iptAno']");
    By fuelXPath = By.xpath("//select[@id='iptCombustiveis']");
    By colorXPath = By.xpath("//input[@id='iptCor']");
    By speedXPath = By.xpath("//input[@id='iptVelocidade_maxima']");
    By insertXPath = By.xpath("//button[contains(text(),'Inserir')]");



}
