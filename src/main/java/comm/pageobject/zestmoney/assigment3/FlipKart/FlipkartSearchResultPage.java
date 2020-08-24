package comm.pageobject.zestmoney.assigment3.FlipKart;

import comm.elementlocator.ConstantXpath;
import comm.framework.Constants;
import comm.framework.JsonCreator;
import comm.framework.TestBasePage;
import comm.pageobject.zestmoney.assigment3.Amazon.AmazonHomePage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.util.Set;

public class FlipkartSearchResultPage extends TestBasePage {
    private static WebDriver driver;

    public FlipkartSearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    protected static WebElement getMobileHeader(){
        return findByXpath(ConstantXpath.FLIPKART_SEARCH_HEADER);
    }
    protected static WebElement getMobilePrice(){
        return findByXpath(ConstantXpath.FLIPKART_MOBILE_PRICE);
    }
    public void moveToSearchResult(){
        FlipkartHomePage flipkartHomePage = new FlipkartHomePage(driver);
        flipkartHomePage.verifyMobileSearch();
        staticWait(Constants.STATIC_WAIT_2);
    }
    public void verifyMobile(){
        String parentWindow = driver.getWindowHandle();
        getMobileHeader().click();
        Set<String> hashCodeWindow = driver.getWindowHandles();
        for (String input : hashCodeWindow){
            if(!(input.equals(parentWindow))){
                driver.switchTo().window(input);
                // System.out.println(findByXpath("").getText());
                JsonCreator.jsonFile
                        ("flipkart",
                                getMobilePrice()
                                        .getText()
                                        .replace("₹","")
                                        .replace(",",""));
            }
        }
    }

    public void verifyPriceComparison(){
        int amazonPrice = jsonReader("amazon");
        int flipkartPrice = jsonReader("flipkart");
        if(amazonPrice>flipkartPrice){
            seleniumAlert("Hello I am Selenium Pop-Up. The price of the flipkart is less as compare to Amazon" +
                    " and the price of Flipkart is ₹ " + flipkartPrice);
        }else {
            seleniumAlert("The price of the Amazon is less as compare to Flipkart " +
                    "and the price of the Amazon is ₹ " + flipkartPrice);
        }
    }
    public static int jsonReader(String fileName) {
        int priceValue = 0;
        if(fileName.equals("amazon")){
            priceValue = amazon();
        }else if(fileName.equals("flipkart")){
            priceValue = filpkart();
        }
        return priceValue;
    }

    public static int filpkart(){
        int finalPrice = 0;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("resources/flipkart.json"));
            JSONObject jsonObject = (JSONObject) obj;
            finalPrice = Integer.parseInt((String) jsonObject.get("flipkart"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalPrice;
    }

    public static int amazon(){
        int finalPrice = 0;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("resources/amazon.json"));
            JSONObject jsonObject = (JSONObject) obj;
            finalPrice = Integer.parseInt((String) jsonObject.get("amazon"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalPrice;
    }
}
