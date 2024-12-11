package cf.nbfc.saarthi.tests.generic;

import cf.nbfc.base.BaseClass;
import cf.nbfc.constants.IConstants;
import cf.nbfc.eventListener.WebEventResultsListener;
import cf.nbfc.pom.saarthi.generics.HomePage;
import cf.nbfc.pom.saarthi.generics.LoginPage;
import cf.nbfc.util.ScreenShotUtil;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author Raghu Prasad
 */
@Listeners(WebEventResultsListener.class)
public class AgentLoginTest extends BaseClass {

    public LoginPage loginPage;

    public AgentLoginTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        try {
            init();
            loginPage = new LoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void validateLoginPageTitle()  {
        String loginPageTitle = loginPage.validateLoginPageTitle();
        Assert.assertEquals(loginPageTitle, IConstants.loginPageTitle);
    }
    @Test(priority = 2)
    public void validateLoginButtonIsDisplayed() {
        boolean isDisplayed=loginPage.validateLoginButtonIsDisplayed();
        Assert.assertTrue(isDisplayed,"Sign in button isn't displayed");
    }

    @Test(priority = 3)
    public void validateAgentIsAbletonLogin() {
     loginPage.loginInAsAgent();

    }

    @AfterMethod
    public void tearDown() {
        try {
            quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
