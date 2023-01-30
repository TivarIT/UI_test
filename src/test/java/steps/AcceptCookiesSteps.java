package steps;

import org.testng.Assert;
import pageObjects.CardsPage;

public class AcceptCookiesSteps {
    private final CardsPage cardsPage = new CardsPage();

    public void acceptCookiesStep() {
        cardsPage.acceptCookies();
        Assert.assertFalse(cardsPage.isCookiesAccepted(), "ERROR! Cookies form isn't close!");
    }
}
