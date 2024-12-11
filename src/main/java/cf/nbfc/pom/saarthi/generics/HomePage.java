package cf.nbfc.pom.saarthi.generics;

import cf.nbfc.base.BaseClass;
import cf.nbfc.pom.saarthi.sourcing.MyLeads;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * @author Raghu Prasad
 */
public class HomePage extends BaseClass {

    @FindBy(xpath = "//div[@id='app']//div[contains(@class,'host_Home-module__cards')]//span[text()='My Leads']")
    private WebElement myLeads;
    @FindBy(xpath = "//button[@type='button']")
    private WebElement logout;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String validateHomePageTitle() {
        return driver.getTitle();
    }

    public boolean validateMyLeadsMenuIsDisplayed(){
      return myLeads.isDisplayed();

    }

    public MyLeads clickOnHomeModule(String moduleName) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='app']//div[contains(@class,'host_Home-module__cards')]//span[text()='"+moduleName+"']")));
            driver.findElement(By.xpath("//div[@id='app']//div[contains(@class,'host_Home-module__cards')]//span[text()='" + moduleName + "']")).click();
            log.atInfo().log("clicked on " + moduleName);
        } catch (Exception e) {
            e.printStackTrace();
            log.atInfo().log("failed to click on " + moduleName);
        }
        return new MyLeads();
    }

    public void agentLogout() {
        logout.click();
        log.atInfo().log("Agent successfully logged out");
    }


}
