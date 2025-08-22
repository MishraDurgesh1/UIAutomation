package Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Utility {
    private static final int DEFAULT_TIMEOUT = 30;
    static FileInputStream inputStream;
    static FileOutputStream outputStream;
    static Workbook workbook;
    static Row row;
    static Sheet sheet;
    static File file;
    static int rowCount;
    static URL websiteUrl;
    static ReadableByteChannel rbc;

    //Open Browser Method:-
    //Get Title of Opened Page:-
    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    //Get Current URL of Open Page:-
    public static String getUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    //Window Scroll Methods:-
    public static void windowScroll() {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
    }

    //Convert Java To JSON Methods:-
    public static String javaToJsonConvert(ArrayList arrayList) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<String> arrayList1 = new ArrayList<>(arrayList);
        return mapper.writeValueAsString(arrayList1);
    }

    //Convert JSON to JAVA Methods:-
    public static ArrayList jsonToJavaConvert(String jsString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsString, ArrayList.class);
    }

    //Manage Alerts:-
    public static void alertAccept(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public static void alertDismiss(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public static void alertSend(WebDriver driver, String str) {
        driver.switchTo().alert().sendKeys(str);
    }

    public static void alertGetText(WebDriver driver) {
        driver.switchTo().alert().getText();
    }

    //Read and Write Excel File :-
    public static void fileReadWrite(String filePath) throws IOException {
        file = new File(filePath);
        inputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheetAt(0);
        rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
    }

    public static void closeFile() throws IOException {
        inputStream.close();
        outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();
    }

    public static void readExcel(String filePath) throws IOException {
        fileReadWrite(filePath);
        for (int i = 0; i < rowCount + 1; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                System.out.print(row.getCell(j).getStringCellValue() + " || ");
            }
            System.out.println();
        }
    }

    public static void writeDataInExcel(String filePath, String[] dataToWrite) throws IOException {
        fileReadWrite(filePath);
        row = sheet.getRow(0);
        Row newRow = sheet.createRow(rowCount + 1);//create a new row
        for (int i = 0; i < row.getLastCellNum(); i++) {
            Cell cell = newRow.createCell(i);
            cell.setCellValue(dataToWrite[i]);//Set value in new cell
        }
        closeFile();
    }

    //Download files from Internet:-
    public static void downloadFileFromUrl(String urlOfDownloadElement) throws IOException {
        websiteUrl = new URL(urlOfDownloadElement);
        rbc = Channels.newChannel(websiteUrl.openStream());
        outputStream = new FileOutputStream("download.html");
        outputStream.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        closeDownloadFile();
    }

    public static void closeDownloadFile() throws IOException {
        outputStream.close();
        rbc.close();
    }

    //Take Screenshot from web Pages:-
    public static void screenshot(WebDriver driver, String FileName) throws IOException {
        file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("image location" + FileName + ".jpeg"));

    }

    //Make Border for screenshot image:-
    public static void makeBorder(WebDriver driver, WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = '8px solid red' ", webElement);
    }

    //Explicit wait and click on Web Element by Javascript:-
    public static void waitAndClickByJsExecutor(WebDriver driver, WebElement element) {
        //Explicit wait:-
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Create a JavascriptExecutor instance:-
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Click on the element using JavaScript:-
        //jsExecutor.executeScript("arguments[0].click();", element);

        //Click on the element and wait using JavaScript:-
        jsExecutor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(element)));
    }

    //Handle dropdown:-
    public static void dropDownClick(WebElement dropdownElement) {
        // Store all options of the dropdown in a list
        List<WebElement> list = dropdownElement.findElements(By.tagName("option"));

        // Loop through each option and click
        for (WebElement webElement : list) {
            webElement.click();
        }
    }

    //Actions Class:-
    public static void action(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        //For single click-
        act.click();
        //For Double click -
        act.doubleClick(element).perform();
        //for right click-
        act.contextClick().perform();
        //For sendkeys-
        act.sendKeys(Keys.ENTER).perform();
        act.sendKeys("");
        act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

    }

    //Desktop Automation:-{you need to install AUTO-IT and AutoIT Editor}
    //Code on Auto IT Editor:-
// ControlFocus("Open","","Edit1")
// Sleep(3000)
// ControlSetText("Open","","Edit1","D:\comed.csv")
// Sleep(3000)
// ControlClick("Open","","Button1")

    public static void filUpload(WebElement element) throws InterruptedException, IOException {
        element.click();
        Runtime.getRuntime().exec("File_Path");
        Thread.sleep(5000);
    }


    // ✅ Wait for element to be visible
    public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.visibilityOf(element));
    }

    // ✅ Wait for element to be clickable
    public static WebElement waitForClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
    }

    // ✅ Wait for element to be present in DOM
    public static WebElement waitForPresence(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // ✅ Click element after waiting
    public static void clickWhenReady(WebDriver driver, WebElement element) {
        try {
            waitForClickable(driver, element).click();
        } catch (Exception e) {
            // Fallback: JS click
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }
  public static void clickOnOkButton(WebDriver driver) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
      okBtn.click();

  }

    // ✅ Send keys after waiting
    public static void sendKeysWhenReady(WebDriver driver, WebElement element, String text) {
        waitForVisibility(driver, element).clear();
        element.sendKeys(text);
    }

    // ✅ Wait for title to contain text
    public static void waitForTitleContains(WebDriver driver, String titleText) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.titleContains(titleText));
    }

    // ✅ Wait for alert and accept it
    public static void waitForAlertAndAccept(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (TimeoutException e) {
            System.out.println("⚠️ No alert appeared, continuing...");
        }
    }
    public static void simpleWait(long seconds) {
        try {
            Thread.sleep(3000);
        }
        catch (Exception e){
            System.out.println("⚠️ Wait or close");
        }

    }


}
