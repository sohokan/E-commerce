package com.ti.tests;


import org.testng.annotations.Test;

public class NewRegistration extends Base{

    @Test (enabled = true)

    void  RegisterNewUser() throws InterruptedException {
        myAccount.RegisterNewEmail();
    }
}
