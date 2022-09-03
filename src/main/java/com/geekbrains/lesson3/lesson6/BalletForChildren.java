package com.geekbrains.lesson3.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BalletForChildren extends BasePage {
    public BalletForChildren(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"__PAGE__\"]/div[2]/main/section[2]/div[1]/div[5]/div/div/div[2]/div[3]/div/div/div/label[3]/span[2]")
    private List<WebElement> sizesList;

    public void selectSize(String size) {
        sizesList.stream().filter(s -> s.getText().contains(size)).findFirst().get().click();
    }

    @FindBy(xpath = "//*[@id=\"__PAGE__\"]/div[2]/main/section[2]/div[2]/ul/li/ul/div/div[2]/div/div[1]/div/a/h2")
    private WebElement productElement;

    @FindBy(xpath = "//*[@id=\"__PAGE__\"]/div[2]/main/section[1]/div[1]/div/div[2]/div/a")
    private WebElement buyTicketsButton;

    public SwitchedToPurchase balletProductBuy() {
        actions.moveToElement(productElement)
                .build()
                .perform();
        WebElement addToCartButton = null;
        addToCartButton.click();
        return new SwitchedToPurchase(driver);
    }
}
