package com.glossaryconverter.glossary_java_api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/convert")
public class ConversionController {

    @PostMapping("/sdltm-to-tmx")
    public ResponseEntity<String> convertSdltmToTmx(@RequestParam("file") MultipartFile file) {
        // Placeholder response for testing
        String fileName = file.getOriginalFilename();
        String message = "Received file: " + fileName + " - Conversion logic will be implemented here.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
