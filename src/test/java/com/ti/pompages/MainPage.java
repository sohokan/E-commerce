package com.ti.pompages;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.ti.DriverFactory;
import org.ti.BrowserType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringEscapeUtils;


public class MainPage {

    WebDriver driver = DriverFactory.getInstance().getDriver();

    JavascriptExecutor js = (JavascriptExecutor) driver;

    List<booksPojo> books = new ArrayList<>();

    void disableAds(List<WebElement> adspopup) throws InterruptedException {

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

    public void hideElements()
    {

        js.executeScript("const elements = document.getElementsByClassName('GoogleActiveViewElement'); while (elements.length > 0) elements[0].remove()");

    }

    public void hideElement(By ads)
    {
        List<WebElement> element = driver.findElements(ads);

        for (var e:element
             ) {
            System.out.println(e.getClass());
            ((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", element);
        }

    }








}
