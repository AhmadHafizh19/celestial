package org.example;

//public class Main {
//    public static void main(String[] args) {
//        System.out.printf("Hello, World!");
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//
//        int age = 25;
//        long population = 7800000000L;
//        float price = 19.99f;
//        double pi = 3.14159;
//        char initial = 'A';
//        boolean isJavaFun = true;
//        String greeting = "Hello, World!";
//        int[] numbers = {1, 2, 3, 4, 5};
//
//        System.out.println(age);
//        System.out.println(population);
//        System.out.println(price);
//        System.out.println(pi);
//        System.out.println(initial);
//        System.out.println(isJavaFun);
//        System.out.println(greeting);
//        System.out.print("Array: " + java.util.Arrays.toString(numbers));
//    }
//}

public class Main {
    public static void main(String[] args) {

        // Arithmetic Operations
        int sum = 10241321 + 123123123;
        int multiply = 123 * 123;

        // Relational Operations
        boolean isEqual = 123 == 123;
        boolean isGreater = 123 > 100;

        // Logical Operations
        boolean andOperation = (5 < 3) && (2 < 4);
        boolean orOperation = (5 < 3) || (2 < 4);

        //bitwise Operations
        int bitwiseAnd = 5 & 3;
        int bitwiseOr = 5 | 3;

        System.out.println("Sum: " + sum);
        System.out.println("Multiply: " + multiply);
        System.out.println("Is Equal: " + isEqual);
        System.out.println("Is Greater: " + isGreater);
        System.out.println("AND Operation: " + andOperation);
        System.out.println("OR Operation: " + orOperation);
        System.out.println("Bitwise AND: " + bitwiseAnd);
        System.out.println("Bitwise OR: " + bitwiseOr);

    }
}