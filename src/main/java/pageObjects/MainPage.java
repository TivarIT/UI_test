package pageObjects;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    public MainPage() {
        super(By.xpath("//button[@type='button']"), "start button");
    }

    private final ILink startLink = getElementFactory().getLink(By.xpath("//div[@class='view__row']//a[@class='start__link']"),
            "start link");

    public void clickStartLink() {
        startLink.clickAndWait();
    }
}
