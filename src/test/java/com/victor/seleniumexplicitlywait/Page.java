package com.victor.seleniumexplicitlywait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
    @FindBy(id = "alert")
    public WebElement alertBtn;

    @FindBy(id = "populate-text")
    public WebElement populateTextBtn;

    @FindBy(id = "display-other-button")
    public WebElement displayOtherBtn;

    @FindBy(id = "hidden")
    public WebElement hiddenBtn;

    @FindBy(id = "enable-button")
    public WebElement enableBtn;

    @FindBy(id = "checkbox")
    public WebElement checkboxBtn;

    @FindBy(id = "h2")
    public WebElement populateText;

    @FindBy(id = "disable")
    public WebElement disableBtn;

    @FindBy(id = "ch")
    public WebElement checkbox;

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
