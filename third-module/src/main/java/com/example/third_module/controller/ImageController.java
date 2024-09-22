package com.example.third_module.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.file.Files;

@Controller
public class ImageController {

    @GetMapping(value = "/image")
    public ResponseEntity<byte[]> getImage() throws IOException {
        Resource imgFile = new ClassPathResource("static/images/koichi_without.png");

        byte[] imageBytes = Files.readAllBytes(imgFile.getFile().toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/image/logo")
    public ResponseEntity<byte[]> getLogo() throws IOException {
        Resource imgFile = new ClassPathResource("static/images/logo_without.png");

        byte[] imageBytes = Files.readAllBytes(imgFile.getFile().toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }
}
