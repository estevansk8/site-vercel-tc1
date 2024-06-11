package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTransportLink() {
        return driver.findElement(By.xpath("//a[@href='transporte/transporte.html']"));
    }

    public WebElement getVehicleLink() {
        return driver.findElement(By.xpath("//a[@href='veiculos/veiculos.html']"));
    }

    public WebElement getMerchandiseLink() {
        return driver.findElement(By.xpath("//a[@href='mercadorias/mercadorias.html']"));
    }

    public WebElement getInsertMerchandiseLink() {
        return driver.findElement(By.xpath("//a[@href='mercadorias/mercadorias.html']"));
    }

    public WebElement getUpdateMerchandiseLink() {
        return driver.findElement(By.xpath("//a[@href='mercadorias/alterar.html']"));
    }

    public WebElement getDeleteMerchandiseLink() {
        return driver.findElement(By.xpath("//a[@href='mercadorias/excluir.html']"));
    }

    public WebElement getListAllMerchandiseLink() {
        return driver.findElement(By.xpath("//a[@href='mercadorias/listartodos.html']"));
    }

    public WebElement getListOneMerchandiseLink() {
        return driver.findElement(By.xpath("//a[@href='mercadorias/listarum.html']"));
    }
}
