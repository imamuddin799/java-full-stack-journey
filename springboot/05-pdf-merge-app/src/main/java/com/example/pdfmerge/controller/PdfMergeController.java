package com.example.pdfmerge.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.example.pdfmerge.service.PdfMergeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PdfMergeController {

    @Autowired
    private PdfMergeService pdfMergeService;

    private static final Logger logger =
            LoggerFactory.getLogger(PdfMergeController.class);

    @GetMapping("/")
    public String index() {
        logger.info("[PAGE] Index page loading");
        return "index";
    }

    @PostMapping("/merge")
    public ResponseEntity<FileSystemResource> mergePdf(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam("orders") Integer[] orders) throws Exception {

        logger.info("[REQUEST] PDF merge request received");
        logger.info("[REQUEST] Total files received: {}", files.length);

        if (files.length < 2) {
            logger.error("[VALIDATION] Less than 2 PDF files uploaded");
            throw new RuntimeException("Upload at least 2 PDFs");
        }

        if (files.length != orders.length) {
            logger.error("[VALIDATION] Files count and orders count mismatch");
            throw new RuntimeException("Each PDF must have an order");
        }

        // Map order → file
        Map<Integer, MultipartFile> orderedMap = new TreeMap<>();

        for (int i = 0; i < files.length; i++) {
            logger.info("[UPLOAD] Received file: {} | Order: {}",
                    files[i].getOriginalFilename(), orders[i]);

            orderedMap.put(orders[i], files[i]);
        }

        logger.info("[SORT] Files sorted according to user-defined order");

        List<File> sortedFiles = new ArrayList<>();

        for (Map.Entry<Integer, MultipartFile> entry : orderedMap.entrySet()) {

            MultipartFile file = entry.getValue();

            File temp = Files.createTempFile("pdf-", ".pdf").toFile();
            file.transferTo(temp);

            logger.info("[TEMP] Created temp file for order {} -> {}",
                    entry.getKey(), temp.getAbsolutePath());

            sortedFiles.add(temp);
        }

        File mergedFile = Files.createTempFile("merged-", ".pdf").toFile();
        logger.info("[OUTPUT] Merged PDF will be created at -> {}",
                mergedFile.getAbsolutePath());

        pdfMergeService.mergePdfs(sortedFiles, mergedFile.getAbsolutePath());

        logger.info("[SUCCESS] PDF merge completed successfully");
        logger.info("[DOWNLOAD] Returning merged file -> {}",
                mergedFile.getAbsolutePath());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=merged.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(new FileSystemResource(mergedFile));
    }
}