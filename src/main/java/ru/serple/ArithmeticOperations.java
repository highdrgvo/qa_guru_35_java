package ru.serple;

public class ArithmeticOperations {
    public static void main(String... args) {

        // Выполнить несколько арифметических операций, в том числе с использованием double
        int sum = 2 + 3;
        System.out.println(sum);

        System.out.println(5/3);

        int firstNumber = 20;
        int secondNumber = 5;
        System.out.println(firstNumber - secondNumber);
        System.out.println(firstNumber * secondNumber);

        double thirdNumber = 5.3;
        double subtraction = thirdNumber - firstNumber;
        System.out.println(subtraction);

        // Выполнение нескольких логических операций
        System.out.println(secondNumber > firstNumber);
        System.out.println(subtraction <= firstNumber);

        if (subtraction > 0) {
            System.out.println("subtraction is more than zero");
        } else {
            System.out.println("subtraction is less than zero");
        }

        // Переполнение при арифметической операции с float
        float f = 0.0f;
        for (int i=1; i < 7; i ++) {
            f += 0.1111111111;
        }
        System.out.println(f);

        // Та же операция с double
        double d = 0.0;
        for (int i=1; i < 7; i ++) {
            d += 0.1111111111;
        }
        System.out.println(d);

        // Переполнение при арифметической операции с int

        int number1 = 1000000;
        int number2 = 70000000;
        int multiplication = number1 * number2;
        System.out.println(multiplication);

        // Та же операция с long

        long longNumber1 = 9999999999999L;
        long longNumber2 = 9223372036854775807L;
        long longMultiplication = longNumber1 * longNumber2;
        System.out.println(longMultiplication);


    }
}
