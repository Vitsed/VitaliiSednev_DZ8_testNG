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

    @DataProvider
    public Object[][] testAddEquals() {
        return new Object[][]{
                {5, 2, 3},
                {-1, 2, -3},
                {10, 5, 5},
                {-5, 10, -15},
                {0, 10, -10},
                {-5, -2, -3},
                {100, 1, 99},
                {-100, -50, -50}
        };
    }

    @DataProvider
    public Object[][] testSubEquals() {
        return new Object[][]{
                {-1, 2, 3},
                {5, 2, -3},
                {0, 5, 5},
                {-5, 10, 15},
                {-20, -10, 10},
                {1, -2, -3},
                {100, 101, 1},
                {-100, 50, 150}
        };
    }

    @DataProvider
    public Object[][] testMultEquals() {
        return new Object[][]{
                {6, 2, 3},
                {-6, 2, -3},
                {25, 5, 5},
                {0, 0, -15},
                {-100, -10, 10},
                {6, -2, -3},
                {144, 12, 12},
                {0, -50, 0}
        };
    }

    @DataProvider
    public Object[][] testDivEquals() {
        return new Object[][]{
                {2, 6, 3},
                {-3, 9, -3},
                {1, 5, 5},
                {5, 10, 2},
                {0, 0, -10},
                {1, -3, -3},
                {10, 100, 10},
                {-1, -50, 50}
        };
    }

    @DataProvider
    public Object[][] testNotEquals() {
        return new Object[][]{
                {100, 2, 3},
                {1, 2, -3},
                {-10, 5, 5},
                {5, 10, -15},
                {10, 10, -10},
                {5, -2, -3},
                {-100, 1, 99},
                {100, -50, -50}
        };
    }

    @Test(dataProvider = "testAddEquals")
    public void testAdd(int sum, int firstTerm, int secondTerm) {
        Assert.assertEquals(sum, new Calculator().add(firstTerm, secondTerm), "Значения не равны!");
    }

    @Test(dataProvider = "testNotEquals")
    public void testNotAdd(int sum, int firstTerm, int secondTerm) {
        Assert.assertNotEquals(sum, new Calculator().add(firstTerm, secondTerm));
    }


    @Test(dataProvider = "testSubEquals")
    public void testSub(int dif, int reduced, int sub) {
        Assert.assertEquals(dif, new Calculator().sub(reduced, sub), "Значения не равны!");
    }

    @Test(dataProvider = "testNotEquals")
    public void testNotSub(int dif, int reduced, int sub) {
        Assert.assertNotEquals(dif, new Calculator().sub(reduced, sub), "Значения равны!");
    }

    @Test(dataProvider = "testMultEquals")
    public void testMult(int product, int multiplier1, int multiplier2) {
        Assert.assertEquals(product, new Calculator().mult(multiplier1, multiplier2), "Значения не равны!");
    }

    @Test(dataProvider = "testNotEquals")
    public void testNotMult(int product, int multiplier1, int multiplier2) {
        Assert.assertNotEquals(product, new Calculator().mult(multiplier1, multiplier2), "Значения равны!");
    }

    @Test(dataProvider = "testDivEquals")
    public void testDiv(int quotient, int divisible, int divisor) {
        Assert.assertEquals(quotient, new Calculator().div(divisible, divisor), "Значения не равны!");
    }

    @Test(dataProvider = "testNotEquals")
    public void testNotDiv(int quotient, int divisible, int divisor) {
        Assert.assertNotEquals(quotient, new Calculator().div(divisible, divisor), "Значения равны!");
    }
}