package RutinasComunes;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Rutinas {

    ScreenShot ScreenShot = new ScreenShot();

    protected String testCase;
    protected int numeroPaso = 0;
    protected int numeroError = 0;
    public WebElement borderElement;
    protected String description;
    protected int numberCase = 0;
    private String Title;

    public Exception alert(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public void borderLine(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", borderElement, "color yellow; border: 2px solid yellow;");

        System.out.println("**********************************+***+");
        System.out.println("Object selected");
        System.out.println("**********************************+***+");
    }

    public void validationPage(WebDriver driver) {

        testCase = "validationPage";
        numeroPaso++;
        numberCase++;

        try {

            Title = driver.getTitle();

            if (Title.contains("Facebook")) {
                description = "Facebook validation page";
                System.out.println("**********************************+***+");
                System.out.println("You are in Facebook");
                System.out.println("**********************************+***+");
            } else {
                System.out.println("**********************************+***+");
                System.out.println("Sorry you have a problem, you are not in Facebook");
                System.out.println("**********************************+***+");
            }

            Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS,500,true).withName("EstaESUnaPruebaDeSS").save(String.valueOf(OutputType.BASE64));
            Thread.sleep(2000);
        //    String scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            //ScreenShot.captureScreenShot(driver, this.numeroPaso, this.testCase);
            ScreenShot.addingScreenShotAllure(driver);

            System.out.println("**********************************+***+");
            Title = "Facebook";
            Assert.assertEquals(driver.getTitle(),Title);
            System.out.println("Title = " + Title);
            System.out.println("**********************************+***+");

        } catch (Exception e) {
            //  ScreenShot.errorScreenShot(driver, this.numeroPasoError , this.temaTitulo);
            System.out.println("**********************************+***+");
            System.out.println("Page can't validate");
            System.out.println("**********************************+***+");
            ScreenShot.addingScreenShotAllure(driver);
        }

    }

    public void loginValidation(WebDriver driver, String email, String pass) {

        testCase = "loginValidation";
        numeroPaso++;

        try {
            WebElement mail = driver.findElement(By.xpath("//*[@id=\"email\"]"));
            mail.sendKeys(email);
            System.out.println("**********************************+***+");
            System.out.println("Email inserted");
            System.out.println("**********************************+***+");

            WebElement password = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
            password.sendKeys(pass);

            System.out.println("**********************************+***+");
            System.out.println("Password inserted");
            System.out.println("**********************************+***+");

            // Aplicar borde en objeto seleccionado
            borderElement = password;
            //Ejecutar
            borderLine(driver);
            ScreenShot.captureScreenShot(driver, this.numeroPaso, this.testCase);
            ScreenShot.addingScreenShotAllure(driver);

            WebElement botonIniciarSesion = driver.findElement(By.xpath("//*[@id=\"u_0_h_1G\"]"));
            botonIniciarSesion.click();
            System.out.println("**********************************+***+");
            System.out.println("Click on session");
            System.out.println("**********************************+***+");

            System.out.println("**********************************+***+");
            Title = driver.getTitle();
            Assert.assertEquals(driver.getTitle(),Title);
            System.out.println("Title = " + Title);
            System.out.println("**********************************+***+");
        } catch (Exception e) {
            System.out.println("**********************************+***+");
            System.out.println("You can't log in");
            System.out.println("Page can't validate");
            System.out.println("**********************************+***+");

            ScreenShot.errorScreenShot(driver, this.numeroPaso, this.testCase, this.numeroError);
            ScreenShot.addingScreenShotAllure(driver);
        }
    }

        public void messageValidation (WebDriver driver) throws InterruptedException {
            testCase = "messageValidation";
            numeroPaso++;

         //   ScreenShot.takeFullPageScreenShot(driver);
         //   Thread.sleep(3000);
            try {

                WebElement notificationMessenger = driver.findElement(By.xpath("//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/" +
                        "div[2]/div[4]/div[1]/div[2]/span/div/div[2]"));
                String numberMessage = notificationMessenger.getText();

                int numMessage = Integer.parseInt(numberMessage);

                if (numMessage >= 1) {
                    System.out.println("**********************************+***+");
                    System.out.println("You have " + numMessage + " messages");
                    System.out.println("**********************************+***+");

                    driver.findElement(By.xpath("//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[2]/div[4]/div[" +
                            "1]/div[2]/span/div")).click();
                    System.out.println("**********************************+***+");
                    System.out.println("Message bottom pushed");
                    System.out.println("**********************************+***+");
                }

                Thread.sleep(10000);
                // Aplicar borde en objeto seleccionado
                borderElement = notificationMessenger;
                //Ejecutoar
                borderLine(driver);
                ScreenShot.captureScreenShot(driver, this.numeroPaso, this.testCase);
                ScreenShot.addingScreenShotAllure(driver);

            } catch (Exception e) {

                numeroError++;

                System.out.println("**********************************+***+");
                System.out.println("You haven't any messages");
                System.out.println("Page validated");
                System.out.println("**********************************+***+");
                ScreenShot.errorScreenShot(driver, this.numeroPaso, this.testCase, this.numeroError);
                ScreenShot.addingScreenShotAllure(driver);
            }
        }

        public void notificationValidation (WebDriver driver){

            testCase = "notificationValidation";
            numeroPaso++;

            try {

                WebElement notification = driver.findElement(By.xpath("//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[2]" +
                        "/div[4]/div[1]/div[1]/span/div/div[2]/span"));
                String numberNotification = notification.getText();

                int numNotification = Integer.parseInt(numberNotification);

                if (numNotification >= 1) {
                    System.out.println("**********************************+***+");
                    System.out.println("You have " + numNotification + " notifications");
                    System.out.println("**********************************+***+");

                    WebElement notificationButtom = driver.findElement(By.xpath("//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[2]/div[4]/div" +
                            "[1]/div[1]/span/div"));
                    notificationButtom.click();
                    System.out.println("**********************************+***+");
                    System.out.println("Message bottom pushed");
                    System.out.println("**********************************+***+");

                    Thread.sleep(10000);
                    // Aplicar borde en objeto seleccionado
                    borderElement = notificationButtom;
                    //Ejecutoar
                    borderLine(driver);
                    ScreenShot.captureScreenShot(driver, this.numeroPaso, this.testCase);

                }

                Thread.sleep(10000);
                // Aplicar borde en objeto seleccionado
                borderElement = notification;
                //Ejecutoar
                borderLine(driver);
                ScreenShot.captureScreenShot(driver, this.numeroPaso, this.testCase);
                ScreenShot.addingScreenShotAllure(driver);

            } catch (Exception e) {

                numeroError++;

                System.out.println("**********************************+***+");
                System.out.println("You haven't any notification");
                System.out.println("Page validated");
                System.out.println("**********************************+***+");
                ScreenShot.errorScreenShot(driver, this.numeroPaso, this.testCase, this.numeroError);
                ScreenShot.addingScreenShotAllure(driver);
            }
    }


}
