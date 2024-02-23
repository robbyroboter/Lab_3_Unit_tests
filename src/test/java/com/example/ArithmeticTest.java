package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticTest {
    @Test(groups = "arithmetic")
    public void testCorners() {
        double[] expected = {0.5235987755982989, 2.617993877991494};
        double[] dataOne = {2, 3, 10, 2, 3};
        double[] actual = Arithmetic.corners(dataOne);
        Assert.assertEquals(actual.length, 2);
        Assert.assertEquals(actual, expected, 0.0001); // delta задан как 0.0001
    }

    @Test(groups = "arithmetic")
    public void testDivides() {
        double[] expected = {7.07453251181606, 1.370130834582232};
        double x = 1;
        double[] actual = Arithmetic.divides(x);
        Assert.assertEquals(actual.length, 2);
        Assert.assertEquals(actual, expected, 0.0001); // delta задан как 0.0001
    }

    @Test(groups = "arithmetic")
    public void testSort() {
        int[] testArray = {4, 2, 7, 1, 5}; // Тестовый массив
        int[] sortedArray = Arithmetic.sort(testArray); // Вызов метода сортировки
        // Проверка, что массив отсортирован
        for (int i = 0; i < sortedArray.length - 1; i++) {
            Assert.assertTrue(sortedArray[i] <= sortedArray[i + 1]);
        }
    }
}
