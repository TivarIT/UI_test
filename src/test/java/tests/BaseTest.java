package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected Logger log = AqualityServices.getLogger();
    protected static final ISettingsFile TEST_DATA = new JsonSettingsFile("TestData.json");
    protected static final String url = TEST_DATA.getValue("/mainPageURL").toString();

    @BeforeMethod
    protected void beforeMethod() {
        log.info(String.format("Go to the %s", url));
        AqualityServices.getBrowser().goTo(TEST_DATA.getValue("/gamePageURL").toString());
        AqualityServices.getBrowser().maximize();
        AqualityServices.getBrowser().waitForPageToLoad();
    }

    @AfterMethod
    public void afterTest() {
        AqualityServices.getBrowser().quit();
    }
}
