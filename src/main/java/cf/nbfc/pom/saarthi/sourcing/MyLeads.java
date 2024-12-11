package cf.nbfc.pom.saarthi.sourcing;

import cf.nbfc.base.BaseClass;
import cf.nbfc.util.ActionUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * @author Raghu Prasad
 */
public class MyLeads extends BaseClass {
    public ActionUtil actionUtil = new ActionUtil();
    @FindBy(xpath = "//button[@type='button']/ancestor::div[@class=\"lead_management_Search-module__search___INfwv\"]")
    private WebElement searchIcon;

    @FindBy(xpath = "//div[text()='Add New Lead']")
    private WebElement addNewLead;

    @FindBy(xpath = "//span[text()='Phone Number']/following::input[@name='phoneNo']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//span[text()='Product Type']/following::div[@name='productType']")
    private WebElement productTypeDropdown;

    @FindBy(xpath = "//div[title=\"Used Cars\"]")
    private WebElement usedCars;
    @FindBy(xpath = "//div[title=\"Refinance Used Cars\"]")
    private WebElement refinanceUsedCars;

    @FindBy(xpath = "//div[text()='Request consent']")
    private WebElement requestConsent;
    @FindBy(xpath = "//div[text()='Proceed']")
    private WebElement proceed;

    public MyLeads() {
        PageFactory.initElements(driver, this);
    }


    public void clickOnAddNewLead() {
        try {
            addNewLead.click();
            log.atInfo().log("successfully clicked on " + addNewLead);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterPhoneNumber(String customerPhoneNumber) {
        try {
            phoneNumber.sendKeys(customerPhoneNumber);
            log.atInfo().log("successfully entered " + addNewLead + " into " + phoneNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectProductType(String productType) {
        productTypeDropdown.click();
        try {
            if (productType.equalsIgnoreCase("Used Cars")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='rc-virtual-list']//div[text()='" + productType + "']")));
                driver.findElement(By.xpath("//div[@class='rc-virtual-list']//div[text()='" + productType + "']")).click();
                log.atInfo().log("clicked on " + usedCars);
            } else if (productType.equalsIgnoreCase("Refinance Used Cars")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='rc-virtual-list']//div[text()='" + productType + "']")));
                driver.findElement(By.xpath("//div[@class='rc-virtual-list']//div[text()='" + productType + "']")).click();
                log.atInfo().log("clicked on " + refinanceUsedCars);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("failed to select product type " + productType);
        }
    }

    public void clickOnRequestConsent() {
        try {
            actionUtil.scrollByGivenAmount(driver,requestConsent);
            requestConsent.click();
            log.atInfo().log("clicked on " + requestConsent);
        } catch (Exception e) {
            Assert.fail("failed to click on " + requestConsent);
            e.printStackTrace();
        }

    }
    public void enterOTP(){
        actionUtil.enterOTP(driver);
    }

    public BasicDetails clickOnProceed(){
        try {
            proceed.click();
            log.atInfo().log("clicked on "+proceed);
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail("failed to click on "+proceed);
        }
        return new BasicDetails();
    }


    public void selectChannel(String channel) {
        try {
            if (channel.equalsIgnoreCase("D2C")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='" + channel + "']")));
                driver.findElement(By.xpath("//label[text()='" + channel + "']")).click();
            } else if (channel.equalsIgnoreCase("DCF")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='" + channel + "']")));
                driver.findElement(By.xpath("//label[text()='" + channel + "']")).click();
            } else if (channel.equalsIgnoreCase("C2C")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='" + channel + "']")));
                driver.findElement(By.xpath("//label[text()='" + channel + "']")).click();
            } else if (channel.equalsIgnoreCase("BT")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='" + channel + "']")));
                driver.findElement(By.xpath("//label[text()='" + channel + "']")).click();
            } else if (channel.equalsIgnoreCase("LAC")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='" + channel + "']")));
                driver.findElement(By.xpath("//label[text()='" + channel + "']")).click();
            }
            log.atInfo().log("selected channel " + channel);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("failed to select channel  " + channel);
        }
    }

}
