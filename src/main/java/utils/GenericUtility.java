package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.WebTestBase;
import java.time.Duration;
import java.util.Set;

public class GenericUtility extends WebTestBase {

    public static final long IMPLICIT_WAIT = 20;
    public static final long PAGE_LOAD_WAIT = 20;


    public static void mouseHoverOnElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void scrollDownByElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

    }

    public static void waitUntilElementToBeClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void scrollDownByPixel() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50)");
    }


    public static void getWindowHandles() {
        String parentId = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        for (String s : allWindow) {
            if (!parentId.contentEquals(s)) {
                driver.switchTo().window(s);
                driver.close();
            }
            driver.switchTo().window(parentId);
        }
    }
}



