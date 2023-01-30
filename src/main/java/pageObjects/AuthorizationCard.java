package pageObjects;

import aquality.selenium.core.logging.Logger;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import static aquality.selenium.elements.ElementType.TEXTBOX;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.List;
import utils.RandomUtil;

public class AuthorizationCard extends Form {
    public AuthorizationCard() {
        super(By.xpath("//div[@class='login-form']"), "login form");
    }

    private final ITextBox textBoxPassword = getElementFactory().getTextBox(By.xpath("//div[@class='login-form__field-row']/input"),
            "password");
    private final ITextBox textBoxEmail = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Your email']"),
            "email");
    private final ITextBox textBoxDomain = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Domain']"),
            "domain");
    private final ITextBox comboBoxDomainCountry = getElementFactory().getTextBox(By.className("dropdown__field"),
            "dropdown opener");
    private final ICheckBox checkBoxAccept = getElementFactory().getCheckBox(By.className("checkbox"),
            "checkbox accept Terms & Conditions");
    private final ILink linkNext = getElementFactory().getLink(By.className("button--secondary"), "button next");
    private final String locatorOfDomainEmail = "//div[@class='dropdown__list-item'][%s]";
    private final By locatorOfDropdownList = By.className("dropdown__list-item");

    public void enterPassword(String password) {
        textBoxPassword.clearAndType(password);
    }

    public void enterEmail(String email) {
        textBoxEmail.clearAndType(RandomUtil.getEmail(email));
    }

    public void enterDomain(String email) {
        textBoxDomain.clearAndType(RandomUtil.getDomains(email).get(0));
    }

    public void clickDropDownOpener() {
            comboBoxDomainCountry.click();
    }

    private ITextBox getDomainOfEmail(String email) {
        List<ITextBox> domains = getElementFactory().findElements(locatorOfDropdownList,"Domains", TEXTBOX);
        for (int i = 0; i < domains.size(); i++) {
            if (domains.get(i).getText().equals(RandomUtil.getDomains(email).get(1))) {
                return getElementFactory().getTextBox(By.xpath
                        (String.format(locatorOfDomainEmail, i)), "DomainEmail");
            }
        }
        Logger.getInstance().error("Incorrect Email");
        return null;
    }

    public void acceptTermsConditions() {
        checkBoxAccept.check();
    }

    public void goToNextCard() {
        linkNext.clickAndWait();
    }

    public void setEmail(String email) {
        enterEmail(email);
        enterDomain(email);
        clickDropDownOpener();
        getDomainOfEmail(email).click();
    }
}
