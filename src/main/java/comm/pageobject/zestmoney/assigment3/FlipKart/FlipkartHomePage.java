package comm.pageobject.zestmoney.assigment3.FlipKart;

import comm.elementlocator.ConstantXpath;
import comm.framework.Constants;
import comm.framework.TestBasePage;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.yaml.snakeyaml.scanner.Constant;

public class FlipkartHomePage extends TestBasePage {
    private static WebDriver driver;

    public FlipkartHomePage(WebDriver driver) {
        this.driver = driver;
    }

    protected static WebElement getFlipKartSearch(){
        return findByXpath(ConstantXpath.FLIPKART_SEARCH_BOX);
    }
    protected static WebElement getSubmitButton(){
        return findByXpath(ConstantXpath.FLIPKART_SEARCH_BUTTON);
    }
    protected static WebElement getLoginCancellButton(){
        return findByXpath(ConstantXpath.FLIPKART_LOGIN_X);
    }
    public void verifyMobileSearch(){
        if(getLoginCancellButton().isDisplayed()){
            getLoginCancellButton().click();
        }
        Assert.assertTrue(getFlipKartSearch().isDisplayed());
        getFlipKartSearch().sendKeys(Constants.XR_BLUE);
        getSubmitButton().click();
    }
}
