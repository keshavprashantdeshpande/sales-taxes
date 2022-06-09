package com.codingchallenge.file.reader;

import com.codingchallenge.file.reader.exception.WrongInputFormatException;
import com.codingchallenge.file.reader.service.FileReaderService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderServiceTest {

    FileReaderService reader = new FileReaderService();

    @Test
    public void readFileTestWithCorrectInput() throws IOException {
        try {
            String[] inputLines = reader.readFile("input1.txt");
            assertEquals(3, inputLines.length);
            assertEquals("1 book at 12.49", inputLines[0]);
        } catch (WrongInputFormatException ex) {
            fail();
        }
    }

    @Test
    public void readFileWithWrongInput() throws IOException, WrongInputFormatException {
        assertThrows(WrongInputFormatException.class, () -> {
            reader.readFile("input4.txt");
        });
    }
}
