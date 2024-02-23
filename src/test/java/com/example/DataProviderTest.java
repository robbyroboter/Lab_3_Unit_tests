package com.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
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

    @Test(dataProvider = "cornersData")
    public void testCorners(double[] dataOne) {
        double[] expected = {0.5235987755982989, 2.617993877991494};
        double[] result = Arithmetic.corners(dataOne);
        if(Arrays.equals(expected,result)) System.out.println("Углы сходятся");
        else System.out.println("Данные углов не совпадают");
    }

    @Test(dataProvider = "dividesData")
    public void testDivides(double x) {
        x = (int) x;
        double[] expected = {7.074532511816069, 1.370130834582232};
        double[] result = Arithmetic.divides(x);
        //Assert.assertEquals(result,expected,0.0001)
        if(Arrays.equals(expected,result)) System.out.println("Точки разрывов совпадают");
        else System.out.println("Разрывы не совпадают");
    }

    private Object[][] readCSV(String fileName) throws IOException {
        String csvFile = "src/main/resources/data/" + fileName;
        String line;
        String cvsSplitBy = ";";

        List<Object[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(cvsSplitBy);
                double[] doubleValues = new double[values.length];
                for (int i = 0; i < values.length; i++) {
                    doubleValues[i] = Double.parseDouble(values[i]);
                }
                Object[] objectValues = new Object[doubleValues.length];
                for (int i = 0; i < doubleValues.length; i++) {
                    objectValues[i] = doubleValues[i];
                }
                data.add(objectValues);
            }
        }

        return data.toArray(new Object[data.size()][]);
    }
}
