package comm.elementlocator;

public class ConstantXpath {
/* Amazon Home page xpath's */
    public static final String AMAZON_SEARCH_BOX="//input[@id='twotabsearchtextbox']";
    public static final String AMAZON_SUBMIT_ICON = "//input[@value='Go']";

/* Amazon Search result Xpath */
    public static final String AMAZON_SEARCH_RESULT_HEADER_LIST = "//a[@class='a-link-normal a-text-normal']//span";

/* Amazon Mobile Details page */
    public static final String AMAZON_MOBILE_PRICE = "//span[@id='priceblock_ourprice']";

/* FlipKart Home page xpath */
    public static final String FLIPKART_LOGIN_X = "//button[@class='_2AkmmA _29YdH8']";
public static final String FLIPKART_SEARCH_BOX ="//input[@placeholder='Search for products, brands and more']";
public static final String FLIPKART_SEARCH_BUTTON = "//input[@placeholder='Search for products, brands and more']" +
        "//..//..//button";
/* Flipkart Search Result */
    public static final String FLIPKART_SEARCH_HEADER= "//div[@class='_3wU53n']";
/* Flipkart Mobile details page */
    public static final String FLIPKART_MOBILE_PRICE = "//div[@class='_1vC4OE _3qQ9m1']";
}
