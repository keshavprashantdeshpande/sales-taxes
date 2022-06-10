package com.codingchallenge.file.reader.service;

import com.codingchallenge.file.reader.exception.WrongInputFormatException;
import com.codingchallenge.util.helper.HelperClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class FileReaderService {

    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String REGEX_FOR_INPUT = "\\d*\\s+[\\w\\s]+at \\d+\\.\\d{2}";

    public String[] readFile(String... args) throws IOException, WrongInputFormatException {
        String[] lines = null;
        for (String fileName : args) {
            log.info("Reading file with name: {}", fileName);
            Resource resource = new ClassPathResource(fileName);
            InputStream inputStream = resource.getInputStream();
            try {
                byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
                String data = new String(bdata, StandardCharsets.UTF_8);
                lines = data.split(NEW_LINE_SEPARATOR);
                this.validateInput(lines);
            } catch (IOException ex) {
                log.error("Error occurred while reading file with name fileName {}", fileName, ex);
                throw new IOException("Error reading file with name " + fileName);
            }
        }
        return lines;
    }

    private void validateInput(String[] lines) throws WrongInputFormatException {
        for (String line : lines) {
            if (!HelperClass.validateRegex(line, REGEX_FOR_INPUT)) {
                throw new WrongInputFormatException("Input is not given in the expected format ");
            }
        }
    }
}
