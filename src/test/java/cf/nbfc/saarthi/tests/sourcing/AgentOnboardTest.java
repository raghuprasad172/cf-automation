package cf.nbfc.saarthi.tests.sourcing;

import cf.nbfc.base.BaseClass;
import cf.nbfc.constants.IConstants;
import cf.nbfc.eventListener.WebEventResultsListener;
import cf.nbfc.pom.saarthi.generics.HomePage;
import cf.nbfc.pom.saarthi.generics.LoginPage;
import cf.nbfc.pom.saarthi.sourcing.MyLeads;
import cf.nbfc.util.ActionUtil;
import cf.nbfc.util.FileUtil;
import cf.nbfc.util.JavaUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author Raghu Prasad
 */
@Listeners(WebEventResultsListener.class)
public class AgentOnboardTest extends BaseClass {
    public LoginPage loginPage;
    public HomePage homePage;
    public MyLeads myLeads;

    public AgentOnboardTest() {
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
    public void validateMyLeadsMenuIsDisplayed() {
        homePage = loginPage.loginInAsAgent();
        Assert.assertTrue(homePage.validateMyLeadsMenuIsDisplayed(), "My Leads menu isn't displayed");
    }

    @Test(priority = 2)
    public void validateAddNewLead() throws Throwable {
        homePage = loginPage.loginInAsAgent();
        myLeads = homePage.clickOnHomeModule(IConstants.moduleName);
        myLeads.clickOnAddNewLead();
        myLeads.enterPhoneNumber(JavaUtil.generateRandomMobileNumber());
        myLeads.selectProductType(FileUtil.getPropertyValue(IConstants.sourcingConfigFilePath,IConstants.productType));
        myLeads.selectChannel(FileUtil.getPropertyValue(IConstants.sourcingConfigFilePath,IConstants.channel));
        myLeads.clickOnRequestConsent();
        myLeads.enterOTP();
        myLeads.clickOnProceed();
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
