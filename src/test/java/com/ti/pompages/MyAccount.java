package com.ti.pompages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MyAccount extends MainPage{
    By MyAccount= By.xpath("//a[normalize-space()='My Account']");
    By NewEmailId= By.id("reg_email");
    By NewPasswordId=By.xpath("//input[@id='reg_password']");
    By RegisterID= By.cssSelector("input[value='Register']");
    By ads= By.xpath("//div[contains(@id,'ad')]");

    By pwbanner= By.xpath("//div[contains(@class,'password')]");

    By logutlink=By.xpath("//a[contains(@href,'logout') ]");

    List<WebElement> pwbannersList;
    List<WebElement> adspopup;

    public void RegisterNewEmail() throws InterruptedException {
//        JavascriptExecutor ex=(JavascriptExecutor)driver;
//        Actions act = new Actions(driver);
        adspopup= driver.findElements(ads);


        WebElement LinkMyAccount= driver.findElement(MyAccount);
        LinkMyAccount.click();

            disableAds();

        if( driver.getCurrentUrl().contains("google_vignette"))
        LinkMyAccount.click();

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//h2[normalize-space()='Register']"))));
        WebElement typeNewEmail =driver.findElement(NewEmailId);
        WebElement typePassword=driver.findElement(NewPasswordId);
        WebElement  btnRegister = driver.findElement(RegisterID);


        typeNewEmail.sendKeys(generateRandomEmail(10));

        typePassword.sendKeys(generateRandomPassword(12));

        Boolean btnRegisterDisabled= Boolean.valueOf(btnRegister.getAttribute("disabled"));

        System.out.println(btnRegisterDisabled);


        pwbannersList=driver.findElements(pwbanner);

do  {
    if( driver.findElements(logutlink).size()>0)
    {break;}
    typePassword.sendKeys(Keys.ARROW_LEFT, Keys.ARROW_RIGHT);
    btnRegister.click();

    //     ex.executeScript("arguments[0].click()", btnRegister);

}while (btnRegisterDisabled);









  /*





do {
    typePassword.sendKeys(Keys.SPACE);


        ex.executeScript("arguments[0].click()", btnRegister);
    ex.executeScript("arguments[0].click()", btnRegister);
} while (pwbannersList.size()>0);
*/



    }






    public static String generateRandomEmail(int length) {

        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.random(length, allowedChars);
        email = temp.substring(0, temp.length()) + "@testdata.com";
        System.out.println(email);
        return email;
    }


    public static String generateRandomPassword(int length) {
//        System.out.println("Generating a Random PW ");
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" +"ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "1234567890" + "$";
        String password = "";
        String temp = RandomStringUtils.random(length, allowedChars);
        password = temp.substring(0, temp.length());
        System.out.println(password);
        return password;
    }



    void disableAds() throws InterruptedException {

        if((adspopup.size() > 0) || driver.getCurrentUrl().contains("google_vignette"))  {
// Comparing the web URL
//            assertEquals("https://practice.automationtesting.in/#google_vignette", driver.getCurrentUrl());

//            new WebDriverWait(driver, Duration.ofSeconds(10))
//                    .until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[contains(@class,'close')]"))));



            Thread.sleep(1000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
          /*  WebElement AdButton = driver.findElement(By.xpath("//div[contains(@class,'close')]"));
            AdButton.click();*/

// Comparing the web URL
//            String newURL = driver.getCurrentUrl();
//            assertEquals("https://practice.automationtesting.in/my-account/", newURL);
        }
    }


}
