package test.pageObject;

import com.sun.deploy.cache.BaseLocalApplicationProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import test.runner.RunnerTest;

public class IndexObjectsPage{

    String email = "correo@correo.com";
    String nombre = "correo@correo.com";
    String apellido = "correo@correo.com";
    String animal = "correo@correo.com";

    private By emailID = By.xpath("//*[@id='email']");
    private By click = By.xpath("//a[@href='Register.html']");
    private By signUp = By.xpath("//*[@id='email']");

    public void Text(WebDriver driver){
        driver.findElement(emailID).sendKeys(email);
    }

    public void Click(WebDriver driver){
        driver.findElement(emailID).click();
    }

    public void ClickSignOn(WebDriver driver){
        driver.findElement(emailID).click();
    }
}
