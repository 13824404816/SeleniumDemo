package com.wy.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {
    //启动火狐浏览器
    @Test
    public void openFF(){
        WebDriver webDriver = new FirefoxDriver();
    }
    //启动谷歌浏览器
    @Test
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IDEAPoject\\Selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
    }

}
