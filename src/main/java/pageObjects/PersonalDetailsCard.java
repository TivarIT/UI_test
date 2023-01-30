package pageObjects;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsCard extends Form {
    public PersonalDetailsCard() {
        super(By.xpath("//div[@class='personal-details__form']"), "personal details form");
    }
}
