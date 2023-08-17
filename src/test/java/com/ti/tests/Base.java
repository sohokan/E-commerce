package com.ti.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.ti.DriverFactory;
import org.ti.BrowserType;
import com.ti.pompages.MainPage ;
import com.ti.pompages.MyAccount ;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Base {

    protected String baseUrl = "https://practice.automationtesting.in/";

    MainPage mainPage;
    MyAccount myAccount;






    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        DriverFactory.getInstance().getDriver().navigate().to(baseUrl);

        mainPage= new MainPage();
        myAccount= new MyAccount();


    }







}
