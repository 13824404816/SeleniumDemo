package com.wy.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActionTest {
    WebDriver driver;
    @BeforeMethod
    public void beforMethod(){
        System.setProperty("webdriver.chrome.driver","D:\\IDEAPoject\\Selenium\\drivers\\chromedriver.exe");
        //实例化ChromeDriver
        driver = new ChromeDriver();
    }
    /**
     * 打开Chrome浏览器
     * 打开百度首页
     * 等待5S
     * 关闭浏览器
     */
    @Test
    public void getTest() throws InterruptedException {

        //打开百度页面
        driver.get("http://www.baidu.com");
        //停留1s
        Thread.sleep(1000);
    }
    /**
     * 打开Chrome浏览器
     * 打开百度首页
     * 等待3S
     * 浏览器后退
     * 等待3S
     * 浏览器前进
     * 关闭浏览器
     */
    @Test
    public void alterTest() throws InterruptedException {
        //打开百度页面
        driver.get("http://www.baidu.com");
        //等待1S
        Thread.sleep(1000);
        //浏览器后退
        driver.navigate().back();
        //等待1S
        Thread.sleep(1000);
        //浏览器前进
        driver.navigate().forward();
        Thread.sleep(1000);
        //浏览器关闭
        driver.quit();
    }
    /**
     * 打开Chrome浏览器
     * 浏览器大小设置为300*200
     * 浏览器最大化
     * 浏览器刷新
     */
    @Test
    public void windows() throws InterruptedException {
        //设置浏览器大小为300*200
        Dimension dimension = new Dimension(300,200);
        //将大小传给driver
        driver.manage().window().setSize(dimension);
        //等待1S
        Thread.sleep(1000);
        //设置浏览器最大化
        driver.manage().window().maximize();
        //等待2S
        Thread.sleep(1000);
        //刷新页面
        driver.navigate().refresh();
    }
    /**
     * 打开Chrome浏览器
     * 跳转到百度
     * 获取URL地址
     */
    @Test
    public void getURL(){
        //跳转到Baidu
        driver.get("https://www.baidu.com");
        //获取URL地址
        String URL = driver.getCurrentUrl();
        //对比地址
        Assert.assertEquals(URL,"https://www.baidu.com/");
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
