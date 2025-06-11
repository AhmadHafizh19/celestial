package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//        System.out.printf("Hello, World!");
//    }
//}

public class Main {
    public static void main(String[] args) {

        int age = 25;
        long population = 7800000000L;
        float price = 19.99f;
        double pi = 3.14159;
        char initial = 'A';
        boolean isJavaFun = true;
        String greeting = "Hello, World!";
        int[] numbers = {1, 2, 3, 4, 5};

        System.out.println(age);
        System.out.println(population);
        System.out.println(price);
        System.out.println(pi);
        System.out.println(initial);
        System.out.println(isJavaFun);
        System.out.println(greeting);
        System.out.print("Array: " + java.util.Arrays.toString(numbers));
    }
}