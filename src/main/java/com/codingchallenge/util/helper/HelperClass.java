package com.codingchallenge.util.helper;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelperClass {

    @Autowired
    private static Matcher matcher;

    public static boolean validateRegex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
