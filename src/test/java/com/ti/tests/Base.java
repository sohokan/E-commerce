package com.ti.tests;

import com.ti.pompages.Shop;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.*;
import org.ti.DriverFactory;
import org.ti.BrowserType;
import com.ti.pompages.MainPage ;
import com.ti.pompages.MyAccount ;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Base {

    protected String baseUrl = "https://practice.automationtesting.in/";


    Shop shop;
    MyAccount myAccount;





    @BeforeSuite
    @Parameters("browser")
    public void setup(String browser) {
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        DriverFactory.getInstance().getDriver().navigate().to(baseUrl);


    }

    @BeforeClass
    public void runObjects()
    {
        shop =new Shop();
        myAccount= new MyAccount();

    }


    @AfterSuite
    void turnDown() {

        DriverFactory.getInstance().removeDriver();
    }





//       ItemsList.stream()
//                .filter(p ->
//                        p.clothe_name.contains(color.toUpperCase())).
//     forEach(e ->
//                        System.out.println(e.clothe_name + " cost: " + e.clothe_price))
//
//       ;
//
//
//
//
//        ItemsList.stream()
//
//                .forEach(
//                        e -> {
//                            if (e.clothe_name.contains(color.toUpperCase())) {
//                                System.out.println(e.clothe_name + " cost: " + e.clothe_price);
//                            } else {
//                                System.out.println("Theres no color found");
//                            }
//                        }
//                );







}
