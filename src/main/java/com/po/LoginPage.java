package com.po;

import org.openqa.selenium.By;

public class LoginPage {
    public static By username = By.xpath(".//*[@id='account-box']/div[2]/input");
    public static By password = By.xpath(".//*[@id='login-form']/div[1]/div[3]/div[2]/input[2]");
    public static By loginbutton = By.id("dologin");
}
