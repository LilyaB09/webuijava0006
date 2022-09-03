package com.geekbrains.lesson3.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChildrensChoice extends BasePage {

    public ChildrensChoice(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"__PAGE__\"]/div[2]/main/section[2]/div/div[2]/div[1]/a[1]")
    private WebElement tChildrensGenres;

    public BalletForChildren clickTChildrensGenres() {
        tChildrensGenres.click();
        return new BalletForChildren(driver);
    }
}
