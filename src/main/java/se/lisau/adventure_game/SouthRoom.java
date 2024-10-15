package se.lisau.adventure_game;

import java.util.Scanner;

public class SouthRoom implements Directions {
    private final Scanner sc;
    public SouthRoom(Scanner sc) {
        this.sc = new Scanner(System.in);
    }

    @Override
    public void roomTask() {
        boolean running = true;
        while (running) {
            System.out.println("What is the capital city of Sweden?");
            String answer = sc.nextLine().toLowerCase();
            if (answer.equals("stockholm")) {
                System.out.println("Congratulations! You got it! You can now leave.");
                running = false;
            } else {
                System.out.println("Wrong answer. Try again.");
            }

        }

    }
}
