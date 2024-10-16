package se.lisau.adventure_game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SouthRoom implements Directions {
    private final Scanner sc;

    public SouthRoom(Scanner sc) {
        this.sc = new Scanner(System.in);
    }

    @Override
    public void welcomeToRoom() {
        System.out.println("Welcome to South!");
        System.out.println("Hope your geography skills are on point");
    }

    @Override
    public void roomTask() {
        System.out.println("How many countries are fully or partially located in Europe?");
        boolean running = true;
        while (running) {
            int answer = 0;
            try {
                answer = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                sc.nextLine();
                continue;
            }
            if (answer == 50) {
                System.out.println("Right answer, here is another one.");
                System.out.println("How many of those countries have their capital cities on the European continent?");
                boolean running2 = true;
                while (running2) {
                    try {
                        answer = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid number");
                        sc.nextLine();
                        continue;
                    }
                    if (answer == 44) {
                        System.out.println("That is correct!");
                        System.out.println("---going back---");
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
