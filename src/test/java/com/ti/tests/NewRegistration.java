package com.ti.tests;


import com.ti.pompages.MyAccount;
import org.testng.annotations.Test;

public class NewRegistration extends Base{



    @Test (priority = 2,enabled = true)

    void  RegisterNewUser() throws InterruptedException {
        myAccount.RegisterNewEmail();

    }



}

