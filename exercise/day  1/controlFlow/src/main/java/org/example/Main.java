package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // if else statement
        int number = -1;
        if (number > 0) {
            System.out.println( number + " is positive.");
        } else if (number < 0) {
            System.out.println( number + " is negative.");
        } else {
            System.out.println( number + " is zero.");
        }

        int day = 3;
        String dayName;

        // switch case statement
        switch (day){
            case 1: dayName = "Monday"; break;
            case 2: dayName = "Tuesday"; break;
            case 3: dayName = "Wednesday"; break;
            case 4: dayName = "Thursday"; break;
            case 5: dayName = "Friday"; break;
            case 6: dayName = "Saturday"; break;
            case 7: dayName = "Sunday"; break;
            default: dayName = "Invalid day"; break;
        }
        System.out.println(dayName);

        // while loop
        int i = 2;
        while (i <= 10) {
            System.out.println("Hello World - " + i);
            i += 2;
        }

        //do while loop
        int j = 1;
        do {
            System.out.println("Peserta - " + j);
            j += 2;
        } while (j <= 10);
    }
}

