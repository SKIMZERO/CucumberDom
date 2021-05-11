package Test;

import RutinasComunes.Rutinas;
import RutinasComunes.ScreenRecorder;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;


public class E2E{

    public static WebDriver driver;

    String url = "https://www.facebook.com";
    String email = "";
    String pass = "";

    Rutinas test = new Rutinas();


    @BeforeTest
    @Parameters({"URL", "BrowserType"})
    public void setUp(/*String url, String browserType*/) throws  IOException, AWTException{

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        /*
        Lo de abajo puede hacer pruebas en paralelo modificando el XML de TestNG
         */

   /*     if (browserType.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browserType.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browserType.equalsIgnoreCase("Opera")){
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }*/

        ScreenRecorder.startScreenRecording(); //Inicialización de Video Grabación
        driver.manage().window().maximize();
        test.alert(driver);

      }


    @Test (priority = 1, description = "Facebook validation page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Facebook validation page")
    @Story("Facebook")
    @Step("Verify Facebook page")
    void pageVal() throws InterruptedException {
        driver.get(url);
        test.validationPage(driver);
        Thread.sleep(1000);
    }


    @Test (priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Login validation page")
    @Story("Login")
    @Step("Verify Login page")
    void login() throws InterruptedException {
        test.loginValidation(driver, email, pass);
        Thread.sleep(1000);
    }

    @Test (priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Message notification validation page")
    @Story("Message notification")
    void noticationsMessenger () throws InterruptedException {
        test.messageValidation(driver);
        Thread.sleep(1000);
    }

    @Test (priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Publication Notification validation page")
    @Story("Publication notification")
    void notifications () throws InterruptedException {
        test.notificationValidation(driver);
        Thread.sleep(1000);
    }

    @AfterTest
    public void shutUp() throws IOException {
        driver.close();
        ScreenRecorder.stopScreenRecording(); //Finaliza Grabación
    }
}