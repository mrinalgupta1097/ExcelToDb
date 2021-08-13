package com.demo.exceltodb.excelHelper;

import com.demo.exceltodb.entity.Library;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class ExcelDownload {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Id", "Name", "Books"};
    static String SHEET = "Library";

    public static ByteArrayInputStream downloadAsExcel(List<Library> libraries){
        try(Workbook workbook = new XSSFWorkbook();
            ByteArrayOutputStream out = new ByteArrayOutputStream();){

            Sheet sheet = workbook.createSheet(SHEET);

//            Header
            Row headerRow = sheet.createRow(0);
            for (int col=0;col< HEADERs.length;col++){
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowId = 1;
            for(Library library : libraries){
                Row row = sheet.createRow(rowId);

                row.createCell(0).setCellValue(library.getId());
                row.createCell(1).setCellValue(library.getName());
                row.createCell(2).setCellValue(library.getBooks().toString());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());

        } catch (IOException e) {
            throw new RuntimeException("fail to import data into excel file.");
            
        }
    }
}
