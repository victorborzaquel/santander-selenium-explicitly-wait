package com.victor.seleniumexplicitlywait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

class PageTest {
    private WebDriver driver;
    private Page page;
    private Wait<WebDriver> wait;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        page = new Page(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    void alert() {
        page.alertBtn.click();
        wait.until(alertIsPresent());

        assertEquals("I got opened after 5 secods", driver.switchTo().alert().getText());
    }

    @Test
    void changeText() {
        assertEquals("site", page.populateText.getText());

        page.populateTextBtn.click();
        wait.until(textToBe(By.id("h2"), "Selenium Webdriver"));

        assertEquals("Selenium Webdriver", page.populateText.getText());
    }

    @Test
    void displayButton() {
        assertFalse(page.hiddenBtn.isDisplayed());

        page.displayOtherBtn.click();
        wait.until(visibilityOf(page.hiddenBtn));

        assertTrue(page.hiddenBtn.isDisplayed());
    }

    @Test
    void enableButton() {
        assertFalse(page.disableBtn.isEnabled());

        page.enableBtn.click();
        wait.until(elementToBeClickable(page.disableBtn));

        assertTrue(page.disableBtn.isEnabled());
    }

    @Test
    void checkbox() {
        assertFalse(page.checkbox.isSelected());

        page.checkboxBtn.click();
        wait.until(elementToBeSelected(page.checkbox));

        assertTrue(page.checkbox.isSelected());
    }
}
