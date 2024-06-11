public class MercadoriaPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @Test
    public void testInserirMercadoria() {

        WebElement codigo = driver.findElement(By.id("iptCodigo"));

        WebElement descricao = driver.findElement(By.name("descricao"));
        WebElement validade = driver.findElement(By.name("validade"));
        WebElement peso = driver.findElement(By.name("peso"));
        WebElement altura = driver.findElement(By.name("altura"));
        WebElement largura = driver.findElement(By.name("largura"));
        WebElement volume = driver.findElement(By.name("volume"));
        WebElement fragilidade = driver.findElement(By.name("fragilidade"));



        codigo.sendKeys("12345");
        descricao.sendKeys("Teste de mercadoria");
        validade.sendKeys("12/31/2024");
        peso.sendKeys("10");
        altura.sendKeys("20");
        largura.sendKeys("30");
        volume.sendKeys("6000");
        fragilidade.sendKeys("Frágil");

        WebElement inserirButton = driver.findElement(By.cssSelector("button[type='submit']"));
        inserirButton.click();

        WebElement resultado = driver.findElement(By.id("resultado"));
        assertEquals("Mercadoria inserida com sucesso!", resultado.getText());
    }
}

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public WebElement getCodigoInput(){
        return driver.findElement()
    }

    public WebElement getTitleElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
    }

    public WebElement getFirstInputElement() {
        return driver.findElement(firstInputLocator);
    }

    public WebElement getSecondInputElement() {
        return driver.findElement(secondInputLocator);
    }

    public WebElement getButtonElement() {
        return driver.findElement(buttonLocator);
    }

    public WebElement getHomeLink() {
        return driver.findElement(homeLinkLocator);
    }

    public WebElement getResponsiveElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(responsiveElementLocator));
    }

    public void registerNewBook(String title, String genre) {
        driver.findElement(firstInputLocator).sendKeys(title);
        driver.findElement(secondInputLocator).sendKeys(genre);
        driver.findElement(buttonLocator).click();
    }

    public WebElement getButtonLearnMore() {
        return driver.findElement(buttonLearnMoreLocator);
    }
}