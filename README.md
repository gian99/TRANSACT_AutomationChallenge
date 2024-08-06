# TRANSACT AutomationChallenge

For both challenges, we use config.properties to parameterize the values we are going to use in the selenium Test Challenge and in the API Test Challenge

## For the First Selenium UI Test Challenge, we create:  

- DriverFactory.java (to use the method getInstance and do not initializate the browser multiple times)  

- BasePage.java (With Basic Methods like waitUntilElementVisible, isElementVisible, elementClick, sendElementText)  

- SalesPage.java (with All the locators defined in the evershop Excercise and some methods to interact with the shopping flow)

- BaseTest.java (to setup and tearDown the driver using DriverFactory.java class created)

- TransactSeleniumTest.java (using the BaseTest, we create the @test testSelenium extending with the methods also defined in salesPage, to interact with DOM elements and do the complete shopping flow)

- I use TestNG for Assertions, validate the data registered agains the data shown in the Complete Shopping Order


## For the Second API Test Challenge, we create:

- TransactAPITest.java (we use the config.Properties to configure the URL and the access_key for the API Testing)

- I implemented the getAllCountries method, to get all the Countries information, then validate the response code
- I implemented the getCountriesInfoByAlphaCode method, to get information by any country consulted in the API Service using the alpha code, also validating the response code
- I implemented the getUnexistingCountriesInfoByAlphaCode method, to try to get information for countries consulted that don't exist, so i validate the response code to match 404 Not found
- Finally I implemented the additionCountryUsingPost method, to try to add a Country Information through the API service, and method is not allowed so i validate again the response code to match 404 Not found 
