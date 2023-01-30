package tests;

import org.testng.annotations.Test;
import steps.StartSteps;
import steps.TimerSteps;

public class TimerTest extends BaseTest {
    private final StartSteps startSteps = new StartSteps();
    private final TimerSteps timerSteps = new TimerSteps();

    @Test
    public void timerTest() {
        startSteps.clickStartLinkAndAssertCardStep();
        log.info("Validate that timer starts from 00");
        timerSteps.validateTimerStep();
    }
}
