package com.wy.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CloseBrowserTest {
    @Test
    public void closeFF() {
        System.setProperty("webdriver.chrome.driver","D:\\IDEAPoject\\Selenium\\drivers\\chromedriver.exe");
        //实例化FirefoxDriver
        WebDriver webDriver = new FirefoxDriver();
        //Thread.sleep(5000);
        //close关闭当前浏览器页面，没有释放资源
        //webDriver.close();
        //quit关闭浏览器，释放资源建议使用quit
        webDriver.quit();

    }
}
