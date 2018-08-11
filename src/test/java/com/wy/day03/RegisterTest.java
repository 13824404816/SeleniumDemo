package com.wy.day03;

import com.logic.Iframe;
import com.logic.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegisterTest {
    WebDriver driver;
    @BeforeMethod
    public void openSelect(){

        System.setProperty("webdriver.chrome.driver","D:\\IDEAPoject\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //控制全局时间
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void closeSelect(){
        driver.quit();
    }
    @Test
    public void registerTest() throws InterruptedException {
        driver.get("https://mail.163.com/");
        //转交控制权到iframe
        driver.switchTo().frame("x-URS-iframe");
        //点击注册按钮
        driver.findElement(By.id("changepage")).click();
        //转交控制权
        Iframe.ifreameKongZhi(driver);
        //填写注册内容
        Register.registerTest(driver,"13824404822","3232516","3232516","13824404888","1234","1234");
        //获取错误提示信息
        boolean displayed = driver.findElement(By.xpath(".//*[@id='m_vcode']/span")).isDisplayed();
        System.out.println(displayed);
        //检查错误消息是否展示
        Assert.assertTrue(displayed);


    }
    @Test
    public void time(){
        String time = String.valueOf(System.currentTimeMillis());
        System.out.println(time);
    }
}
