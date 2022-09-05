package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class AfishaTest {
    //public static void main(String[] args) throws InterruptedException {
        //WebDriverManager.chromedriver().setup();

        //WebDriver driver = new ChromeDriver();
        //driver.get("https://www.afisha.ru/");

        //driver.findElement(By.xpath("//input[@placeholder='Событие, актер, место']")).sendKeys("пес-призрак");
        //WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='пес-призрак']")));
        //driver.findElement(By.xpath("//div[.='пес-призрак']")).click();

        //Thread.sleep(5000);
        //driver.quit();

    //}
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String WWW_AFISHA_RU_URL = "https://www.afisha.ru/";

    @BeforeAll
    static  void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void  setupBrowser(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(WWW_AFISHA_RU_URL);
    }
    @Test
    void PutInBasketTest() throws InterruptedException {

        driver.findElement(By.xpath("//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]/h2")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath(
                "//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]/h2")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")));

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'login')]")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        Assertions.assertEquals(driver.findElement(By.id("login")).isDisplayed(), false);
    }

    @Test
    void hoverCinemaButtonAndClickOkkoLinkTest() throws InterruptedException {
        actions.moveToElement(driver.findElement(By.xpath("//button[.='Подписаться']")))
                .build()
                .perform();


        SystemColor item;
        Object https;
        driver.findElement(By.xpath("//header//a[.='Скоро онлайн в Okko']")).click();
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.afisha.ru/movie/okko-soon/");
    }
    @AfterEach
    void quitBrowser(){
        driver.quit();
    }
}
