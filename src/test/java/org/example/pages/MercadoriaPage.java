package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class MercadoriaPage extends BasePage {

    private By mercadoriasButton = By.cssSelector("a[href*='mercadorias/mercadorias.html']");
    private By descricaoInput = By.name("Descrição");
    private By dateInput = By.name("dValidade");
    private By pesoInput = By.name("peso");
    private By codigoInput = By.name("codigo");
    private By alturaInput = By.name("Altura");
    private By larguraInput = By.name("Largura");
    private By volumeInput = By.name("Volume");
    private By fragilidadeInput = By.name("fragilidade");
    private By submitButton = By.className("action");
    private By resultadoText = By.id("resultado");


    public MercadoriaPage(WebDriver driver) {
        super(driver);
    }

    public void clickMercadoriasButton() {
        waitForElement(mercadoriasButton);
        WebElement button = driver.findElement(mercadoriasButton);
        button.click();
    }

    public void setDescricao(String descricao) {
        waitForElement(descricaoInput);
        WebElement descricaoField = driver.findElement(descricaoInput);
        descricaoField.sendKeys(descricao);
    }

    public void setDate(String date) {
        waitForElement(dateInput);
        WebElement dateField = driver.findElement(dateInput);
        dateField.sendKeys(date);
    }

    public void setPeso(String peso) {
        waitForElement(pesoInput);
        WebElement pesoField = driver.findElement(pesoInput);
        pesoField.sendKeys(peso);
    }

    public void setCodigo(String codigo) {
        waitForElement(codigoInput);
        WebElement codigoField = driver.findElement(codigoInput);
        codigoField.sendKeys(codigo);
    }

    public void setAltura(String altura) {
        waitForElement(alturaInput);
        WebElement alturaField = driver.findElement(alturaInput);
        alturaField.sendKeys(altura);
    }

    public void setLargura(String largura) {
        waitForElement(larguraInput);
        WebElement larguraField = driver.findElement(larguraInput);
        larguraField.sendKeys(largura);
    }

    public void setVolume(String volume) {
        waitForElement(volumeInput);
        WebElement volumeField = driver.findElement(volumeInput);
        volumeField.sendKeys(volume);
    }

    public void setFragilidade(String fragilidade) {
        waitForElement(fragilidadeInput);
        WebElement fragilidadeField = driver.findElement(fragilidadeInput);
        fragilidadeField.sendKeys(fragilidade);
    }

    public void submitForm() {
        waitForElement(submitButton);
        WebElement submitBtn = driver.findElement(submitButton);
        submitBtn.click();
    }

    public String getResultadoText() {
        waitForElement(resultadoText);
        return driver.findElement(resultadoText).getText();
    }
}
