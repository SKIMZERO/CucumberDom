package RutinasComunes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scroll {

    public static void porPixel (WebDriver driver, int pixelesHorizontal, int pixelesVertical) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + pixelesHorizontal + "," + pixelesVertical + ")");
    }

    public static void porPixel (WebDriver driver, int pixelesVertical) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixelesVertical + ")");
    }

    public static void porElementoVisible (WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void finalDePagina (WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
}
