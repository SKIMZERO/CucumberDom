package test.pageObject;

import org.openqa.selenium.WebDriver;

public class IndexPageSteps {

    IndexObjectsPage indexObjectsPage = new IndexObjectsPage();

    public void Login(WebDriver driver){
        System.out.println("Step Text");
        indexObjectsPage.Text(driver);
        System.out.println("Step click");
        indexObjectsPage.Click(driver);
    }

    public void SignUp(WebDriver driver){
        indexObjectsPage.ClickSignOn(driver);
    }
}