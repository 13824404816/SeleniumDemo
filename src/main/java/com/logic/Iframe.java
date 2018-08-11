package com.logic;

import org.openqa.selenium.WebDriver;

public class Iframe {
    public static void ifreameKongZhi(WebDriver driver){
        String windowHandle = driver.getWindowHandle();
        for(String h : driver.getWindowHandles()){
            if(h.equals(windowHandle)){
                continue;
            }else{
                driver.switchTo().window("h");
            }
        }
    }
}
