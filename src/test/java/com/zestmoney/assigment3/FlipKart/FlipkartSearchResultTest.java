package com.zestmoney.assigment3.FlipKart;

import comm.framework.Logger;
import comm.framework.TestBaseTest;
import comm.pageobject.zestmoney.assigment3.Amazon.AmazonSearchResultPage;
import comm.pageobject.zestmoney.assigment3.Assigment1.AssigmentPage;
import comm.pageobject.zestmoney.assigment3.FlipKart.FlipkartHomePage;
import comm.pageobject.zestmoney.assigment3.FlipKart.FlipkartSearchResultPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipkartSearchResultTest extends TestBaseTest {
    public static FlipkartSearchResultPage flipkartSearchResultPage;

    @BeforeTest
    public void initialSetpUp() {
        initialSetup("url2");
        flipkartSearchResultPage = new FlipkartSearchResultPage(getdriver());
      flipkartSearchResultPage.moveToSearchResult();
    }

   /*  @AfterClass
       public static void closeAfterTest(){
          if(driver != null){
              Logger.info("Closing the WebDriver");
              driver.close();
              driver.quit();
          }
    }*/

    @Test(priority = 1)
    public static void verifyMobile(){
        flipkartSearchResultPage.verifyMobile();
    }
    @Test(priority = 2)
    public static void verifyPriceComparison(){
        flipkartSearchResultPage.verifyPriceComparison();
    }

}
