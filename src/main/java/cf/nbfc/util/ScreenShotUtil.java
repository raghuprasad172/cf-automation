package cf.nbfc.util;

import cf.nbfc.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;

public class ScreenShotUtil extends BaseClass {


    public static String takePageScreenShot(String testMethodName) {
        String dateName = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        String destination = System.getProperty("user.dir") + "/screenshots/" + testMethodName + "_" + dateName + ".png";
        try {
            TakesScreenshot screenShot = (TakesScreenshot) driver;
            FileUtils.copyFile(screenShot.getScreenshotAs(OutputType.FILE), new File(destination));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destination;
    }
}
