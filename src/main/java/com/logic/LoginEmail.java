package com.logic;

import com.po.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginEmail {
    public static void login(WebDriver driver, String username, String password){
        driver.get("https://mail.163.com/");
        //转交控制权到iframe
        driver.switchTo().frame("x-URS-iframe");
        //输入账号
        driver.findElement(LoginPage.username).sendKeys(username);
        //输入密码
        driver.findElement(LoginPage.password).sendKeys(password);
        //点击登录按钮
        driver.findElement(LoginPage.loginbutton).click();
    }
}
