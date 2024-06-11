package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.MercadoriasPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class MercadoriasTests extends TesteBase {

    @Test
    @DisplayName("Should add a new merchandise")
    void shouldAddNewMerchandise() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement headerIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='header.html']")));
        driver.switchTo().frame(headerIframe);

        WebElement merchandiseLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='mercadorias/mercadorias.html']")));
        merchandiseLink.click();

        driver.switchTo().defaultContent();

        MercadoriasPage mercadoriasPage = new MercadoriasPage(driver);
        mercadoriasPage.getCodeField().sendKeys(faker.number().digits(6));
        mercadoriasPage.getDescriptionField().sendKeys(faker.commerce().productName());
        mercadoriasPage.getExpirationDateField().sendKeys("2023-12-31");
        mercadoriasPage.getWeightField().sendKeys("10");
        mercadoriasPage.getHeightField().sendKeys("100");
        mercadoriasPage.getWidthField().sendKeys("50");
        mercadoriasPage.getVolumeField().sendKeys("5000");

        WebElement fragilityDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fragilidade")));
        Select selectFragility = new Select(fragilityDropdown);
        selectFragility.selectByVisibleText("Fragíl");

        mercadoriasPage.getInsertButton().click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedText = "Cadastrado com sucesso!";
        assertThat(alertText).isEqualTo(expectedText);
        alert.accept();
    }
}
