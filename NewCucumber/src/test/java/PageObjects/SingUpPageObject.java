package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Year;

public class SingUpPageObject {

    public WebDriver driver;

    public SingUpPageObject(WebDriver driver){
        this.driver = driver;
    }

    private By firstNameTextBox = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input");

    private By lastName = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input");

    private By emailAddress = By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[1]/input");

    private By phone =By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input");

    private By genderMale =By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input");

    private By genderFemale=By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input");

    private By languages =By.xpath("//*[@id=\"msdd\"]");

    private By skills =By.xpath("//*[@id=\"Skills\"]");

    private By country =By.xpath("//*[@id=\"countries\"]");

    private By dateOfBirthYear =By.xpath("//*[@id=\"yearbox\"]");

    private By dateOfBirthMonth=By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select");

    private By dateOfBirthDay=By.xpath("//*[@id=\"daybox\"]");

    private By password =By.xpath("//*[@id=\"firstpassword\"]");

    private By confirmPassword =By.xpath("//*[@id=\"secondpassword\"]");

    private By submit =By.xpath("//*[@id=\"submitbtn\"]/font/font");

    public void go(String url){
        this.driver.get(url);
    }

    public void writeFirstName(String firstName){
        this.driver.findElement(this.firstNameTextBox).sendKeys(firstName);
    }

    public void writeLastName(String lastName){
        this.driver.findElement(this.lastName).sendKeys(lastName);
    }

    public void writeEmailAddress(String email){
        this.driver.findElement(this.emailAddress).sendKeys(email);
    }

    public void writePhone(String phone){
        this.driver.findElement(this.phone).sendKeys(phone);
    }
    public void selectMale(){
        this.driver.findElement(this.genderMale).click();
    }

    public void selectFemale(){
        this.driver.findElement(this.genderFemale).click();
    }

    public void selectLanguages(String languages){
        new Select(this.driver.findElement(this.languages)).selectByValue(languages);
    }

    public void selectSkills(String skills){
        new Select(this.driver.findElement(this.skills)).selectByValue(skills);
    }

    public void selectCountry(String country){
        new Select(this.driver.findElement(this.country)).selectByValue(country);
    }

    public void selectDateOfBirthYear(String year){
        new Select(this.driver.findElement(this.dateOfBirthYear)).selectByValue(year);
    }

    public void selectDateOfBirthMonth(String month){
        new Select(this.driver.findElement(this.dateOfBirthMonth)).selectByValue(month);
    }

    public void selectDateOfBirthDay(String day){
        new Select(this.driver.findElement(this.dateOfBirthDay)).selectByValue(day);
    }

    public void writePassword(String password){
        this.driver.findElement(this.password).sendKeys(password);
    }

    public void writeConfirmPassword(String confirmPassword){
        this.driver.findElement(this.confirmPassword).sendKeys(confirmPassword);
    }

    public void clickSubmit(){
        this.driver.findElement(this.submit).click();
    }
}
