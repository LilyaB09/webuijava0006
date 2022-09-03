package com.geekbrains.lesson3.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SwitchedToPurchase extends BasePage {
    public SwitchedToPurchase(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"__PAGE__\"]/div[2]/main/section[3]/div[3]/ul/li/ul/li/div/div[2]/div/div/div/div[2]/div")
    private WebElement totalSumma;

    public SwitchedToPurchase checkTotalSumma() {
        short expectedSumma;
        Assertions.assertEquals(expectedSumma, totalSumma.getText());
        return this;

    }

    public Object selectSize(String s) {
    }
}
