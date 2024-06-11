package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getTransportLink() {
        return getLinkInHeader(By.xpath("//a[@href='transporte/transporte.html']"));
    }

    public WebElement getVehicleLink() {
        return getLinkInHeader(By.xpath("//a[@href='veiculos/veiculos.html']"));
    }

    public WebElement getMerchandiseLink() {
        return getLinkInHeader(By.xpath("//a[@href='mercadorias/mercadorias.html']"));
    }

    public WebElement getInsertMerchandiseLink() {
        return getLinkInHeader(By.xpath("//a[@href='mercadorias/mercadorias.html']"));
    }

    public WebElement getUpdateMerchandiseLink() {
        return getLinkInHeader(By.xpath("//a[@href='mercadorias/alterar.html']"));
    }

    public WebElement getDeleteMerchandiseLink() {
        return getLinkInHeader(By.xpath("//a[@href='mercadorias/excluir.html']"));
    }

    public WebElement getListAllMerchandiseLink() {
        return getLinkInHeader(By.xpath("//a[@href='mercadorias/listartodos.html']"));
    }

    public WebElement getListOneMerchandiseLink() {
        return getLinkInHeader(By.xpath("//a[@href='mercadorias/listarum.html']"));
    }

    private WebElement getLinkInHeader(By by) {
        WebElement headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='header.html']")));
        driver.switchTo().frame(headerIframe);

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.switchTo().defaultContent();

        return link;
    }
}
