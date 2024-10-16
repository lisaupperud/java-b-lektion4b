package se.lisau.adventure_game;

import java.util.Scanner;

public class EastRoom implements Directions{
    private final Scanner sc;
    public EastRoom(Scanner sc){
        this.sc = sc;
    }

    @Override
    public void welcomeToRoom() {
        System.out.println("Welcome to the East, where you will have to climb a mountain to get back.");
        System.out.println("What do you know about the Alps?\n First question:");
    }

    @Override
    public void roomTask() {
        boolean running = true;
        while (running) {
            System.out.println("Is Matterhorn the tallest mountain in the Alps? Y/N");
            String answer = sc.nextLine().toLowerCase();
            if (answer.equals("n")) {
                System.out.println("Correct!\n You're halfway up!\n Which is the tallest mountain in the Alps?");
                boolean running2 = true;
                while (running2) {
                    answer = sc.nextLine().toLowerCase();
                    if (answer.equals("mont blanc")) {
                        System.out.println("You've made it to the top!");
                        System.out.println("---going back---");
                        running = false;
                        running2 = false;
                    } else{
                        System.out.println("Wrong answer. Try again.");
                    }
                }

            } else {
                System.out.println("Wrong answer. Try again.");
            }

        }
    }
}
