package RutinasComunes;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;


public class ScreenShot {

    public void captureScreenShot(WebDriver driver, int StepNumber, String Description) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./ScreenShot/ScreenShot/" + "Paso" + StepNumber +
                    "." + Description + ".png"));
            System.out.println("**********************************+***+");
            System.out.println("ScreenShot taken");
            System.out.println("**********************************+***+");

        } catch (Exception e) {
            System.out.println("**********************************+***+");
            System.out.println("ScreenShot failed");
            System.out.println("**********************************+***+");

        }
    }

    public static void stepScreenShot(WebDriver driver, int numeroPaso) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./ScreenShot/StepScreenshot/" + numeroPaso + ".png"));
            System.out.println("**********************************+***+");
            System.out.println("ScreenShot taken");
            System.out.println("**********************************+***+");

        } catch (Exception e) {
            System.out.println("**********************************+***+");
            System.out.println("ScreenShot failed");
            System.out.println("**********************************+***+");
        }
    }

    public static void errorScreenShot(WebDriver driver, int numeroPaso, String temaTitulo, int numeroError) {

        try {
            TakesScreenshot ts3 = (TakesScreenshot) driver;
            File source = ts3.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./ScreenShot/ErrorScreenshot/" + "Paso" + numeroPaso +
                    "." + temaTitulo + ".Error" + numeroError + ".png"));
            System.out.println("**********************************+***+");
            System.out.println("ScreenShot taken");
            System.out.println("**********************************+***+");
        } catch (Exception e) {
            System.out.println("**********************************+***+");
            System.out.println("ScreenShot failed");
            System.out.println("**********************************+***+");
        }
    }

    public void addingScreenShotAllure(WebDriver driver) {
        try {
            Allure.addAttachment("Screenshot has been added", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            System.out.println("**********************************+***+");
            System.out.println("Screenshot has been added successfully on Allure");
            System.out.println("**********************************+***+");

        } catch (Exception e) {
            System.out.println("**********************************+***+");
            System.out.println("The screenshot has not been added");
            System.out.println("**********************************+***+");
        }
    }


    public void takeFullPageScreenShot(WebDriver driver){
        try{
        Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS,500,true).withName("EstaESUnaPruebaDeSS").save("./ScreenShot/FullScreenshot/");
            System.out.println("**********************************+***+");
            System.out.println("Full ScreenShot taken");
            System.out.println("**********************************+***+");
        } catch (Exception e) {
            System.out.println("**********************************+***+");
            System.out.println("Full ScreenShot failed");
            System.out.println("**********************************+***+");
        }
    }
  /*  public static void  addingScreenShotPDF(WebDriver driver, int numeroPaso, String temaTitulo){
        try {
            com.itextpdf.text.Image q = Image.getInstance("./ScreenShot/ScreenShot/" + "Paso" + numeroPaso +
                    "." + temaTitulo + ".jpg");
            q.scaleToFit(100, 100);
            q.setAlignment(Chunk.ALIGN_MIDDLE);
            System.out.println("**********************************+***+");
            System.out.println("The screenshot has been added on PDF");
            System.out.println("**********************************+***+");

        } catch (Exception e) {
            System.out.println("**********************************+***+");
            System.out.println("The screenshot has not been added on PDF");
            System.out.println("**********************************+***+");
        }
    }*/
}
