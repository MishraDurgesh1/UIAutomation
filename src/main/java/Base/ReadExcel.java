package Base;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
   public void readExcel(String filePath,String fileName,String sheetName) throws IOException {
      //Open xlsx file:-
       //Read the xlsx file:-
       FileInputStream inputStream=new FileInputStream(filePath);
       Workbook workbook = null;
       //Find file Extension:-
       String fileExtensionName = fileName.substring(fileName.indexOf("."));
       System.out.println(fileExtensionName);

       //Check condition If the file .xlsx file:-
       if(fileExtensionName.equals(".xlsx")){
            workbook = new XSSFWorkbook(inputStream);

       }
       //Check condition If the file .xlsx file
       else if (fileExtensionName.equals(".xls")) {
           workbook= new HSSFWorkbook(inputStream);
       }

       //Read sheet inside the worksheet by its name
       assert workbook != null;
       Sheet sheet =workbook.getSheet(sheetName);

       //Find number of rows in Excel file:-
       int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
       System.out.println("Total rows are =" +rowCount);

       //Create a loop over all the rows to read file:-
       for (int i=0;i<rowCount+1;i++){
           Row row= sheet.getRow(i);
           for (int j=0;j<row.getLastCellNum();j++){
               System.out.println(row.getCell(i).getStringCellValue()+"||");
           }
           System.out.println();
       }
   }

    public static void main(String[] args) throws IOException {
        ReadExcel readExcelObj=new ReadExcel();
        String filePath = System.getProperty("user.dir")+"\\src\\inputs\\ExcelSheet.xlsx";
        readExcelObj.readExcel(filePath,"ExcelSheet.xlsx","First");
   }
}
