package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MercadoriasPage {
    private final WebDriver driver;

    public MercadoriasPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCodeField() {
        return driver.findElement(By.id("iptCodigo"));
    }

    public WebElement getDescriptionField() {
        return driver.findElement(By.id("iptDescricao"));
    }

    public WebElement getExpirationDateField() {
        return driver.findElement(By.id("iptDataValidade"));
    }

    public WebElement getWeightField() {
        return driver.findElement(By.id("iptPeso"));
    }

    public WebElement getHeightField() {
        return driver.findElement(By.id("iptAltura"));
    }

    public WebElement getWidthField() {
        return driver.findElement(By.id("iptLargura"));
    }

    public WebElement getVolumeField() {
        return driver.findElement(By.id("iptVolume"));
    }

    public Select getFragilityDropdown() {
        return new Select(driver.findElement(By.id("fragilidade")));
    }

    public WebElement getInsertButton() {
        return driver.findElement(By.xpath("//button[text()='Inserir']"));
    }

    public WebElement getUpdateLink() {
        return driver.findElement(By.xpath("//a[@href='alterar.html']"));
    }

    public WebElement getDeleteLink() {
        return driver.findElement(By.xpath("//a[@href='excluir.html']"));
    }

    public WebElement getListAllLink() {
        return driver.findElement(By.xpath("//a[@href='listartodos.html']"));
    }

    public WebElement getListOneLink() {
        return driver.findElement(By.xpath("//a[@href='listarum.html']"));
    }
}
