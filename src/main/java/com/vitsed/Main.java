package com.vitsed;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        startProgram(calculator);
    }

    public static String  helper(String text, Calculator calculator) {
        if("quit".equalsIgnoreCase(text)) {
            return "quit";
        }
        Integer a = null;
        Integer b = null;
        String sign = null;
        try {
            String[] prepareText = text.split(" ");
            System.out.println(prepareText.length);
            a = Integer.parseInt(prepareText[0]);
            b = Integer.parseInt(prepareText[2]);
            sign = prepareText[1];
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Неправильный формат ввода\n");
            startProgram(calculator);
        } catch (Exception e) {
            System.out.println("Что-то пошло не так!\nПовторите операцию");
            startProgram(calculator);
        }

        switch (sign) {
            case "+":
                return ("Сумма " + calculator.add(a, b));
            case "-":
                return ("Разность " + calculator.sub(a, b));
            case "/":
                return ("Частное " + calculator.div(a, b));
            case "*":
                return ("Произведение " + calculator.mult(a, b));
            default:
                return "quit";

        }
    }

    public static void startProgram(Calculator calculator) {
        showHelpMessage();
        String quit = "start";

        do {
            System.out.println("Введите арифметическое действие: ");
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();
            if("quit".equalsIgnoreCase(text)) {
                break;
            } else if("help".equalsIgnoreCase(text)) {
                showHelpMessage();
            } else {
                quit = helper(text, calculator);
                System.out.println(quit);
            }
        } while (true);
    }

    private static void showHelpMessage() {
        System.out.println("Примеры:\n" +
                "2 + 2 - для сложения\n" +
                "2 - 2 - для вычитания\n" +
                "3 * 4 - для умножения\n" +
                "4 / 2 - для деления\n" +
                "quit - для выхода\n" +
                "help - подсказка\n");
    }
}
