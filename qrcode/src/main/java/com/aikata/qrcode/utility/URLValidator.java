package com.aikata.qrcode.utility;

import java.net.MalformedURLException;

public class URLValidator {

    public static boolean isValid(String url) throws MalformedURLException {
        try {
            new java.net.URL(url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}