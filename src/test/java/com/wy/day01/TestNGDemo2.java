package com.wy.day01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo2 {
    //校验 a == a\
    @Test
    public void assertEqualsTest(){
        String a = "wy";
        String b = "wy";
        Assert.assertEquals(a,b,"a不等于b");
    }
}
