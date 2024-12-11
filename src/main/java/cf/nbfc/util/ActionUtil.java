package cf.nbfc.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import java.util.Iterator;
import java.util.List;

/**
 * @author Raghu Prasad
 */
public class ActionUtil {


    public void switchToChildWindow(WebDriver driver) {
        try {
            Object[] windowHandles = driver.getWindowHandles().toArray();
            driver.switchTo().window((String) windowHandles[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToParentWindow(WebDriver driver) {
        try {
            Object[] windowHandles = driver.getWindowHandles().toArray();
            driver.switchTo().window((String) windowHandles[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickUsingJavaScriptExecutor(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollUntilElementIsVisible(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollByGivenAmount(WebDriver driver, WebElement element) {
        try {
            int deltaY = element.getRect().y;
            new Actions(driver).scrollByAmount(0, deltaY).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollFromElementByGivenAmount(WebDriver driver, WebElement element) {
        try {
            WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(element);
            new Actions(driver)
                    .scrollFromOrigin(scrollOrigin, 0, 200)
                    .perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterOTP(WebDriver driver) {
        int count = 1;
        try {
            Thread.sleep(1000);
            List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'lead_management_InputOtp')]//input"));
            Iterator<WebElement> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next().sendKeys(Integer.toString(count));
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
