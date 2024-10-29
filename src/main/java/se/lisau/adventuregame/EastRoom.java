package se.lisau.adventuregame;

import java.util.Scanner;

public class EastRoom implements Directions {
    private final Scanner sc;

    public EastRoom(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void welcomeToRoom() {
        System.out.println("Welcome to the East, where an angry troll is waiting for you");
        System.out.println("Answer the following questions correct and you will be rewarded with a weapon.");
    }

    @Override
    public void roomTask() {
        boolean running = true;
        System.out.println("Is the California Redwood the tallest trees in the world? Y/N");
        while (running) {
            String answer = sc.nextLine().toLowerCase();
            if (answer.equals("n")) {
                System.out.println("Correct!\n Which is the tallest trees in the world?");
                boolean running2 = true;
                while (running2) {
                    answer = sc.nextLine().toLowerCase();
                    if (answer.equals("hyperion")) {
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
