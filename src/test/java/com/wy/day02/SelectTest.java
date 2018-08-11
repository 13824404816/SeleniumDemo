package com.wy.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectTest {
    WebDriver driver;
    @BeforeMethod
    public void openSelect(){

        System.setProperty("webdriver.chrome.driver","D:\\IDEAPoject\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void closeSelect(){
        driver.quit();
    }

    /**
     * 打开测试界面
     * 下拉框进行选择
     */
    @Test
    public void selectTest(){
        driver.get("");
        WebElement selectEl = driver.findElement(By.tagName("select"));
        Select select = new Select(selectEl);
        select.selectByIndex(0);
        String handle1 = driver.getWindowHandle();

    }

    /**
     * 控制多窗口
     */
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='setf']")).click();
        //获取当前页面的Handle
        String handle1 = driver.getWindowHandle();
        for(String handle:driver.getWindowHandles()){
            //对比是否为第一个页面的Handle如果是则跳过，不是则给予控制权
            if(handle.equals(handle1)){
                continue;
            }else{
                driver.switchTo().window(handle);
            }
        }
        driver.findElement(By.xpath(".//*[@id='head']/div[2]/a[3]")).click();
        Thread.sleep(3000);
    }


}
