package steps;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import pageObjects.AvatarAndInterestsCard;
import utils.UploadUtil;

import java.io.File;

public class UploadSteps {
    private static final ISettingsFile TEST_DATA = new JsonSettingsFile("TestData.json");
    private static final File file = new File(TEST_DATA.getValue("/avatarFilePath").toString());

    AvatarAndInterestsCard avatarAndInterestsCard = new AvatarAndInterestsCard();
    UploadUtil uploadUtil = new UploadUtil();

    public void uploadAvatarSteps() {
        avatarAndInterestsCard.uploadImage();
        uploadUtil.uploadFile(file);
    }
}
