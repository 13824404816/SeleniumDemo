package com.wy.day02;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class ActionsTest2 {
    WebDriver driver;
    @BeforeMethod
    public void openSelect(){
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.setProperty("webdriver.chrome.driver","D:\\IDEAPoject\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void closeSelect(){
        driver.quit();
    }
    /**
     * 打开百度页面
     * 在百度一下按钮上右键
     */
    @Test
    public void rightClick() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement su = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.contextClick(su).perform();
        Thread.sleep(3000);
    }
    /**
     * 移动鼠标到更多产品
     */
    @Test
    public void moveToTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement el = driver.findElement(By.xpath(".//*[@id='u1']/a[9]"));
        Actions ac = new Actions(driver);
        ac.moveToElement(el).perform();
        Thread.sleep(3000);
    }
    /**
     * 拖拽鼠标
     */
    @Test
    public void testDrop() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement el1 = driver.findElement(By.xpath(".//*[@id='u1']/a[1]"));
        WebElement el2 = driver.findElement(By.id("kw"));
        Actions ac = new Actions(driver);
        Thread.sleep(2000);
        ac.clickAndHold(el1).moveToElement(el2).release(el1).perform();
        Thread.sleep(3000);
    }
    /**
     * 下载软件
     */
    @Test
    public void downTest() throws AWTException, InterruptedException {
        driver.get("https://pc.qq.com/category/c0.html");
        WebElement element = driver.findElement(By.xpath("html/body/div[2]/div[1]/div/div/ul/li[1]/a"));
        Actions ac = new Actions(driver);
        ac.moveToElement(element).perform();
        driver.findElement(By.xpath("html/body/div[2]/div[1]/div/div/ul/li[1]/div/a[1]")).click();
        Thread.sleep(3000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
    }

}
