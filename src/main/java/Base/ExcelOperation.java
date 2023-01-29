package Base;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class ExcelOperation {
    FileInputStream inputStream;
    FileOutputStream outputStream;
    Workbook workbook;
     Row row;
    Sheet sheet;
    File file;
    int rowCount;
    public void fileReadWrite(String filePath) throws IOException {
        file=new File(filePath);
        inputStream=new FileInputStream(filePath);
        workbook=new XSSFWorkbook(inputStream);
        sheet= workbook.getSheetAt(0);
        rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
    }

    public void closeFile() throws IOException {
        inputStream.close();
        outputStream=new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();
    }

   public void readExcel(String filePath) throws IOException {
       fileReadWrite(filePath);
       for (int i=0;i<rowCount+1;i++){
            row=sheet.getRow(i);
           for (int j=0;j<row.getLastCellNum();j++){
               System.out.print(row.getCell(j).getStringCellValue()+" || ");
           }
           System.out.println();
       }
   }
   public void writeDataInExcel(String filePath,String[] dataToWrite) throws IOException {
        fileReadWrite(filePath);
        row= sheet.getRow(0);
        Row newRow=sheet.createRow(rowCount+1);//create a new row
        for (int i=0;i<row.getLastCellNum();i++){
            Cell cell= newRow.createCell(i);
            cell.setCellValue(dataToWrite[i]);//Set value in new cell
        }
        closeFile();
   }
//    public static void main(String[] args) throws IOException {
//        String filePath = System.getProperty("user.dir")+"\\src\\inputs\\ExcelSheet.xlsx";
//        String[] dataToWrite={"Nidhi","Bio","Listening"};
//        ExcelOperation obj=new ExcelOperation();
//        obj.writeDataInExcel(filePath,dataToWrite);//Write file
//        obj.readExcel(filePath);//Read file
//   }
}
