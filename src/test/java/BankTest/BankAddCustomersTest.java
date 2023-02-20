package BankTest;

import POM.Bank.AddCustomers;
import org.testng.annotations.Test;


public class BankAddCustomersTest extends AddCustomers {
    @Test(priority = '2')
    public static void AddCustomers()
        {
        openbank("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        bankManagerClick();
        addCustomersClick();
        enterFirstName("Jyoti");
        enterLastName("Verma");
        enterPostCode("208001");
        addCustomerClick();
    }
}
