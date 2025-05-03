package com.glossaryconverter.glossary_java_api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/convert")
public class ConversionController {

    @PostMapping("/sdltm-to-tmx")
    public ResponseEntity<String> convertSdltmToTmx(@RequestParam("file") MultipartFile file) {
        try {
            // Save uploaded file temporarily
            File tempInput = File.createTempFile("input-", ".sdltm");
            file.transferTo(tempInput);

            // Simulate conversion logic: return dummy TMX content
            String dummyTmx = "<?xml version=\"1.0\"?><tmx version=\"1.4\"><body><tu><tuv xml:lang=\"en\"><seg>Hello</seg></tuv><tuv xml:lang=\"fr\"><seg>Bonjour</seg></tuv></tu></body></tmx>";

            // Clean up
            tempInput.delete();

            return new ResponseEntity<>(dummyTmx, HttpStatus.OK);

        } catch (IOException e) {
            return new ResponseEntity<>("Conversion failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
