package GmailPOM;

import Base.Utility;
import org.checkerframework.dataflow.qual.TerminatesExecution;

public class OpenGooglePOM extends Utility {
    public static void Google(){

        openBrowser("https://www.google.com/");
    }
}
