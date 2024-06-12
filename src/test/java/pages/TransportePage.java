package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransportePage {
    WebDriver driver;

    @FindBy(id = "iptPlaca")
    WebElement plateDropdown;

    @FindBy(id = "iptCodigo")
    WebElement codeDropdown;

    @FindBy(id = "iptDataInicio")
    WebElement startDateField;

    @FindBy(id = "iptDataTermino")
    WebElement endDateField;

    @FindBy(id = "iptCidadeInicio")
    WebElement startCityField;

    @FindBy(id = "iptCidadeTermino")
    WebElement endCityField;

    @FindBy(id = "iptQuilometros")
    WebElement kilometersField;

    @FindBy(id = "inserirTransporte")
    WebElement insertButton;

    public TransportePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getPlateDropdown() {
        return plateDropdown;
    }

    public WebElement getCodeDropdown() {
        return codeDropdown;
    }

    public WebElement getStartDateField() {
        return startDateField;
    }

    public WebElement getEndDateField() {
        return endDateField;
    }

    public WebElement getStartCityField() {
        return startCityField;
    }

    public WebElement getEndCityField() {
        return endCityField;
    }

    public WebElement getKilometersField() {
        return kilometersField;
    }

    public WebElement getInsertButton() {
        return insertButton;
    }
}
