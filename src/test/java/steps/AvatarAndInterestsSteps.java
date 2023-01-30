package steps;

import org.testng.Assert;
import pageObjects.AvatarAndInterestsCard;
import pageObjects.PersonalDetailsCard;

public class AvatarAndInterestsSteps {
    private final AvatarAndInterestsCard avatarAndInterestsCard = new AvatarAndInterestsCard();
    private final PersonalDetailsCard personalDetailsCard = new PersonalDetailsCard();
    private final UploadSteps uploadSteps = new UploadSteps();

    public void selectInterestsAndUploadAvatarStep(int number) {
        Assert.assertTrue(avatarAndInterestsCard.state().isDisplayed(), "ERROR! Card '2' isn't displayed!");
        avatarAndInterestsCard.selectDifferentInterests(number);
        uploadSteps.uploadAvatarSteps();
        avatarAndInterestsCard.goToNextCard();
        Assert.assertTrue(personalDetailsCard.state().isDisplayed(), "ERROR! Card '3' isn't displayed!");
    }
}
