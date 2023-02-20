package BankTest;

import POM.Bank.OpenAccount;
import org.testng.annotations.Test;

public class OpenAccountTest extends OpenAccount {
    @Test(priority = '3')
    public static void OpenAccount() {
        openbank("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        bankManagerClick();
        addCustomersClick();
        enterFirstName("Jyoti");
        enterLastName("Verma");
        enterPostCode("208001");
        addCustomerClick();
        openAccountClick();
        enterCustomerName();
        enterCurrency();
        processClick();
    }
}

