package se.lisau.adventure_game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NorthRoom implements Directions {
    private final Scanner sc;

    public NorthRoom(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void welcomeToRoom() {
        System.out.println("Welcome to the North!");
        System.out.println("How are you math skills? Let's see...");
    }

    @Override
    public void roomTask() {
        boolean running = true;
        while (running) {
            System.out.println("What is the square root of 49?");
            double answer = 0;
            try{
                answer = sc.nextDouble();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number!");
                // rensar felaktig inmatning
                sc.nextLine();
                continue;
            }
            if (answer == 7) {
                System.out.println("Congratulations! But what is the square root of 7?\\n Answer with Integer, comma, 3 decimals");
                boolean running2 = true;
                while (running2) {
                    try {
                        answer = sc.nextDouble();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a number!");
                        sc.nextLine();
                        continue;
                    }
                    if (answer == 2.645) {
                        System.out.println("Impressive! You may now return to the start-point.");
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

