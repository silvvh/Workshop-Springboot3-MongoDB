package com.silvvh.workshopmongo.resources.util;

import org.springframework.cglib.core.Local;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class URL {
    public static String decodeParam(String text) {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    public static LocalDate convertDate(String textDate, LocalDate defaultValue) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dateTimeFormatter.withZone(ZoneId.systemDefault());
        try {
            return LocalDate.parse(textDate, dateTimeFormatter);
        }
        catch (DateTimeParseException e) {
            return defaultValue;
        }
    }
}