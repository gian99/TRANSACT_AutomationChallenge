package testCases;

import org.json.JSONObject;
import org.testng.annotations.Test;
import config.Properties;

import static io.restassured.RestAssured.given;
import io.qameta.allure.*;

public class TransactAPITest {

    /* Notes: i was trying to use the http://api.countrylayer.com/v2/ and it worked correctly with the access code
    * but i receive repeatedly error 429 reach limit exceeded when i run multiple test
    * and i Changed the config.properties to use the https://restcountries.com/v3.1/ API instead */

    @Severity(SeverityLevel.CRITICAL)
    @Owner("GiancarloAguado")
    @Description("This test to get All Countries from the API restcountries")
    @Test (priority = 1,groups = {"Transact"})
    void getAllCountries()
    {
        given()
                .queryParam("access_key", Properties.getConfig().accessKey())
                .when().get(Properties.getConfig().baseURL()+"all")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Owner("GiancarloAguado")
    @Description("This test is to get information for a Country from the API restcountries using the alpha CODE")
    @Test (priority = 2,groups = {"Transact"})
    void getCountriesInfoByAlphaCode(){
        getIndividualCountry("US",200);
        getIndividualCountry("DE",200);
        getIndividualCountry("GB",200);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Owner("GiancarloAguado")
    @Description("This test is to get information for an unexisting Country from the API restcountries using the alpha CODE")
    @Test (priority = 3,groups = {"Transact"})
    void getUnexistingCountriesInfoByAlphaCode(){
        getIndividualCountry("ABC",404);
        getIndividualCountry("ZIP",404);
        getIndividualCountry("YYY",404);
    }

    void getIndividualCountry(String country, int responseCode)
    {
        given()
                .queryParam("access_key", Properties.getConfig().accessKey())
                .log().all()
                .when()
                .get(Properties.getConfig().baseURL()+"alpha/"+country)
                .then()
                .log().all()
                .statusCode(responseCode);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Owner("GiancarloAguado")
    @Description("This test to register a new Country in the API Countrylayer, using a POST method")
    @Test (priority = 4,groups = {"Transact"})
    void additionCountryUsingPost()
    {
        JSONObject data= new JSONObject();
        data.put("name","US");
        data.put("alpha2_code","TC");
        data.put("alpha3_code","TCY");

        given()
                .queryParam("access_key", Properties.getConfig().accessKey())
                .contentType("Application/json")
                .body(data.toString())
                .log().all()
                .when()
                .post(Properties.getConfig().baseURL()+"add")
                .then()
                .log().all()
                .statusCode(404);
    }

}
