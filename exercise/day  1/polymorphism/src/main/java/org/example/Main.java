package org.example;

class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("DENA W00F W00F!");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("MIAOWWW!");
    }
}

class Cow extends Animal {
    @Override
    void makeSound() {
        System.out.println("says MOOOOOOOOO!");
    }
}

class Calculator {
    void add(int a, int b) {
        System.out.println(a + b);
    }

    void add(double a, double b, double c) {
        double hasil = a + b + c;
        System.out.println((int)hasil);
    }

}

public class Main {
    public static void main(String[] args) {
        // polymorphism
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        Animal myCow = new Cow();
        Calculator mycalculator = new Calculator();


        myDog.makeSound();
        myCat.makeSound();
        mycalculator.add(5, 5);
        mycalculator.add(5.5, 5.6, 5.7);
    }
}