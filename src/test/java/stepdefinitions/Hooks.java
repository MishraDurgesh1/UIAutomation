package stepdefinitions;

import Page.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseTest {

    @Before
    public void setUp() {
        openBrowser();   // from BaseTest
    }

    @After
    public void tearDown() {
        closeBrowser();   // from BaseTest
    }
}
