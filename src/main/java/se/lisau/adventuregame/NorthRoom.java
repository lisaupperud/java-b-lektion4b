package se.lisau.adventuregame;


import java.util.InputMismatchException;
import java.util.Scanner;

public class NorthRoom implements Directions {
    private final Scanner sc;
    private final Fight fight = new Fight();

    public NorthRoom(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void welcomeToRoom() {
        System.out.println("Welcome to the North!");
        System.out.println("A big Jeti is waiting for you. By answering these questions right you will receive a weapon to kill the Jeti");
        System.out.println("and get back to the Town Center");
    }

    @Override
    public void roomTask() {
        boolean running = true;
        while (running) {
            System.out.println("What is the square root of 49?");
            double answer;
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
                System.out.println("Congratulations! But what is the square root of 7?\n Answer with Integer, comma, 3 decimals");
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

