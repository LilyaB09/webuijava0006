package com.geekbrains.lesson3.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SwitchedToPurchase extends BasePage {
    public SwitchedToPurchase(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"__PAGE__\"]/div[2]/main/section[3]/div[3]/ul/li/ul/li/div/div[2]/div/div/div/div[2]/div")
    private WebElement totalSumma;

    private final String iconOkXpathLocator = "//i[@class='icon-ok']";

    @FindBy(xpath = iconOkXpathLocator)
    private WebElement iconOk;

    public SwitchedToPurchase checkTotalSumma(String expectedSumma) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iconOkXpathLocator)));
        Assertions.assertEquals(expectedSumma, totalSumma.getText());
        return this;
    }
}
