package com.wy.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest {
    /**
     * 打开百度页面
     * 定位搜索文本框
     */
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IDEAPoject\\Selenium\\drivers\\chromedriver.exe");
        //实例化ChromeDriver
        driver = new ChromeDriver();
    }
    @Test
    public void byIdTest(){
        driver.get("https://wwww.baidu.com");
        WebElement kw = driver.findElement(By.id("kw"));
        System.out.println(kw);
        Assert.assertNotNull(kw);
    }

    /**
     * 获取所有input标签
     */
    @Test
    public void byTagName(){
        driver.get("https://www.baidu.com");
        List<WebElement> list = driver.findElements(By.tagName("input"));
        for(WebElement ele :list){
            System.out.println(ele);
        }
    }

    /**
     * 遍历右上角所有元素内容
     */
    @Test
    public void byXpath(){
        driver.get("https://www.baidu.com");
        List<WebElement> list = driver.findElements(By.xpath(".//*[@id='u1']/a"));
        for(WebElement ele:list){
            System.out.println(ele.getText());
        }
    }

    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}
