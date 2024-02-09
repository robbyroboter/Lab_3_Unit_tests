package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringsTest {
    @Test(groups = "strings")
    public void testUnite() {
        Assert.assertEquals(Strings.unite("John", "Jameson"), "John Jameson");
    }

    @Test(groups = "strings")
    public void testReverse() {
        Assert.assertEquals(Strings.reverse("John", "Jameson"), "nosemaJ nhoJ");
    }
}
