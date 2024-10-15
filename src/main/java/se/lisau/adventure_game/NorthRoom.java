package se.lisau.adventure_game;

import java.util.Scanner;

public class NorthRoom implements Directions {
    private final Scanner sc;
    public NorthRoom(Scanner sc) {
        this.sc = sc;
    }
    @Override
    public void roomTask() {
        boolean running = true;
        while (running) {
            System.out.println("What is 35*45?");
            int answer = sc.nextInt();
            sc.nextLine();
            if (answer == 1575) {
                System.out.println("Congratulations! You got it!");
                System.out.println("..going back to center.");
                running = false;
            } else {
                System.out.println("Wrong answer. Try again.");
            }

        }
    }
}
