package com.wy.day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    WebDriver driver;
    @BeforeMethod
    public void openAlterTest(){
        System.setProperty("webdriver.chrome.driver","D:\\IDEAPoject\\Selenium\\drivers\\chromedriver.exe");
        //实例化ChromeDriver
        driver = new ChromeDriver();
    }

    /**
     * alert弹框处理
     */
    @Test
    public void alertTest() throws InterruptedException {
        driver.get("C:\\Users\\13824\\Desktop\\bixbar.html");
        driver.findElement(By.id("a")).click();
        Thread.sleep(3000);
        //把控制权转交给Alert
        Alert alert = driver.switchTo().alert();
        //accept弹框中点击确定方法
        alert.accept();
        Thread.sleep(3000);
    }

    /**
     * Confirm弹框处理
     */
    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("C:\\Users\\13824\\Desktop\\bixbar.html");
        driver.findElement(By.id("b")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
    }

    /**
     * prompt弹框处理
     */
    @Test
    public void promptTest() throws InterruptedException {
        driver.get("C:\\Users\\13824\\Desktop\\bixbar.html");
        driver.findElement(By.id("c")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("弹框");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
    }

    @Test
    public void iframeTest(){
        driver.get("www.baidu.com");
    }
    @AfterMethod
    public void closeAlterTest(){
        driver.quit();
    }
}
