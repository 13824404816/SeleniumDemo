package com.logic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendEmail {
    //发送邮件
    public static void sendEmail(WebDriver driver, String shoujian, String address){
        //点击写信按钮
        driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul[1]/li[2]/span[2]")).click();
        //输入收件人
        driver.findElement(By.xpath(".//*[@aria-label='收件人地址输入框，请输入邮件地址，多人时地址请以分号隔开']")).sendKeys("13824404816@163.com");
        //点击附件按钮
        driver.findElement(By.xpath(".//*[@type='file']")).sendKeys("C:\\Users\\13824\\Desktop\\1\\timg.jpg");
        //点击发送按钮
        driver.findElement(By.xpath(".//*[@class='nui-toolbar-item']/div[1]/span[2]")).click();
    }
}
