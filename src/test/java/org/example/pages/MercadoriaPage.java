package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

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


    public MercadoriaPage(WebDriver driver) {
        super(driver);
    }

    public String getErrorMessage() {
        try {
            WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message")));
            return errorMessageElement.getText();

        } catch (TimeoutException e) {
            return "Erro: Mensagem de erro não encontrada após submissão do formulário.";
        }
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
    public String getCodigo() {
        waitForElement(codigoInput);
        WebElement codigoField = driver.findElement(codigoInput);
        return codigoField.getAttribute("value");
    }

    public String getDescricao() {
        waitForElement(descricaoInput);
        WebElement descricaoField = driver.findElement(descricaoInput);
        return descricaoField.getAttribute("value");
    }

    public String getValidade() {
        waitForElement(dateInput);
        WebElement validadeField = driver.findElement(dateInput);
        return validadeField.getAttribute("value");
    }

    public String getPeso() {
        waitForElement(pesoInput);
        WebElement pesoField = driver.findElement(pesoInput);
        return pesoField.getAttribute("value");
    }

    public String getAltura() {
        waitForElement(alturaInput);
        WebElement alturaField = driver.findElement(alturaInput);
        return alturaField.getAttribute("value");
    }

    public String getLargura() {
        waitForElement(larguraInput);
        WebElement larguraField = driver.findElement(larguraInput);
        return larguraField.getAttribute("value");
    }

    public String getVolume() {
        waitForElement(volumeInput);
        WebElement volumeField = driver.findElement(volumeInput);
        return volumeField.getAttribute("value");
    }

    public String getFragilidade() {
        waitForElement(fragilidadeInput);
        WebElement fragilidadeField = driver.findElement(fragilidadeInput);
        return fragilidadeField.getAttribute("value");
    }

    public void submitForm() {
        waitForElement(submitButton);
        WebElement submitBtn = driver.findElement(submitButton);
        submitBtn.click();
    }
    public void fillForm(String codigo, String descricao, String validade, String peso, String altura, String largura, String volume, String fragilidade) {
        setDescricao(descricao);
        setAltura(altura);
        setLargura(largura);
        setVolume(volume);
        setFragilidade(fragilidade);
        setPeso(peso);
        setCodigo(codigo);
        setDate(validade);
    }
    public String waitForAlertAndGetText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }

}
