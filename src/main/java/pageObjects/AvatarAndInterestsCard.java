package pageObjects;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class AvatarAndInterestsCard extends Form {
    public AvatarAndInterestsCard() {
        super(By.xpath("//div[@class='avatar-and-interests__form']"), "interests form");
    }

    private static final String CHECKBOX_ATTRIBUTE = "for";

    private final IButton linkForUploadAvatar = getElementFactory().getButton(By.xpath("//p//a[@class='avatar-and-interests__upload-button']"),
            "link for upload avatar");
    private final IButton buttonNext = getElementFactory().getButton(By.xpath("//div[@class='avatar-and-interests-page__buttons-row']//button[contains(@class,'button--white')]"),
            "button next");
    private final static String UNSELECT_ALL = "interest_unselectall";
    private final static String SELECT_ALL = "interest_selectall";
    private final String xpathToCheckBoxesInterests = "//div[@class='avatar-and-interests__interests-list']//label";

    private List<ICheckBox> getCheckBoxesInterests() {
        return getElementFactory().findElements(By.xpath(xpathToCheckBoxesInterests), ElementType.CHECKBOX);
    }

    private ICheckBox getCheckBoxUnselectAll() {
        List<ICheckBox> checkBoxesInterests = getCheckBoxesInterests();
        return checkBoxesInterests.stream().filter(checkBox -> UNSELECT_ALL.equals(checkBox.getAttribute(CHECKBOX_ATTRIBUTE)))
                .findFirst().orElseThrow();
    }

    private List<ICheckBox> checkUnselectInterest() {
        List<ICheckBox> checkBoxesInterests = getCheckBoxesInterests();
        checkBoxesInterests.removeIf(checkBox -> Objects.equals(checkBox.getAttribute(CHECKBOX_ATTRIBUTE), UNSELECT_ALL)
                || Objects.equals(checkBox.getAttribute(CHECKBOX_ATTRIBUTE), SELECT_ALL));
        return checkBoxesInterests;
    }


    public void selectDifferentInterests(int number) {
        Random random = new Random();
        List<ICheckBox> checkBoxesInterests = checkUnselectInterest();
        getCheckBoxUnselectAll().clickAndWait();

        for (int i = 0; i < number; i++) {
            checkBoxesInterests.remove(random.nextInt(checkBoxesInterests.size())).clickAndWait();
        }
    }

    public void uploadImage() {
        linkForUploadAvatar.clickAndWait();
    }

    public void goToNextCard() {
        buttonNext.clickAndWait();
    }
}
