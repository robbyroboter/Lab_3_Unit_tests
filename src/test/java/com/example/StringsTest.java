package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringsTest {
    @Test(groups = "strings")
    public void testUnite() {
        char[][] dataOne = {{'f','*'}, {'f','-'}};
        int actualCount = Strings.countArgs(dataOne);
        Assert.assertEquals(actualCount,3);
    }

    @Test(groups = "strings")
    public void testReverse() {
        String s= "Мама мыла раму в ООО «Рама», а папа мыл машину в ЗАО «Машина».";
        Assert.assertEquals(Strings.change(s), "Мама мыла раму в ООО «фирма», а папа мыл машину в ЗАО «фирма».");
    }
}
