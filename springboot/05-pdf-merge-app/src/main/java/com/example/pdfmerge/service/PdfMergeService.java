package com.example.pdfmerge.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PdfMergeService {

    private static final Logger logger =
            LoggerFactory.getLogger(PdfMergeService.class);

    public void mergePdfs(List<File> pdfFiles, String outputPath) throws IOException {

        logger.info("[SERVICE] PDF merge started");
        logger.info("[SERVICE] Output file path -> {}", outputPath);

        PDFMergerUtility merger = new PDFMergerUtility();

        int index = 1;
        for (File file : pdfFiles) {

            logger.info("[SERVICE] Adding source PDF [{}] -> {}",
                    index, file.getAbsolutePath());

            merger.addSource(file);
            index++;
        }

        merger.setDestinationFileName(outputPath);

        logger.info("[SERVICE] All source PDFs added");
        logger.info("[SERVICE] Starting PDFBox merge operation");

        merger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

        logger.info("[SERVICE] PDF merge completed successfully");
        logger.info("[SERVICE] Final merged PDF path -> {}", outputPath);
    }
}