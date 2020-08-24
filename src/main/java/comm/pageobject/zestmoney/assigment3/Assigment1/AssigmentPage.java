package comm.pageobject.zestmoney.assigment3.Assigment1;

import comm.framework.JsonCreator;
import comm.framework.TestBasePage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import java.io.FileReader;

public class AssigmentPage extends TestBasePage {

   public void verifyPriceComparison(){
       int amazonPrice = jsonReader("amazon");
       int flipkartPrice = jsonReader("flipkart");
        if(amazonPrice>flipkartPrice){
            seleniumAlert("The price of the flipkart is less as compare to Amazon" +
                    " and the price is ₹ " + flipkartPrice);
        }else {
            seleniumAlert("The price of the Amazon is less as compare to Flipkart " +
                    "and the price is ₹ " + flipkartPrice);
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
