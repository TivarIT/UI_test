package steps;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.Assert;
import pageObjects.CardsPage;

public class TimerSteps {
    protected static final ISettingsFile TEST_DATA = new JsonSettingsFile("TestData.json");
    private final CardsPage cardsPage = new CardsPage();

    public void validateTimerStep() {
        Assert.assertEquals(cardsPage.getTimerValue(), TEST_DATA.getValue("/timerText").toString(),
                "Timer don't starts at 00:00:00!");
    }
}
