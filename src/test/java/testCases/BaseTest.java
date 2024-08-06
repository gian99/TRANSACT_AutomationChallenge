package testCases;

import config.Properties;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    protected WebDriver driver;
    @Severity(SeverityLevel.CRITICAL)
    @Description("Configuramos el browser con el parametro definido en properties")
    @BeforeMethod(alwaysRun = true)
    public void setup(){
        logger.info("Creando la Instancia del Driver usando el browser como parametro");
        DriverFactory driverFactory = DriverFactory.getInstance();
        driver = driverFactory.createDriver(Properties.getConfig().browser());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Cerramos el browser")
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        logger.info("Cerrando el browser");
        if(driver!=null){
            driver.quit();
        }
    }
}
