package com.ti.tests;


import org.testng.annotations.Test;

public class NewRegistration extends Base{

    @Test (enabled = false)

    void  RegisterNewUser() throws InterruptedException {
        myAccount.RegisterNewEmail();

    }

    @Test(priority = 1)

    void ClickShopLink()
    {

        shop.GotoShop();
    }


    @Test(priority = 2)

    void ShowCheapestBook()
    {

        shop.sortPriceAsceding();
    }

    @Test(priority = 3)

    void SelectCheapestBook()
    {

        shop.SelectCheapest();
    }
}

