package com.geekbrains.lesson3.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends MainPage {
    public MainMenu(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//*[@id=\"content\"]/header/div[2]/nav/a[7]")
    private WebElement buttonForKids;

    public SwitchedToPurchase hoverOverKidsButton() {
        actions.moveToElement(buttonForKids)
                .build()
                .perform();
        return new SwitchedToPurchase(driver);
    }
}
