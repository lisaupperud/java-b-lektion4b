package se.lisau.adventuregame;

import java.util.Scanner;

public class EastRoom implements Directions{
    private final Scanner sc;
    public EastRoom(Scanner sc){
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
        System.out.println("Is Matterhorn the tallest mountain in the Alps? Y/N");
        while (running) {
            String answer = sc.nextLine().toLowerCase();
            if (answer.equals("n")) {
                System.out.println("Correct!\n You're halfway up!\n Which is the tallest mountain in the Alps?");
                boolean running2 = true;
                while (running2) {
                    answer = sc.nextLine().toLowerCase();
                    if (answer.equals("mont blanc")) {

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
