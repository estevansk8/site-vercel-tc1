package tests;

import pages.HomePage;
import pages.MercadoriasPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class MercadoriasTests extends TesteBase {

    @Test
    @DisplayName("Should add a new merchandise")
    void shouldAddNewMerchandise() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.getMerchandiseLink().click();

        MercadoriasPage mercadoriasPage = new MercadoriasPage(driver);
        mercadoriasPage.getCodeField().sendKeys(faker.number().digits(6));
        mercadoriasPage.getDescriptionField().sendKeys(faker.commerce().productName());
        mercadoriasPage.getExpirationDateField().sendKeys("2023-12-31");
        mercadoriasPage.getWeightField().sendKeys("10");
        mercadoriasPage.getHeightField().sendKeys("100");
        mercadoriasPage.getWidthField().sendKeys("50");
        mercadoriasPage.getVolumeField().sendKeys("5000");
        mercadoriasPage.getFragilityDropdown().selectByVisibleText("Fragil");
        mercadoriasPage.getInsertButton().click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedText = "Merchandise added successfully";
        assertThat(alertText).isEqualTo(expectedText);
        alert.accept();
    }


}
