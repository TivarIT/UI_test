package tests;

import org.testng.annotations.Test;
import steps.HelpFormSteps;
import steps.StartSteps;

public class HideHelpFormTest extends BaseTest {
    private final StartSteps startSteps = new StartSteps();
    private final HelpFormSteps helpFormSteps = new HelpFormSteps();


    @Test
    public void hideHelpFormTest() {
        startSteps.clickStartLinkAndAssertCardStep();
        log.info("Hide Help form");
        helpFormSteps.hideHelpFormStep();
    }
}
