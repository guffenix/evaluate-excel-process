package com.example.excelapi.excel.application;

import org.springframework.core.io.Resource;

public interface ExcelGeneratorImpl {
    Resource getReport(Resource file);
}
