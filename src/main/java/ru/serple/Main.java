package ru.serple;

public class Main {

    public static void main(String[] args) {

        Human sergey = new Human("", 34, true); // В джаве любой объект создается через слово new

        System.out.println(sergey);

        sergey = sergey.incrementAge();
        
        System.out.println(sergey);
    }
}
