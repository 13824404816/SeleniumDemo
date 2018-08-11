package com.wy.day03;

import com.logic.Iframe;
import com.logic.LoginEmail;
import com.po.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
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
    @DataProvider(name = "userlist")
    public Object[][] test1(){
        return new Object[][]{
                {"13824404816","w3232515"},
                //{"17603023243","w3232515"}
        };
    }
    @Test(dataProvider = "userlist")
    public void loginSuccessTest(String username,String password){
        LoginEmail.login(driver,username,password);
        //切换控制权
        Iframe.ifreameKongZhi(driver);
        //判断是否登录成功
        boolean displayed = driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul[1]/li[2]/span[2]")).isDisplayed();
        Assert.assertTrue(displayed);

    }
    @Test
    public void loginErroTest(){
        LoginEmail.login(driver,"13824404816","w3232515123");
        //判断是否登录失败
        boolean displayed = driver.findElement(By.id("nerror")).isDisplayed();
        Assert.assertFalse(displayed);

    }
}
