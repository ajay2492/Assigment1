package com.zestmoney.assigment3.Amazon;

import comm.framework.Logger;
import comm.framework.TestBaseTest;
import comm.pageobject.zestmoney.assigment3.Amazon.AmazonHomePage;
import comm.pageobject.zestmoney.assigment3.Amazon.AmazonSearchResultPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonSearchResultTest extends TestBaseTest {

    public static AmazonSearchResultPage amazonSearchResultPage;

    @BeforeTest
    public void initialSetpUp() {
        initialSetup("url1");
        this.amazonSearchResultPage = new AmazonSearchResultPage(getdriver());
        amazonSearchResultPage.moveToSearchResult();
    }

    @AfterTest
       public static void closeAfterTest(){
          if(driver != null){
              Logger.info("Closing the WebDriver");
              driver.close();
              driver.quit();
          }
      }
    @Test(priority = 1)
    public static void verifyMobile(){
        amazonSearchResultPage.verifyMobile();
    }
}
