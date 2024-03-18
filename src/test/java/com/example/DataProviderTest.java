package com.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataProviderTest {

    @DataProvider(name = "cornersData")
    public Object[][] cornersDataProvider() throws IOException {
        return readCSV("TestCorners.csv");
    }

    @DataProvider(name = "dividesData")
    public Object[][] dividesDataProvider() throws IOException {
        return readCSV("TestDivides.csv");
    }

    // Обработка csv файл библиотекой
    private Object[][] readCSV(String fileName) throws IOException {
        List<double[]> data = new ArrayList<>();
        try (FileReader reader = new FileReader("src/test/resources/data/" + fileName);
             CSVParser csvParser = CSVFormat.DEFAULT.withDelimiter(';').parse(reader)) {
            for (CSVRecord csvRecord : csvParser) {
                double[] values = new double[csvRecord.size()];
                for (int i = 0; i < csvRecord.size(); i++) {
                    values[i] = Double.parseDouble(csvRecord.get(i));
                }
                data.add(values);
            }
        }
        Object[][] dataArray = new Object[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i] = new double[][]{data.get(i)};
        }
        return dataArray;
    }
}
