package com.logic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
    public static void registerTest(WebDriver driver,String emailaddress,String pwd1,String pwd2,String phone,String yanzhengma,String phoneyanzhengma){
        //输入邮箱地址
        driver.findElement(By.id("nameIpt")).sendKeys(emailaddress);
        //输入密码
        driver.findElement(By.id("mainPwdIpt")).sendKeys(pwd1);
        //输入确认密码
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys(pwd2);
        //输入手机号码
        driver.findElement(By.id("mainMobileIpt")).sendKeys(phone);
        //输入验证码
        driver.findElement(By.id("vcodeIpt")).sendKeys(yanzhengma);
        //点击获取验证码按钮
        driver.findElement(By.id("sendMainAcodeBtn")).click();
        //输入短信验证码
        driver.findElement(By.id("mainAcodeIpt")).sendKeys(phoneyanzhengma);
        //点击立即注册按钮
        driver.findElement(By.id("mainRegA")).click();
    }
}
