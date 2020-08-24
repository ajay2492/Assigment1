package com.zestmoney.assigment3.FlipKart;

import comm.framework.TestBaseTest;
import comm.pageobject.zestmoney.assigment3.Amazon.AmazonHomePage;
import comm.pageobject.zestmoney.assigment3.FlipKart.FlipkartHomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipkartHomeTest extends TestBaseTest {

    public static FlipkartHomePage flipkartHomePage;

    @BeforeTest
    public void initialSetpUp() {
        initialSetup("url2");
        flipkartHomePage = new FlipkartHomePage(getdriver());
    }

    /*  @AfterClass
       public static void closeAfterTest(){
          if(driver != null){
              Logger.info("Closing the WebDriver");
              driver.close();
              driver.quit();
          }
      }*/
    @Test
    public static void verifyMobileSearch(){
        flipkartHomePage.verifyMobileSearch();
    }
}
