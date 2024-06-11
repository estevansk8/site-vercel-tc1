package org.example;

import org.openqa.selenium.WebDriver;

import java.util.Random;

public class VeiculosPage extends Base{

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
    int year = anoInicio + random.nextInt(anoFim - anoInicio + 1);
    String color = faker.color().name();
    String speed = faker.bothify("###");


}
