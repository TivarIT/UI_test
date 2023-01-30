package steps;

import pageObjects.AuthorizationCard;

public class EmailPasswordSteps {

    private final AuthorizationCard authorizationCard = new AuthorizationCard();

    public void enterEmailPasswordSteps(String email, String password) {
        authorizationCard.enterPassword(password);
        authorizationCard.setEmail(email);
        authorizationCard.acceptTermsConditions();
        authorizationCard.goToNextCard();
    }
}
