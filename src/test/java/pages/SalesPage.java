package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SalesPage extends BasePage {


    public SalesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[contains(@class,'icon-wrapper')]//div[3]/a")
    public WebElement loginIcon;

    @FindBy(xpath = "//div[contains(@class,'login-form-inner')]/div/a")
    public WebElement createAccountIcon;

    @FindBy(xpath = "//form//div/input[contains(@name,'full_name')]")
    public WebElement fullNamebox;

    @FindBy(xpath = "//form//div/input[contains(@name,'email')]")
    public WebElement emailBox;

    @FindBy(xpath = "//form//div/input[contains(@name,'password')]")
    public WebElement passwordBox;

    @FindBy(xpath = "//form//button[contains(@type,'submit')]")
    public WebElement signupButton;

    @FindBy(xpath = "//main/div[2]//span[text()='Shop men']")
    public WebElement shopMenButton;

    @FindBy(xpath = "//div[contains(@class,'listing-tem')][1]//a")
    public WebElement shopItem1;

    @FindBy(xpath = "//div[contains(@class,'listing-tem')][2]//a")
    public WebElement shopItem2;

    @FindBy(xpath = "//div[contains(@class,'listing-tem')][3]//a")
    public WebElement shopItem3;

    @FindBy(xpath = "//input[contains(@name,'qty')]")
    public WebElement quantityBox;

    @FindBy(xpath = "//ul[contains(@class,'variant-option-list')]//a[text()='S']")
    public WebElement sizeSButton;

    @FindBy(xpath = "//ul[contains(@class,'variant-option-list')]//a[text()='M']")
    public WebElement sizeMButton;

    @FindBy(xpath = "//ul[contains(@class,'variant-option-list')]//a[text()='L']")
    public WebElement sizeLButton;

    @FindBy(xpath = "//ul[contains(@class,'variant-option-list')]//a[text()='X']")
    public WebElement sizeXButton;

    @FindBy(xpath = "//ul[contains(@class,'variant-option-list')]//a[text()='Green']")
    public WebElement greenColorButton;

    @FindBy(xpath = "//ul[contains(@class,'variant-option-list')]//a[text()='Black']")
    public WebElement blackColorButton;

    @FindBy(xpath = "//ul[contains(@class,'variant-option-list')]//a[text()='Pink']")
    public WebElement pinkColorButton;

    @FindBy(xpath = "//button/span[text()='ADD TO CART']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//div/a[text()='Continue Shopping']")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//main/div//a[text()='Men']")
    public WebElement goToShopMenPageButton;

    @FindBy(xpath = "//div[contains(@class,'toast-mini-cart')]/a[contains(@class,'add-cart-popup-button')]")
    public WebElement viewCartButton;


    @FindBy(xpath = "//div[contains(@class,'loading-bar') and contains(@style,'block')]")
    public WebElement loadingBar;

    @FindBy(xpath = "//div[contains(@class,'shopping-cart')]//span[text()='CHECKOUT']")
    public WebElement checkoutPagebutton;

    @FindBy(xpath = "//div[contains(@class,'form-field-container')]//input[contains(@placeholder,'Full name')]")
    public WebElement checkoutFullNameBox;

    @FindBy(xpath = "//div[contains(@class,'form-field-container')]//input[contains(@placeholder,'Telephone')]")
    public WebElement checkoutTelephoneBox;

    @FindBy(xpath = "//div[contains(@class,'form-field-container')]//input[contains(@placeholder,'Address')]")
    public WebElement checkoutAddresssBox;

    @FindBy(xpath = "//div[contains(@class,'form-field-container')]//input[contains(@placeholder,'City')]")
    public WebElement checkoutCityBox;

    @FindBy(xpath = "//div[contains(@class,'form-field-container')]//select[contains(@placeholder,'Country')]")
    public WebElement checkoutCountryBox;

    @FindBy(xpath = "//div[contains(@class,'form-field-container')]//select[contains(@placeholder,'Province')]")
    public WebElement checkoutProvinceBox;

    @FindBy(xpath = "//div[contains(@class,'form-field-container')]//input[contains(@placeholder,'Postcode')]")
    public WebElement checkoutPostcodeBox;

    @FindBy(xpath = "//div[contains(@class,'form-submit')]/button")
    public WebElement continuePaymentButton;

    @FindBy(xpath = "//div[contains(@class,'shipping-methods')]//div[contains(@class,'radio-field')]/div[1]//span[contains(@class,'radio')]")
    public WebElement standarDeliveryButton;

    @FindBy(xpath = "//div[contains(@class,'shipping-methods')]//div[contains(@class,'radio-field')]/div[2]//span[contains(@class,'radio')]")
    public WebElement expressDeliveryButton;

    @FindBy(xpath = "//form[contains(@id,'checkoutPaymentForm')]//div[contains(@class,'divide-y border')]/div[3]//a")
    public WebElement visaSelectButton;

    @FindBy(xpath = "//form[contains(@id,'checkoutPaymentForm')]//div[contains(@class,'stripe-form')]//div[contains(@class,'text-sm')]")
    public static List<WebElement> visaCardInformation;

    @FindBy(xpath = "//div[contains(@class,'CardField-input-wrapper')]//input[contains(@autocomplete,'cc-number')]")
    public WebElement cardNumberBox;

    @FindBy(xpath = "//div[contains(@class,'CardField-input-wrapper')]//input[contains(@autocomplete,'cc-exp')]")
    public WebElement expiryDateCardNumberBox;

    @FindBy(xpath = "//div[contains(@class,'CardField-input-wrapper')]//input[contains(@autocomplete,'cc-csc')]")
    public WebElement cvcCardNumberBox;

    @FindBy(xpath = "//div[contains(@class,'form-submit-button')]//button")
    public WebElement placeOrderBox;

    @FindBy(xpath = "//div[contains(@class,'checkout-success-customer-info')]")
    public WebElement customerSuccessCheckout;

    @FindBy(xpath = "//div[contains(@class,'customer-info')]//div[contains(@class,'address__summary')]/div[contains(@class,'full-name')]")
    public WebElement shippingAddress_fullName;

    @FindBy(xpath = "//div[contains(@class,'customer-info')]//div[contains(@class,'address__summary')]/div[contains(@class,'address-one')]")
    public WebElement shippingAdress_completeAddress;

    @FindBy(xpath = "//div[contains(@class,'customer-info')]//div[contains(@class,'address__summary')]/div[contains(@class,'telephone')]")
    public WebElement shippingAdress_telephone;

    @FindBy(xpath = "//div[contains(@class,'customer-info')]//div[contains(@class,'address__summary')]/div[contains(@class,'city-province-postcode')]/div[1]")
    public WebElement shippingAdress_city;

    @FindBy(xpath = "//div[contains(@class,'customer-info')]//div[contains(@class,'address__summary')]/div[contains(@class,'city-province-postcode')]/div[2]")
    public WebElement shippingAdress_country;

    public String getShippingCountry(){
        String[] splitText = shippingAdress_country.getText().split(",");
        return splitText[1];
    }

    public String getShippingProvince(){
        String[] splitText = shippingAdress_country.getText().split(",");
        return splitText[0];
    }

    public String getShippingPostCode(){
        String[] splitText = shippingAdress_city.getText().split(",");
        return splitText[0];
    }

    public String getShippingCity(){
        String[] splitText = shippingAdress_city.getText().split(",");
        return splitText[1];
    }
    public void selectCountry(String text){
        Select dropdown = new Select(checkoutCountryBox);
        dropdown.selectByVisibleText(text);
    }

    public void selectProvince(String text){
        Select dropdown = new Select(checkoutProvinceBox);
        dropdown.selectByVisibleText(text);
    }

    public static String getCardNumber(){
        String cardRow = visaCardInformation.get(0).getText();
        System.out.println(cardRow);
        String[] splitText = cardRow.split(": ");
        return splitText[1];
    }

    public static String getExpiryDate(){
        String cardRow = visaCardInformation.get(1).getText();
        System.out.println(cardRow);
        String[] splitText = cardRow.split(": ");
        String date =  splitText[1];
        return validateAndUpdateDate(date);
    }

    public static String getCVC(){
        String cardRow = visaCardInformation.get(2).getText();
        System.out.println(cardRow);
        String[] splitText = cardRow.split(": ");
        return splitText[1];
    }


    public static String validateAndUpdateDate(String fechaTexto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        YearMonth registeredDate;

        try {
            registeredDate = YearMonth.parse(fechaTexto, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("No Valid Date Format. Use MM/yy.");
        }

        YearMonth fechaActual = YearMonth.now();

        if (registeredDate.isBefore(fechaActual)) {
            registeredDate = registeredDate.plusMonths(1);
        }

        return registeredDate.format(formatter);
    }





}
