package com.aikata.qrcode.service;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.springframework.stereotype.Service;

@Service
public class QRCodeService {

    public byte[] generateQRCode(String url) {
        return QRCode.from(url).to(ImageType.PNG).stream().toByteArray();
    }
}