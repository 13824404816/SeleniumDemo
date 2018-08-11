package com.wy.day03;

import com.logic.Iframe;
import com.logic.LoginEmail;
import com.logic.SendEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SendEmailTest {
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
        //driver.quit();
    }
    @Test
    public void sendEmailTest(){
        //登录
        LoginEmail.login(driver,"13824404816","w3232515");
        //获取控制权限
        Iframe.ifreameKongZhi(driver);
        //发送邮件
        SendEmail.sendEmail(driver,"13824404816@163.com","C:\\Users\\13824\\Desktop\\1\\timg.jpg");

        //判断是否发送成功
        boolean displayed = driver.findElement(By.linkText("可用手机接收回复")).isDisplayed();
        Assert.assertTrue(displayed);


    }


}
