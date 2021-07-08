package com.vitsed;

public class Calculator {

    public String add(String a, String b) {
        String result;
        try {
            result = (Integer.parseInt(a) + Integer.parseInt(b)) + "";
        } catch (Exception e) {
            result  = "Недопустимое выражение!";
        }
        return result;
    }

    public String mult(String a, String b) {
        String result;
        try {
            result = String.valueOf(Integer.parseInt(a) * Integer.parseInt(b));
        } catch (Exception e) {
            result  = "Недопустимое выражение!";
        }
        return result;
    }

    public String div(String a, String b) {
        String result;
        try {
            result = (Integer.parseInt(a) / Integer.parseInt(b)) + "";
        } catch (Exception e) {
            result  = "Недопустимое выражение!";
        }
        return result;
    }

    public String sub(String a, String b) {
        String result;
        try {
            result = (Integer.parseInt(a) - Integer.parseInt(b)) + "";
        } catch (Exception e) {
            result  = "Недопустимое выражение!";
        }
        return result;
    }

}
