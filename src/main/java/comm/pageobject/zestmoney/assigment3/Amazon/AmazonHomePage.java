package comm.pageobject.zestmoney.assigment3.Amazon;

import comm.elementlocator.ConstantXpath;
import comm.framework.Constants;
import comm.framework.TestBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AmazonHomePage extends TestBasePage {

    public static WebDriver driver;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }
    protected static WebElement getSearchBox(){
        return findByXpath(ConstantXpath.AMAZON_SEARCH_BOX);
    }
    protected static WebElement getSubmitIcon(){
        return findByXpath(ConstantXpath.AMAZON_SUBMIT_ICON);
    }

    public void verifyMobileSearch(){
        Assert.assertTrue(getSearchBox().isDisplayed());
        getSearchBox().sendKeys(Constants.XR_BLUE);
        getSubmitIcon().click();
    }
}
