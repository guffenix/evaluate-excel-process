package com.example.excelapi.excel.infraestructure;

import com.example.excelapi.excel.application.ExcelGenerator;
import com.example.excelapi.excel.dominio.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/report")
public class ProcessController {

    @Autowired
    ExcelGenerator reportService;

    @PostMapping("/evaluate")
    public ResponseEntity<Resource> generateFile(@RequestParam("file") MultipartFile inputFile) throws IOException {

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, Constant.EXCEL_HEADER)
                .contentType(MediaType.parseMediaType(Constant.EXCEL_MEDIA_TYPE))
                .cacheControl(CacheControl.noCache())
                .body(reportService.getReport(new ByteArrayResource(inputFile.getBytes())));
    }

}
