package com.vitsed;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest {

    @BeforeClass
    public void showMessage() {
        System.out.println("Testing started");
    }

    @AfterClass
    public void endMessage() {
        System.out.println("Testing finished");
    }

    private static Object[][] fitTaskEqualizer(Object[][] o) {
        Object[][] test = o;
        for (int i = 0; i < test.length; i++) {
            for (int t = 0; t < test[i].length; t++) {
                if (test[i][t] == null || test[i][t].getClass().equals(String.class)) {
                    continue;
                } else {
                    test[i][t] += "";
                }
            }
        }
        return test;
    }

    @DataProvider
    public Object[][] testAddEquals() {
        Object[][] objects = new Object[][]{
                {5, 2, 3},
                {-1, 2, -3},
                {10, 5, 5},
                {-5, 10, -15},
                {0, 10, -10},
                {-5, -2, -3},
                {100, 1, 99}
        };


        return fitTaskEqualizer(objects);
    }

    @DataProvider
    public Object[][] testSubEquals() {
        Object[][] objects = new Object[][]{
                {-1, 2, 3},
                {5, 2, -3},
                {0, 5, 5},
                {-5, 10, 15},
                {-20, -10, 10},
                {1, -2, -3},
                {100, 101, 1},
                {-100, 50, 150}
        };
        return fitTaskEqualizer(objects);
    }

    @DataProvider
    public Object[][] testMultEquals() {
        Object[][] objects = new Object[][]{
                {6, 2, 3},
                {-6, 2, -3},
                {25, 5, 5},
                {0, 0, -15},
                {-100, -10, 10},
                {6, -2, -3},
                {144, 12, 12},
                {0, -50, 0}
        };
        return fitTaskEqualizer(objects);
    }

    @DataProvider
    public Object[][] testDivEquals() {
        Object[][] objects = new Object[][]{
                {2, 6, 3},
                {-3, 9, -3},
                {1, 5, 5},
                {5, 10, 2},
                {0, 0, -10},
                {1, -3, -3},
                {10, 100, 10},
                {-1, -50, 50}
        };
        return fitTaskEqualizer(objects);
    }


    @DataProvider
    public Object[][] negativeTest() {
        return new Object[][]{
                {"Недопустимое выражение!", "один", "два"},
                {"Недопустимое выражение!", "5", "два"},
                {"Недопустимое выражение!", "один", "1251"}
        };
    }

    @Test(dataProvider = "testAddEquals")
    public void testAdd(String sum, String firstTerm, String secondTerm) {
        Assert.assertEquals(sum + "", new Calculator().add(firstTerm, secondTerm), "Значения не равны!");
    }

    @Test(dataProvider = "testSubEquals")
    public void testSub(String dif, String reduced, String sub) {
        Assert.assertEquals(dif, new Calculator().sub(reduced, sub), "Значения не равны!");
    }

    @Test(dataProvider = "testMultEquals")
    public void testMult(String product, String multiplier1, String multiplier2) {
        Assert.assertEquals(product, new Calculator().mult(multiplier1, multiplier2), "Значения не равны!");
    }

    @Test(dataProvider = "testDivEquals")
    public void testDiv(String quotient, String divisible, String divisor) {
        Assert.assertEquals(quotient, new Calculator().div(divisible, divisor), "Значения не равны!");
    }

    @Test(dataProvider = "negativeTest")
    public void testNegative(String result, String number1, String number2) {
        Assert.assertEquals(result, new Calculator().add(number1, number2), "Значения не равны!");
        Assert.assertEquals(result, new Calculator().div(number1, number2), "Значения не равны!");
        Assert.assertEquals(result, new Calculator().sub(number1, number2), "Значения не равны!");
        Assert.assertEquals(result, new Calculator().mult(number1, number2), "Значения не равны!");
    }
}