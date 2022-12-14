package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class MarkTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://izhevsk.ru/forum/login");
        WebElement LoginFotm = driver.findElement(By.name("UserName"));
        LoginFotm.sendKeys("krolik123");
        driver.findElement(By.name("Password")).sendKeys("ThL2bMGxcr");
        driver.findElement(By.xpath("input")).click();

        driver.findElement(By.xpath("//*[@id=\"hide800\"]/table/tbody/tr[1]/td/font/b/a")).click();

        String postTile = "test" + new Random().nextInt(1000);
        driver.findElement(By.name("TopicSubject")).sendKeys("postTile");

        driver.findElement(By.id("message")).sendKeys("ttvrttttttt");

        driver.findElement(By.xpath("input")).click();

        List<WebElement> postTitles = driver.findElements(By.xpath("//a[@acronym='title']"));
        postTitles.stream().filter(p -> p.getText().equals(postTile)).findFirst().get();

        Thread.sleep(5000);

        driver.quit();


    }
}
