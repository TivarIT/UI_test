package steps;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import org.testng.Assert;
import pageObjects.AuthorizationCard;
import pageObjects.MainPage;

public class StartSteps {
    protected Logger log = AqualityServices.getLogger();
    private final MainPage mainPage = new MainPage();
    private final AuthorizationCard authorizationCard = new AuthorizationCard();

    public void clickStartLinkAndAssertCardStep() {
        Assert.assertTrue(mainPage.state().isDisplayed(), "ERROR! Welcome page isn't displayed!");
        log.info("Click HERE to GO to the next page");
        mainPage.clickStartLink();
        Assert.assertTrue(authorizationCard.state().isDisplayed(), "ERROR! Card '1' isn't displayed!");
    }
}
