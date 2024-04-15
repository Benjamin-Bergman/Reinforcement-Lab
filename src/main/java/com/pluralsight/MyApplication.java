// Copyright (c) Benjamin Bergman 2024.

package com.pluralsight;

import java.util.*;
import java.util.function.*;

public class MyApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = get("Enter your name: ", sc::nextLine);
        int age = get("Enter your age: ", sc::nextInt);

        System.out.printf("Hello, %s! You are %d years old.%n", name, age);

        printVotingStatus(age);

        System.out.println(getMessage(name, age));

        printWelcomeMessage(name);

        if (name.equalsIgnoreCase("Bob") && age >= 21)
            System.out.println("You are old enough to drink.");
        else
            System.out.println("You are not old enough to drink.");

        System.out.printf("The square root of %.2f is %.2f%n", 12.34, sqrt(12.34));

        System.out.printf("Is %.2f greater than %.2f? %s%n", 3.14, 1.41, gt(3.14, 1.41) ? "Yes" : "No");

        System.out.printf("%s, you are %swelcome here.%n", name, name.equalsIgnoreCase("Eve") ? "not " : "");

        System.out.printf("Your random number from 1 to 10 is %d.%n", randomBetween(1, 10));

        System.out.printf("The smaller of %.2f and %.2f is %.2f%n", 12.34, 12.35, min(12.34, 12.35));
    }

    private static <T> T get(String message, Supplier<T> func) {
        System.out.print(message);
        return func.get();
    }

    private static int randomBetween(int lowerBound, int upperBound) {
        return (int) (Math.random() * (upperBound - lowerBound)) + lowerBound;
    }

    private static double min(double a, double b) {
        return Math.min(a, b);
    }

    private static boolean gt(double a, double b) {
        return a > b;
    }

    private static double sqrt(double num) {
        return Math.sqrt(num);
    }

    private static void printWelcomeMessage(String name) {
        System.out.println(switch (name.toLowerCase()) {
            case "alice" -> "Welcome home, Alice.";
            case "bob" -> "Wanna grab a drink, Bob?";
            default -> "Hello, user.";
        });
    }

    private static void printVotingStatus(int age) {
        if (age >= 18)
            System.out.println("You are old enough to vote.");
        else
            System.out.println("You are not old enough to vote.");
    }

    private static String getMessage(String name, int age) {
        return (switch (age) {
            case 0 -> "%s, you are brand new.";
            case 1, 2, 3, 4 -> "%s, you are pretty new.";
            case 5, 6, 7, 8, 9 -> "You're no longer a baby, %s!";
            case 10, 11, 12 -> "Wow, %s, you have a two-digit age.";
            case 13, 14, 15, 16, 17 -> "What's it like being a teen, %s?";
            case 18, 19, 20 -> "You're an adult, %s, but you're not old enough to drink.";
            default -> {
                if (age < 0)
                    yield "What kind of an age is %d?".formatted(age);
                yield "Wow, %s, you're old!";
            }
        }).formatted(name);
    }
}