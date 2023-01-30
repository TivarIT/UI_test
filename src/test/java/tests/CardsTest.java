package tests;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.Test;
import steps.AvatarAndInterestsSteps;
import steps.EmailPasswordSteps;
import steps.StartSteps;
import utils.RandomUtil;

public class CardsTest extends BaseTest{
    private static final ISettingsFile TEST_DATA = new JsonSettingsFile("TestData.json");
    private final StartSteps startSteps = new StartSteps();
    private final EmailPasswordSteps emailPasswordSteps = new EmailPasswordSteps();
    private final AvatarAndInterestsSteps avatarAndInterestsSteps = new AvatarAndInterestsSteps();
    private final String email = TEST_DATA.getValue("/email").toString();
    private final int countOfCheckboxes = Integer.parseInt(TEST_DATA.getValue("/checkboxCount").toString());

    @Test
    public void cardsTest() {
        startSteps.clickStartLinkAndAssertCardStep();
        log.info("Input random valid password, email, accept the terms of use and click 'next' button.");
        emailPasswordSteps.enterEmailPasswordSteps(email, RandomUtil.generatePassword(email));
        avatarAndInterestsSteps.selectInterestsAndUploadAvatarStep(countOfCheckboxes);
    }
}
