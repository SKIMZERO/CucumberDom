package test.runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.pageObject.IndexObjectsPage;
import test.pageObject.IndexPageSteps;

public class RunnerTest{

    public WebDriver driver;
    protected String url = "http://demo.automationtesting.in/Index.html";

//    IndexObjectsPage indexObjectsPage = new IndexObjectsPage();

    IndexPageSteps indexPageSteps = new IndexPageSteps();

    @BeforeTest
    public void SetUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test(priority = 1, description = "Login")
    void goUrl() throws InterruptedException {
        indexPageSteps.Login(driver);
        Thread.sleep(5000);
    }

    @Test(priority = 2, description = "Login")
    void FillRegister() throws InterruptedException {
        indexPageSteps.Login(driver);
        Thread.sleep(5000);
    }

    @AfterTest
    public void shutUp(){
        driver.close();
    }
}
