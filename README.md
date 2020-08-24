# Selenium Frame Work with Java Details

Page Object model is used.

ElementLocator package is created to declare locators as per "Xpath", "ClassName", & "Id".

FrameWork package is used to methods in top level clases, details are below

 - Constans class is created to declare constand values like chromedriver path, config file path, explicit wait time, etc.
 - Logger class is created to define methods to log the logs in the console without log4js.
 - Message class is used to declare constand message strings like error messages, logger messages etc.
 - OperatingSystemDetector class is used to detect os of the system, so we can take the path of the chrome driver accordingly.
 - TestBasePage is create to define the common used methods linke scroll, wait etc.
 - TestBaseTest is created to initilaze the WebDriver.
 - WebElemnts class is created to define detector method like via xpath,className etc, so we don't need to declare driver.findElements again and again
 
 PageObject pacakge is use to declare class of page elemets
 # Assigment1
