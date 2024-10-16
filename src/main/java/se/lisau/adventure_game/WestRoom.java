package se.lisau.adventure_game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WestRoom implements Directions{
    private final Scanner sc;
    public WestRoom(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void welcomeToRoom() {
        System.out.println("Welcome to the West!");
        System.out.println("In order to escape this room you will have to answer the following questions: ");
    }

    @Override
    public void roomTask() {
        boolean running = true;
        System.out.println("How many kilos are 10 tons?");
        int answer = 0;
        while (running) {
            try {
                answer = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                sc.nextLine();
                continue;
            }
            if (answer == 10000) {
                System.out.println("Congratulations! You got it! Next question: ");
                System.out.println("How many meters is in 150 metric miles?");
                boolean running2 = true;
                while (running2) {
                    try {
                        answer = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a number.");
                        sc.nextLine();
                        continue;
                    }
                    if (answer == 150000) {
                        System.out.println("Right answer! You can now leave.");
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
