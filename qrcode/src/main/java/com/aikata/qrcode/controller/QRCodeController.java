package com.aikata.qrcode.controller;

import com.aikata.qrcode.request.Request;
import com.aikata.qrcode.service.QRCodeService;
import com.aikata.qrcode.utility.URLValidator;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class QRCodeController {

    private final QRCodeService qrCodeService;

    public QRCodeController(QRCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @PostMapping("/qrcode")
    public ResponseEntity<byte[]> generateQRCode(@RequestBody Request request) {
        try {
            // Validate URL
            if(!URLValidator.isValid(request.getUrl())) {
                return ResponseEntity.badRequest().body("Invalid URL.".getBytes());
            }

            byte[] qrCode = qrCodeService.generateQRCode(request.getUrl());
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG).body(qrCode);
        } catch (Exception e) {
            // Log exception
            return ResponseEntity.status(500).body("Error while generating QR code.".getBytes());
        }
    }

    @GetMapping("/test")
    public String test(){
        return "Up";
    }
}
