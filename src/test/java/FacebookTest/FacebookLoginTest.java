package FacebookTest;

import POM.FacebookUI.LoginFb;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookLoginTest extends LoginFb {

    @Test(priority = '1')
    public static void loginFacebook() {

        openFacebook();
        enterEmail("");
        enterPassword("");
        clickOnLogin();
        closeBrowser();
    }

    @Test(priority = '2')
    public static void verifyUrlFacebook()  {

        openFacebook();
        getUrl();
        Assert.assertEquals("https://www.facebook.com/", getUrl());
        closeBrowser();
    }

    @Test(priority = '3')
    public static void verifyTitleFacebook() {
        openFacebook();
        getTitle();
        Assert.assertEquals("Facebook – log in or sign up", getTitle());
        closeBrowser();
    }

}
