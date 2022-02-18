package com.example.excelapi.excel.dominio;

public class Constant {

    private Constant(){
        throw new IllegalStateException("Utility class");
    }

    public static final String EXCEL_MEDIA_TYPE = "application/vnd.ms-excel";
    public static final String EXCEL_HEADER = "attachment; filename=final-report.xlsx";
}