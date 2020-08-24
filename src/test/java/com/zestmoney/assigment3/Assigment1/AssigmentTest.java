package com.zestmoney.assigment3.Assigment1;

import comm.pageobject.zestmoney.assigment3.Assigment1.AssigmentPage;
import org.testng.annotations.Test;

public class AssigmentTest {
    @Test
    public static void verifyPriceComparison(){
        AssigmentPage assigmentPage = new AssigmentPage();
        assigmentPage.verifyPriceComparison();
    }
}
