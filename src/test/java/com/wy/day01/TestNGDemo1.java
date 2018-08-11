package com.wy.day01;

import org.testng.annotations.*;

public class TestNGDemo1 {
    //所有用例之前执行
    @BeforeTest
    public void BeforTest(){
        System.out.println("我是@BeforTest注解");
    }
    //每个case执行之前执行
    @BeforeMethod
    public void BeforMethod(){
        System.out.println("我是@BeforMethod注解");
    }
    //执行case
    @Test
    public void testCase2(){
        System.out.println("我是@Test注解，case2");
    }
    //case按照方法名称排序
    @Test
    public void testCase1(){
        System.out.println("我是@Test注解，case1");
    }
    //每个case执行之后执行
    @AfterMethod
    public void AfterMethod(){
        System.out.println("我是@AfterMethod注解");
    }
    //所有用例执行之后执行
    @AfterTest
    public void AfterTest(){
        System.out.println("我是@AfterTest注解");
    }
}
