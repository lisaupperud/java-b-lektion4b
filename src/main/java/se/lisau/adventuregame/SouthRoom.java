package se.lisau.adventuregame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SouthRoom implements Directions {
    private final Scanner sc;

    public SouthRoom(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void welcomeToRoom() {
        System.out.println("Welcome to South!");
        System.out.println("You've upset the Sea Snake by coming here...");
        System.out.println("... get ready");
    }

    @Override
    public void roomTask() {
        System.out.println("How much of the Earth's surface is covered in ocean?\n Answer in %");
        boolean running = true;
        while (running) {
            int answer;
            try {
                answer = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                sc.nextLine();
                continue;
            }
            if (answer == 71) {
                System.out.println("Right answer, here is another one.");
                System.out.println("How deep is the Mariana Trench in meters?");
                boolean running2 = true;
                while (running2) {
                    try {
                        answer = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid number");
                        sc.nextLine();
                        continue;
                    }
                    if (answer == 11034) {
                        System.out.println("That is correct!");
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
