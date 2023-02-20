package BankTest;

import POM.Bank.LoginBank;
import org.testng.annotations.Test;

public class BankloginTest extends LoginBank {
    @Test(priority = '1')
    public static void LoginBank() {
        openbank("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        bankManagerClick();
    }
}
