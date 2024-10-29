package se.lisau.adventuregame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WestRoom implements Directions {
    private final Scanner sc;

    public WestRoom(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void welcomeToRoom() {
        System.out.println("Welcome to the West!");
        System.out.println("A big Scorpion is upset that you're here and waiting to attack");
        System.out.println("...answer the following question to receive your weapon");
    }

    @Override
    public void roomTask() {
        boolean running = true;
        System.out.println("What is the hottest recorded temperature in the Lut Desert?\n Answer in Celsius with one decimal");
        double answer;
        while (running) {
            try {
                answer = sc.nextDouble();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                sc.nextLine();
                continue;
            }
            if (answer == 70.7) {
                System.out.println("Congratulations! You got it! Next question: ");
                System.out.println("What is the lowest temperature recorded at night in the Lut Desert?\n Answer in Celsius");
                boolean running2 = true;
                while (running2) {
                    try {
                        answer = sc.nextDouble();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a number.");
                        sc.nextLine();
                        continue;
                    }
                    if (answer == -20) {
                        System.out.println("Right answer!");
                        running = false;
                        running2 = false;
                    } else {
                        System.out.println("Wrong answer. Try again.");
                    }
                }
            } else {
                System.out.println("Wrong answer. Try again.");
            }


        }
    }
}
