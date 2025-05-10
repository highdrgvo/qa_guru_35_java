package ru.serple;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Human sergey = new Human(
                "Sergey",
                5,
                true
        );

        List<String> lectures = new ArrayList<>();
        lectures.add("git");
        lectures.add("java");
        lectures.add("files");
        lectures.add("junit");

        Set<String> lectureSet = Set.of("git", "java", "files", "junit"); // Нельзя добавить хотя бы один одинаковый объект. Если по бизнес логике надо добавить список, где не должно использоваться одинаковых объектов, то тогда Set.

        Map<String, Human> humans = new HashMap<>();
        humans.put("445553", sergey);
        humans.put("324234", sergey);
        humans.put("44551231", sergey);
        humans.put("64234234", sergey);

        for (Map.Entry<String, Human> entry : humans.entrySet()) {

            entry.getKey();
            entry.getValue();
        }

        for (String key : humans.keySet()) {

        }

        // Почитать про Map, List, Set. Всегда на собесах про это спрашивают.



        int hours = 12;
        String hello = "Hello";

        sergey.printSomeValue(hours, hello, lectures);
//        Human sergey = new Human("", 34, true); // В джаве любой объект создается через слово new
//        System.out.println(sergey);
//        sergey = sergey.incrementAge();
//        System.out.println(sergey);


//        System.out.println("After method, int: " + hours);
//        System.out.println("After method, string: " + hello);

        String[] lecturesArray = new String[] {"git", "java", "files", "junit"};// у массива должна быть задана длина

        lecturesArray[0] = "git";
        lecturesArray[1] = "java";
        lecturesArray[2] = "files";
        lecturesArray[3] = "junit";

        int[] intArray0 = new int[] {1, 2, 3};
        int[] intArray1 = new int[] {1, 2, 3};

        int[][] biArray = new int[][] {intArray0, intArray1}; // двумерный массив


//        for (int i = 0; i < lecturesArray.length; i++) {
//            System.out.println(lecturesArray[i]);
//        }
//
//        for (int i = lecturesArray.length - 1; i >= 0; i--) {
//            System.out.println(lecturesArray[i]);
//        }

        for (String lectureName : lecturesArray) {

            if (lectureName.startsWith("j")) {
                System.out.println(lectureName);
                break;
            }
        }

//        int i = 0;
//        while (i < lecturesArray.length) {
//            System.out.println(lecturesArray[i]);
//            i++;
//        }

        }
}
