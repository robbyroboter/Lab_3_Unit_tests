package com.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

    @Test(dataProvider = "cornersData")
    public void testCorners(double[] dataOne) {
        double[] expected = {0.5235987755982989, 2.617993877991494};
        double[] result = Arithmetic.corners(dataOne);
        if (compareArrays(expected, result))
            System.out.println("Углы сходятся");
        else
            System.out.println("Данные углов не совпадают");
    }

    @Test(dataProvider = "dividesData")
    public void testDivides(double[] data) {
        double x = data[0];
        double[] expected = {7.074532511816069, 1.370130834582232};
        double[] result = Arithmetic.divides(x);
        if (compareArrays(expected, result))
            System.out.println("Точки разрывов совпадают");
        else
            System.out.println("Разрывы не совпадают");
    }

    private boolean compareArrays(double[] arr1, double[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (Math.abs(arr1[i] - arr2[i]) > 0.0001)
                return false;
        }
        return true;
    }

    private Object[][] readCSV(String fileName) throws IOException {
        List<double[]> data = new ArrayList<>();
        try (FileReader reader = new FileReader("src/main/resources/data/" + fileName);
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
