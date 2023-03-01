package Base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.Duration;
import java.util.ArrayList;

public class Utility {
    static FileInputStream inputStream;
    static FileOutputStream outputStream;
    static Workbook workbook;
    static Row row;
    static Sheet sheet;
    static File file;
    static int rowCount;
    static URL websiteUrl;
    static ReadableByteChannel rbc;
    public static WebDriver driver;

    //Open Browser Method:-
    public static void openBrowser(String url,String BrowserName){


        if (BrowserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-popup-blocking");
            options.getCapability("--incognito");
        } else if (BrowserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        } else if (BrowserName.equalsIgnoreCase("Mozila")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else {
            System.out.println("You Entered invalid Browser!!!");
        }
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //Get Title of Opened Page:-
    public static String getTitle(){
       return driver.getTitle();
    }

    //Get Current URL of Open Page:-
    public static String getUrl(){
        return driver.getCurrentUrl();
    }

    //Window Scroll Methods:-
    public static void windowScroll(){
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
    }

    //Convert Java To JSON Methods:-
    public static String javaToJsonConvert(ArrayList arrayList) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        ArrayList<String> arrayList1=new ArrayList<>(arrayList);
        return mapper.writeValueAsString(arrayList1);
    }

    //Convert JSON to JAVA Methods:-
    public static ArrayList jsonToJavaConvert(String jsString) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
       return mapper.readValue(jsString,ArrayList.class);
    }

    //Manage Alerts:-
    public static void alertAccept(){
        driver.switchTo().alert().accept();
    }
    public static void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public static void alertSend(String str){
        driver.switchTo().alert().sendKeys(str);
    }

    public static void alertGetText(){
        driver.switchTo().alert().getText();
    }

    //Wait methods:-
    public static void waitBrowser(int timeWait) throws InterruptedException {
        Thread.sleep(3000);
    }

    //Close the browser:-
    public static void closeBrowser(){
        driver.close();
        driver.quit();
    }

    //Read and Write Excel File :-
    public static void fileReadWrite(String filePath) throws IOException {
        file=new File(filePath);
        inputStream=new FileInputStream(filePath);
        workbook=new XSSFWorkbook(inputStream);
        sheet= workbook.getSheetAt(0);
        rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
    }

    public static void closeFile() throws IOException {
        inputStream.close();
        outputStream=new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();
    }

    public static void readExcel(String filePath) throws IOException {
        fileReadWrite(filePath);
        for (int i=0;i<rowCount+1;i++){
            row=sheet.getRow(i);
            for (int j=0;j<row.getLastCellNum();j++){
                System.out.print(row.getCell(j).getStringCellValue()+" || ");
            }
            System.out.println();
        }
    }
    public static void writeDataInExcel(String filePath,String[] dataToWrite) throws IOException {
        fileReadWrite(filePath);
        row= sheet.getRow(0);
        Row newRow=sheet.createRow(rowCount+1);//create a new row
        for (int i=0;i<row.getLastCellNum();i++){
            Cell cell= newRow.createCell(i);
            cell.setCellValue(dataToWrite[i]);//Set value in new cell
        }
        closeFile();
    }
    //Download files from Internet:-
    public static void downloadFileFromUrl(String urlOfDownloadElement) throws IOException {
        websiteUrl=new URL(urlOfDownloadElement);
        rbc= Channels.newChannel(websiteUrl.openStream());
        outputStream=new FileOutputStream("download.html");
        outputStream.getChannel().transferFrom(rbc,0,Long.MAX_VALUE);
        closeDownloadFile();
    }
    public static void closeDownloadFile() throws IOException {
        outputStream.close();
        rbc.close();
    }

    //Take Screenshot from web Pages:-
    public static void screenshot(String FileName) throws IOException {
        file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("image location" +FileName + ".jpeg"));

    }

    //Make Border for screenshot image:-
    public static void makeBorder(WebElement webElement){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = '8px solid red' ",webElement);
    }

}
