package tests;

import org.testng.annotations.Test;
import steps.AcceptCookiesSteps;
import steps.StartSteps;

public class AcceptCookiesTest extends BaseTest {
    private final StartSteps startSteps = new StartSteps();
    private final AcceptCookiesSteps acceptCookiesSteps = new AcceptCookiesSteps();

    @Test
    public void acceptCookiesTest() {
        startSteps.clickStartLinkAndAssertCardStep();
        log.info("Accept cookie");
        acceptCookiesSteps.acceptCookiesStep();
    }
}
