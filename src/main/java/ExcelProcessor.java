import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelProcessor {

   private Workbook workbook;
   private Sheet sheet;
   private Row row;
   private CellStyle style;
   private Cell cell;

   public ExcelProcessor(){
        createSheet();
    }


    protected ExcelProcessor createSheet(){
        workbook = new XSSFWorkbook();
        style = workbook.createCellStyle();
        style.setWrapText(true);
        sheet = workbook.createSheet(Utils.getCurrentDate());
        sheet.setColumnWidth(0,6000);
        sheet.setColumnWidth(1,4000);

        Row header = sheet.createRow(0);
        row = sheet.createRow(1);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);

        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Name");
        headerCell.setCellStyle(headerStyle);
        headerCell = header.createCell(1);
        headerCell.setCellValue("Age");
        headerCell.setCellStyle(headerStyle);
        return this;

    }
    public void createRow(int i){
        row = sheet.createRow(i);
    }

    public ExcelProcessor fillCell(int number){
       cell = row.createCell(1);
       cell.setCellValue(number);
       cell.setCellStyle(style);
       return this;
    }

    public ExcelProcessor fillCell(String text){
       cell = row.createCell(0);
       cell.setCellValue(text);
       cell.setCellStyle(style);
       return this;
    }

    public void writeFile(){
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";
        try {
            FileOutputStream outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            System.out.println("Write");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean close(){
       boolean result= false;
       try {
            workbook.close();
            result = true;
            System.out.println("Closed");
        }catch (IOException e){
            e.printStackTrace();
        }
       return result;
    }
}
