package com.example.excelapi.excel.application;

import com.example.excelapi.excel.application.utils.ExcelMethods;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ExcelGenerator implements ExcelGeneratorImpl {

    @Override
    public Resource getReport(Resource file) {
        Resource endFile = null;
        try {
            endFile = ExcelMethods.recalculationInCell(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return endFile;
    }

}
