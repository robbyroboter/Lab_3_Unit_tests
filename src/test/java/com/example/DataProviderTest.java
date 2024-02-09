package com.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider(name = "numbers")
    public Object[][] dataProvider() {
        return new Object[][] {
                {2, 3}, // Набор данных 1: a=2, b=3
                {5, 7}, // Набор данных 2: a=5, b=7
                {10, 6} // Набор данных 3: a=10, b=5
        };
    }

    @Test(dataProvider = "numbers")
    public void testAdd(int a, int b) {
        int result = Arithmetic.add(a, b);
        System.out.println("Результат сложения: " + result);
    }

    @Test(dataProvider = "numbers")
    public void testMultiply(int a, int b) {
        int result = Arithmetic.multiply(a, b);
        System.out.println("Результат умножения: " + result);
    }
}
