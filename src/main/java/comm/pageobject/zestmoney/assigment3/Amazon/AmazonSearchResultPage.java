package comm.pageobject.zestmoney.assigment3.Amazon;

import comm.elementlocator.ConstantXpath;
import comm.framework.Constants;
import comm.framework.JsonCreator;
import comm.framework.TestBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class AmazonSearchResultPage extends TestBasePage {
    public static WebDriver driver;

    public AmazonSearchResultPage(WebDriver inputdriver) {
        this.driver = inputdriver;
    }
    protected static List<WebElement> getSearchResultHeaderList(){
        return findListByXpath(ConstantXpath.AMAZON_SEARCH_RESULT_HEADER_LIST);
    }
    protected static WebElement getPrice(){
        return findByXpath(ConstantXpath.AMAZON_MOBILE_PRICE);
    }

    public void moveToSearchResult(){
        AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
        amazonHomePage.verifyMobileSearch();
        staticWait(Constants.STATIC_WAIT_2);
    }

    public void verifyMobile(){
        String parentWindow = driver.getWindowHandle();
        for (WebElement input : getSearchResultHeaderList()){
            if(input.getText().contains(Constants.XR_BLUE)){
                input.click();
                break;
            }
        }
        Set<String> hashCodeWindow = driver.getWindowHandles();
        for (String input : hashCodeWindow){
            if(!(input.equals(parentWindow))){
                driver.switchTo().window(input);
               // System.out.println(findByXpath("").getText());
                String amazonPrice = getPrice().getText().replace("₹ ","").replace(",","");
                JsonCreator.jsonFile("amazon", amazonPrice.substring(0,amazonPrice.indexOf(".")));
            }
        }
    }
}
