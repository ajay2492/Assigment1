package com.zestmoney.assigment3.Amazon;

import comm.framework.TestBaseTest;
import comm.pageobject.zestmoney.assigment3.Amazon.AmazonHomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonHomeTest extends TestBaseTest {

    public static AmazonHomePage amazonHomePage;

    @BeforeTest
    public void initialSetpUp() {
        initialSetup("url1");
        amazonHomePage = new AmazonHomePage(getdriver());
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
       amazonHomePage.verifyMobileSearch();
    }
}
