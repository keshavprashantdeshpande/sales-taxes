package com.codingchallenge.file.reader.exception;

/**
 * Custom exception which will be thrown when the contents in the input file is not in the given format or regex
 */
public class WrongInputFormatException extends Exception {

    public WrongInputFormatException() {
    }

    public WrongInputFormatException(String message) {
        super(message);
    }
}
