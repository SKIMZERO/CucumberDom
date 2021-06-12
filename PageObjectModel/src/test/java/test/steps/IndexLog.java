package test.steps;

import org.openqa.selenium.WebDriver;
import test.pageObject.IndexObjectsPage;

public class IndexLog {

    IndexObjectsPage indexObjectsPage = new IndexObjectsPage();

    public void Login(WebDriver driver){
        indexObjectsPage.Text(driver);
        indexObjectsPage.Click(driver);
    }

    public void SignUp(WebDriver driver){
        indexObjectsPage.ClickSignOn(driver);
    }
}
