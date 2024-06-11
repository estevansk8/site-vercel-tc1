package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TransportePage {
    private final WebDriver driver;

    public TransportePage(WebDriver driver) {
        this.driver = driver;
    }

    public Select getVehicleDropdown() {
        return new Select(driver.findElement(By.id("iptPlaca")));
    }

    public Select getMerchandiseDropdown() {
        return new Select(driver.findElement(By.id("iptCodigo")));
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
}
