package com.example.excelapi.excel.application.utils;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcelMethods {

    private ExcelMethods(){
        throw new IllegalStateException("Utility class");
    }

    public static Resource recalculationInCell(Resource file) throws IOException {

        final int originRow = 0;
        final int originColumn = 0;
        final int destinationRow = 1000;
        final int destinationColumn = 1000;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())){
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            XSSFSheet finallySheet = workbook.getSheet("Hoja1");
            finallySheet.forEach(row ->
                row.forEach(cell -> {
                    if (cell.getColumnIndex() >= originColumn && cell.getRowIndex() >= originRow && cell.getColumnIndex() <= destinationColumn && cell.getRowIndex() <= destinationRow) {
                        switch (evaluator.evaluateInCell(cell).getCellType()) {
                            case NUMERIC:
                                break;
                            case STRING:
                                break;
                            case BOOLEAN:
                                break;
                            case ERROR:
                                break;
                            case BLANK:
                                break;
                            case FORMULA:
                                break;
                            default:
                                break;
                        }
                    }
                })
            );
            try {
                workbook.write(bos);
            } finally {
                bos.close();
            }
        } catch (OutOfMemoryError outMemory) {
            Logger.getLogger(ExcelMethods.class.getName()).log(Level.SEVERE, "Out of memory error {0}", outMemory.getMessage());
        } catch (Exception e) {
            Logger.getLogger(ExcelMethods.class.getName()).log(Level.SEVERE, "Impossible operation {0}", e.getMessage());
        }

        return new ByteArrayResource(bos.toByteArray());
    }

}
