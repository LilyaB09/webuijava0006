package com.geekbrains.lesson6;

import com.geekbrains.lesson3.lesson6.LoginPage;
import com.geekbrains.lesson3.lesson6.MainMenu;
import com.geekbrains.lesson3.lesson6.MainPage;
import com.geekbrains.lesson3.lesson6.SwitchedToPurchase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.afisha.ru/izhevsk/cinema/");
    }

    @Test
    void chooseMovie() throws InterruptedException {
        //MainPage mainPage = new MainPage(driver);
        //mainPage.clickSingInButton();
        //new LoginPage(driver).login("prk.reklama@yandex.ru", "ASDFGHJ14z");
        //new MainMenu(driver).clickSingInButton();
        //new SwitchedToPurchase(driver).

        new MainPage(driver).clickSingInButton()
                .login("prk.reklama@yandex.ru", "ASDFGHJ14z")
                .mainMenu.hoverOverKidsButton()
                .balletProductBuy()
                .checkTotalSumma("450");
    }

    @AfterEach
    void killBrowser() {
        driver.quit();
    }

}
