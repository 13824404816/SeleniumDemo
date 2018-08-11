package com.wy.day02;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionsTest {

    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IDEAPoject\\Selenium\\drivers\\chromedriver.exe");
        //实例化ChromeDriver
        driver = new ChromeDriver();
    }
    /**
     * 点击百度首页新闻按钮
     */
    @Test
    public void clicknewTest(){
        driver.get("https://www.baidu.com");
        WebElement element = driver.findElement(By.name("tj_trnews"));
        //点击新闻链接
        element.click();
        //获取跳转后的链接
        String url = driver.getCurrentUrl();
        //通过对比URL判断是否跳转成功
        Assert.assertEquals(url,"http://news.baidu.com/");
    }

    /**
     * 百度输入selenium进行搜索
     * 校验title是否等于“selenium_百度搜索”
     */
    @Test
    public void sendkeysTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //定位baidu搜索框
        WebElement element = driver.findElement(By.id("kw"));
        //搜索框中输入“selenium”
        element.sendKeys("selenium");
        //定位百度搜索按钮
        WebElement button = driver.findElement(By.id("su"));
        //点击搜索按钮
        button.click();
        Thread.sleep(2000);
        //获取当前页面title
        String title = driver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");
    }

    /**
     * 清空百度输入框中的内容
     */
    @Test
    public void clearTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //定位baidu搜索框
        WebElement element = driver.findElement(By.id("kw"));
        //搜索框中输入“selenium”
        element.sendKeys("selenium");
        Thread.sleep(3000);
        //清空输入框中的内容
        element.clear();
        Thread.sleep(3000);
    }

    /**
     * 打开百度首页
     * 获取文本框的tagname
     * 校验是否为input
     */
    @Test
    public void getTagNameTest(){
        driver.get("http://www.baidu.com");
        String tagName = driver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagName,"input");
    }

    /**
     * 获取“百度一下”按钮value属性值
     */
    @Test
    public void getATest(){
        driver.get("http://www.baidu.com");
        String value = driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(value,"百度一下");
    }

    /**
     * 判断元素是否展示
     */
    @Test
    public void isDisplayedTest(){
        driver.get("http://www.baidu.com");
        boolean su = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(su);
    }

    /**
     * 判断选择框是否被选取
     */
    @Test
    public void isSelectedTest() throws InterruptedException {
        driver.get("https://reg.jd.com/b/regPage?source=buser");
        WebElement element = driver.findElement(By.xpath(".//*[@id='step1-wrap']/div[4]/div/div[1]/div"));
        element.click();
        Thread.sleep(3000);
        boolean selected = element.isSelected();
        Assert.assertTrue(selected);

    }

    /**
     * 判断输入框是否为被激活状态
     */
    @Test
    public void isEnabledTest(){
        driver.get("https://parentstest.yiaitech.com/#/login");
        boolean enabled = driver.findElement(By.xpath(".//*[@id='submit']/div/button")).isEnabled();
        Assert.assertTrue(enabled);
    }

    /**
     * 截图百度首页
     */
    @Test
    public void getPageTest() throws IOException {
        driver.get("http://www.baidu.com");
        SimpleDateFormat df = new SimpleDateFormat("MMddHHmm");//设置日期格式
        String format = df.format(new Date());//获取当前时间
        System.out.println(format);
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("D:\\"+format+".png"));

    }

    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }


}
