package pageObjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CardsPage extends Form {
    public CardsPage() {
        super(By.xpath("//div[@class='login-form']"), "login form");
    }

    private final IButton buttonSendToBottom = getElementFactory().getButton(By.xpath("//button[contains(@class,'help-form__send-to-bottom-button')]"),
            "help button 'Send to bottom'");
    private final ITextBox textBoxHelpForm = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'help-form')]"),
            "help Form");
    private final ITextBox textBoxCookiesBanner = getElementFactory().getTextBox(By.xpath("//div[@class='cookies']"),
            "cookies banner");
    private final IButton buttonAcceptCookies = getElementFactory().getButton(By.xpath("//div[@class='align__cell']//button[starts-with(@class,'button')]"),
            "button cookies accept");
    private final ILabel labelTimer = getElementFactory().getLabel(By.xpath("//div[contains(@class,'timer')]"), "timer");

    public void hideHelpWindowForm() {
        buttonSendToBottom.clickAndWait();
    }

    public boolean isHelpFormHidden() {
        return textBoxHelpForm.state().isDisplayed();
    }

    public void acceptCookies() {
        textBoxCookiesBanner.state().waitForDisplayed();
        buttonAcceptCookies.clickAndWait();
    }

    public boolean isCookiesAccepted() {
        return textBoxCookiesBanner.state().isDisplayed();
    }

    public String getTimerValue() {
        return labelTimer.getText();
    }
}
