package se.lisau.adventuregame;


import java.util.InputMismatchException;
import java.util.Scanner;

public class NorthRoom implements Directions {
    private final Scanner sc;
    // borde monster deklareras i rummet dem tillhör?
    // Creature jeti = new Monster("Jeti", 100, 25);

    public NorthRoom(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void welcomeToRoom() {
        System.out.println("Welcome to the North!");
        System.out.println("A big Jeti is waiting for you. \n By answering these questions right you will receive a weapon to kill the Jeti and get back to the Town Centre");
    }

    @Override
    public void roomTask() {
        boolean running = true;
        while (running) {
            System.out.println("At what temperature does ice melt in Celsius?");
            int answer;
            try {
                answer = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number!");
                // rensar felaktig inmatning
                sc.nextLine();
                continue;
            }
            if (answer == 0) {
                System.out.println("Congratulations! But at what temperature does ice melt in Fahrenheit?");
                boolean running2 = true;
                while (running2) {
                    try {
                        answer = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a number!");
                        sc.nextLine();
                        continue;
                    }
                    if (answer == 32) {
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

