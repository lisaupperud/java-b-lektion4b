package se.lisau.adventure_game;

import java.util.Scanner;

public class WestRoom implements Directions{
    private final Scanner sc;
    public WestRoom(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void roomTask() {
        boolean running = true;
        while (running) {
            System.out.println("How many kilometers is one mile?");
            double answer = sc.nextDouble();
            sc.nextLine();
            // behövs en try-catch ifall man trycker punkt istället för komma
            if (answer == 1.6) {
                System.out.println("Congratulations! You got it! You can now leave.");
                running = false;
            } else {
                System.out.println("Wrong answer. Try again.");
            }

        }
    }
}
