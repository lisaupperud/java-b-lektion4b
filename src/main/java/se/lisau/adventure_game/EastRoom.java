package se.lisau.adventure_game;

import java.util.Scanner;

public class EastRoom implements Directions{
    private final Scanner sc;
    public EastRoom(Scanner sc){
        this.sc = sc;
    }

    @Override
    public void roomTask() {
        boolean running = true;
        while (running) {
            System.out.println("Is Matterhorn the tallest mountain in the Alps? Y/N");
            String answer = sc.nextLine().toLowerCase();
            if (answer.equals("n")) {
                System.out.println("Congratulations! You got it! You can now leave.");
                running = false;
            } else {
                System.out.println("Wrong answer. Try again.");
            }

        }
    }
}
