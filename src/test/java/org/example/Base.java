package org.example;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;

    public Base(SafariDriver driver) {
        this.driver = new SafariDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.faker = new Faker();
    }
}
