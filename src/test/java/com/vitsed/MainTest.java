package com.vitsed;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest {

    @DataProvider
    public Object[][] dataHelper() {
        return new Object[][] {
                {"quit", "quit"},
                {"quit", "QUIT"},
                {"Сумма 10", "5 + 5"},
                {"Разность 8", "10 - 2"},
                {"Частное 5", "10 / 2"},
                {"Произведение 20", "10 * 2"},
                {"Неизвестная операция!", "asd asd asdf ahl"},
                {null, null}
        };
    }

    @Test(dataProvider = "dataHelper")
    public void testHelper(String info, String value) {
        Assert.assertEquals(info, Main.helper(value, new Calculator()));
    }

    @Test
    public void testStartProgram() {
    }
}