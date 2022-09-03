package com.geekbrains.lesson3.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {


    @FindBy(xpath = "//*[@id=\"content\"]/header/div[1]/div[3]/button")
    private WebElement signInButton;

    public MainPage(WebDriver driver) {

        super(driver);
        mainMenu = new MainMenu(driver);
    }

    public MainMenu mainMenu;

    public LoginPage clickSingInButton() {

        signInButton.click();
        return new LoginPage(driver);
    }
}
