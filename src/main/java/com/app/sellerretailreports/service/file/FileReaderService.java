package com.app.sellerretailreports.service.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileReaderService {
    public static String readFile(String fileName) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))) {
            String str = bufferedReader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
            bufferedReader.close();
            return str;
        } catch (IOException e) {
            throw new RuntimeException("Cannot read data from the file " + fileName, e);
        }
    }
}
