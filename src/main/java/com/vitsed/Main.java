package com.vitsed;

import java.util.Scanner;

public class Main {
    static int counter = 0;
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        startProgram(calculator);
    }

    public static String  helper(String text, Calculator calculator) {
        if(text == null) {
            System.out.println("Недопустимое поведение программы!");
            return null;
        }
        if("quit".equalsIgnoreCase(text)) {
            return "quit";
        }
        String a = null;
        String b = null;
        String sign = null;
        try {
            String[] prepareText = text.split(" ");
            a = prepareText[0];
            b = prepareText[2];
            sign = prepareText[1];
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
                if(counter > 5) {
                    showHelpMessage();
                    counter = 0;
                }
                counter++;
                return "Неизвестная операция!";

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
