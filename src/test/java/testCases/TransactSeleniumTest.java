package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.qameta.allure.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.Properties;
import pages.SalesPage;
import org.testng.Assert;

public class TransactSeleniumTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(TransactSeleniumTest.class);

    @Severity(SeverityLevel.CRITICAL)
    @Owner("GiancarloAguado")
    @Description("This test the complete flow of a 3 item shopping in evershop.io")
    @Test(groups = {"Transact"})
    private void testSelenium() throws InterruptedException {
        logger.info("Iniciando Test de Selenium de Transact");
        driver.get(Properties.getConfig().url());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        SalesPage salesPage = new SalesPage(driver);
        salesPage.elementClick(salesPage.loginIcon);
        //I click on create a new account
        salesPage.waitUntilElementVisible(salesPage.createAccountIcon);
        salesPage.elementClick(salesPage.createAccountIcon);
        salesPage.waitUntilElementVisible(salesPage.signupButton);
        //I fill the details of the new account
        salesPage.sendElementText(salesPage.fullNamebox,Properties.getConfig().fullName());
        salesPage.sendElementText(salesPage.emailBox,Properties.getConfig().email());
        salesPage.sendElementText(salesPage.passwordBox,Properties.getConfig().password());
        salesPage.elementClick(salesPage.signupButton);
        //I go to the Men's category to start shopping
        salesPage.waitUntilElementVisible(salesPage.shopMenButton);
        salesPage.elementClick(salesPage.shopMenButton);


        //CI buy the First Item
        salesPage.waitUntilElementVisible(salesPage.shopItem1);
        salesPage.elementClick(salesPage.shopItem1);
        salesPage.quantityBox.clear();
        salesPage.sendElementText(salesPage.quantityBox,"2");
        salesPage.elementClick(salesPage.sizeSButton);
        wait.until(ExpectedConditions.invisibilityOf(salesPage.loadingBar));
        salesPage.elementClick(salesPage.blackColorButton);
        wait.until(ExpectedConditions.invisibilityOf(salesPage.loadingBar));
        salesPage.waitUntilElementVisible(salesPage.addToCartButton);
        wait.until(ExpectedConditions.elementToBeClickable(salesPage.addToCartButton));
        salesPage.elementClick(salesPage.addToCartButton);
        salesPage.elementClick(salesPage.continueShoppingButton);
        salesPage.elementClick(salesPage.goToShopMenPageButton);

        //I buy the Second Item
        salesPage.waitUntilElementVisible(salesPage.shopItem2);
        salesPage.elementClick(salesPage.shopItem2);
        salesPage.quantityBox.clear();
        salesPage.sendElementText(salesPage.quantityBox,"1");
        salesPage.elementClick(salesPage.sizeXButton);
        wait.until(ExpectedConditions.invisibilityOf(salesPage.loadingBar));
        salesPage.elementClick(salesPage.pinkColorButton);
        wait.until(ExpectedConditions.invisibilityOf(salesPage.loadingBar));
        salesPage.waitUntilElementVisible(salesPage.addToCartButton);
        wait.until(ExpectedConditions.elementToBeClickable(salesPage.addToCartButton));
        salesPage.elementClick(salesPage.addToCartButton);
        salesPage.elementClick(salesPage.continueShoppingButton);
        salesPage.elementClick(salesPage.goToShopMenPageButton);

        //I buy the third Item
        salesPage.waitUntilElementVisible(salesPage.shopItem3);
        salesPage.elementClick(salesPage.shopItem3);
        salesPage.quantityBox.clear();
        salesPage.sendElementText(salesPage.quantityBox,"3");
        salesPage.elementClick(salesPage.sizeLButton);
        wait.until(ExpectedConditions.invisibilityOf(salesPage.loadingBar));
        salesPage.elementClick(salesPage.greenColorButton);
        wait.until(ExpectedConditions.invisibilityOf(salesPage.loadingBar));
        salesPage.waitUntilElementVisible(salesPage.addToCartButton);
        wait.until(ExpectedConditions.elementToBeClickable(salesPage.addToCartButton));
        salesPage.elementClick(salesPage.addToCartButton);
        salesPage.elementClick(salesPage.viewCartButton);

        //I start the checkout of the items selected
        salesPage.elementClick(salesPage.checkoutPagebutton);
        salesPage.sendElementText(salesPage.checkoutFullNameBox,Properties.getConfig().fullName());
        salesPage.sendElementText(salesPage.checkoutTelephoneBox,Properties.getConfig().telephone());
        salesPage.sendElementText(salesPage.checkoutAddresssBox,Properties.getConfig().address());
        salesPage.sendElementText(salesPage.checkoutCityBox,Properties.getConfig().city());
        salesPage.selectCountry(Properties.getConfig().country());
        salesPage.sendElementText(salesPage.checkoutPostcodeBox,Properties.getConfig().postcode());
        salesPage.waitUntilElementVisible(salesPage.checkoutProvinceBox);
        wait.until(ExpectedConditions.elementToBeClickable(salesPage.checkoutProvinceBox));
        salesPage.selectProvince(Properties.getConfig().province());

        //For the  payment information, i set the standar delivery and i continue with the shopping process
        salesPage.elementClick(salesPage.standarDeliveryButton);
        salesPage.elementClick(salesPage.continuePaymentButton);

        //I select Visa as a payment method
        salesPage.waitUntilElementVisible(salesPage.visaSelectButton);
        salesPage.elementClick(salesPage.visaSelectButton);

        //I wait for the card test information to show in the sales Pageg
        salesPage.waitUntilElementVisible(salesPage.cardNumberBox);
        salesPage.waitUntilElementVisible(salesPage.expiryDateCardNumberBox);
        salesPage.waitUntilElementVisible(salesPage.cvcCardNumberBox);

        //I complete the payment card information
        salesPage.sendElementText(salesPage.cardNumberBox,SalesPage.getCardNumber());
        salesPage.sendElementText(salesPage.expiryDateCardNumberBox,SalesPage.getExpiryDate());
        salesPage.sendElementText(salesPage.cvcCardNumberBox,SalesPage.getCVC());

        //I place the order with all the details completed
        salesPage.elementClick(salesPage.placeOrderBox);

        //I validate with Assestions that the shopping process was successfull and i verify that the info registered Match the info shown in Page
        Assert.assertTrue(salesPage.customerSuccessCheckout.isDisplayed(), "La orden no fue registrada con Exito");
        Assert.assertEquals(salesPage.shippingAddress_fullName.getText(), Properties.getConfig().fullName(), "El Shipping fullName de la Order y el registrado no son iguales.");
        Assert.assertEquals(salesPage.shippingAdress_completeAddress.getText(), Properties.getConfig().address(), "El Shipping Address de la Order y el registrado no son iguales.");
        Assert.assertEquals(salesPage.shippingAdress_telephone.getText(), Properties.getConfig().telephone(), "El Shipping telephone de la Order y el registrado no son iguales.");
        Assert.assertEquals(salesPage.getShippingCountry(), Properties.getConfig().country(), "El Shipping Country de la Order y el registrado no son iguales.");
        Assert.assertEquals(salesPage.getShippingProvince(), Properties.getConfig().province(), "El Shipping Province de la Order y el registrado no son iguales.");
        Assert.assertEquals(salesPage.getShippingCity(), Properties.getConfig().city(), "El Shipping City de la Order y el registrado no son iguales.");
        Assert.assertEquals(salesPage.getShippingPostCode(), Properties.getConfig().postcode(), "El Shipping Postcode de la Order y el registrado no son iguales.");

    }

}
