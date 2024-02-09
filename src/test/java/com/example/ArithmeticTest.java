package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticTest {
    @Test(groups = "arithmetic")
    public void testAdd() {
        Assert.assertEquals(Arithmetic.add(2, 3), 5);
    }

    @Test(groups = "arithmetic")
    public void testSubtract() {
        Assert.assertEquals(Arithmetic.subtract(5, 3), 2);
    }

    @Test(groups = "arithmetic")
    public void testMultiply() {
        Assert.assertEquals(Arithmetic.multiply(3, 3), 6);
    }
}
