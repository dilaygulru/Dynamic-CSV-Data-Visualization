package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader implements AutoCloseable{
    private BufferedReader reader;
    private String currentLine;

    public CSVReader(String filePath) throws IOException {
        reader = new BufferedReader(new FileReader(filePath));

    }

    public Double getNextValue() throws IOException {
        if ((currentLine = reader.readLine()) != null) {
            String[] data = currentLine.split(",");
            return Double.parseDouble(data[0]);
        }
        return null;
    }

    public void close() throws IOException {
        reader.close();
    }
}
