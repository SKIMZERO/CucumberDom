package Steps;

import Base.BaseUtil;
import PageObjects.SingUpPageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class SingUpStepDefs extends BaseUtil {

    private BaseUtil base;

    public SingUpStepDefs(BaseUtil base) {
        this.base = base;
    }

    SingUpPageObject singUpPageObject = new SingUpPageObject(this.driver);

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        singUpPageObject.go("http://demo.automationtesting.in/Register.html");
    }

    @And("^I enter the  following information for the logging$")
    public void iEnterTheFollowingInformationForTheLogging() {
        singUpPageObject.writeFirstName("Pedro");
        singUpPageObject.writeLastName("Alvarez");
        singUpPageObject.writeEmailAddress("dsfghj@dfghjk.com");
        singUpPageObject.writePhone("12345678");
        singUpPageObject.selectMale();
    //    singUpPageObject.selectLanguages("");
        singUpPageObject.selectDateOfBirthDay("11");
        singUpPageObject.selectDateOfBirthMonth("April");
        singUpPageObject.selectDateOfBirthYear("1993");
    //    singUpPageObject.selectSkills("");
        singUpPageObject.writePassword("Hola1234");
        singUpPageObject.writeConfirmPassword("Hola1234");
    }

    @When("^I click login buttom$")
    public void iClickLoginButtom() {
        System.out.println("Exito1");
        singUpPageObject.clickSubmit();
        System.out.println("Exito2");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", driver.findElement(By.xpath("//*[@id=\"submitbtn\"]")), "color yellow; border: 2px solid yellow;");
    }

    @Then("^I should see the Home page$")
    public void iShouldSeeTheHomePage() {
        System.out.println("Exito");

    }

}
