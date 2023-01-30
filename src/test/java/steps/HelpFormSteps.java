package steps;

import org.testng.Assert;
import pageObjects.CardsPage;

public class HelpFormSteps {
    private final CardsPage cardsPage = new CardsPage();

    public void hideHelpFormStep() {
        cardsPage.hideHelpWindowForm();
        Assert.assertTrue(cardsPage.isHelpFormHidden(), "ERROR! Help form isn't hidden!");
    }
}
