package cf.nbfc.pom.saarthi.generics;

import cf.nbfc.base.BaseClass;
import cf.nbfc.constants.IConstants;
import cf.nbfc.util.ActionUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @author Raghu Prasad
 */
public class LoginPage extends BaseClass {
    public ActionUtil actionUtil = new ActionUtil();
    @FindBy(xpath = "//p[text()='Sign in with Google']/ancestor::button")

    private WebElement signInWithGoogle;

    @FindBy(id = "identifierId")

    private WebElement emailOrPhone;
    @FindBy(name = "Passwd")

    private WebElement enterYourPassword;

    @FindBy(xpath = "//span[text()='Continue']")

    private WebElement continueButton;



    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateLoginButtonIsDisplayed() {
        return signInWithGoogle.isDisplayed();
    }

    public HomePage loginInAsAgent() {
        try {
            Thread.sleep(4000);
            signInWithGoogle.click();
            Thread.sleep(2000);
            actionUtil.switchToChildWindow(driver);
            emailOrPhone.sendKeys(properties.getProperty(IConstants.emailID), Keys.ENTER);
            enterYourPassword.sendKeys(properties.getProperty(IConstants.password), Keys.ENTER);
            continueButton.click();
            actionUtil.switchToParentWindow(driver);
        } catch (Exception e) {
            Assert.fail("Agent login is failed");
            e.printStackTrace();

        }
        return new HomePage();
    }


}
