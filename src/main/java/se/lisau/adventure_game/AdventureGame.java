package se.lisau.adventure_game;

import java.util.Scanner;

// huvudklass för spelet
// hanterar spellogiken
public class AdventureGame {
    // scanner-objekt för all UI
    private final Scanner sc;

    // konstruktor för klassen AdventureGame
    public AdventureGame() {
        this.sc = new Scanner(System.in);
    }

    // metod för att utnyttja scanner i andra klasser
    public Scanner getScanner() {
        return this.sc;
    }

    // metod för menyn
    public void menu() {
        System.out.println("Please enter your player name: ");
        String playerName = sc.nextLine();
        System.out.println("Hi and welcome to the Adventure Game " + playerName + "!");
    }

    // metod för att låta användaren välja väderstreck
    public void getDirections() {
        boolean running = true;// variabel för while-loopen
        while (running) {
            System.out.println("Which direction would you like to go?");
            System.out.println("go north");
            System.out.println("go south");
            System.out.println("go east");
            System.out.println("go west");
            System.out.println("quit");
            String userInput = sc.nextLine().toLowerCase();

            String directions = switch (userInput) {
                case "go north" -> goNorth();
                case "go south" -> goSouth();
                case "go east" -> goEast();
                case "go west" -> goWest();
                case "quit" -> {
                    running = false;
                    yield "Exiting game...";
                }
                default -> "Invalid input. Try again.";
            };
            System.out.println(directions);
        }
    }

    private String goNorth() {
        System.out.println("In goNorth method");
        String result = "";
        boolean running = true;
        while (running) {
            System.out.println("Welcome to the North room");
            System.out.println("Would you like to:");
            System.out.println("A: stay");
            System.out.println("B: go back to center");
            String userInput = sc.nextLine().toLowerCase();
            if (userInput.equals("a")) {
                System.out.println("Staying...");
            } else if (userInput.equals("b")) {
                System.out.println("Going back to center...");
                running = false;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
        return result;
    }

    private String goSouth() {
        String result = "";
        boolean running = true;
        while (running) {
            System.out.println("Welcome to the South room");
            System.out.println("Would you like to:");
            System.out.println("A: stay");
            System.out.println("B: go back to center");
            String userInput = sc.nextLine().toLowerCase();
            if (userInput.equals("a")) {
                System.out.println("Staying...");
            } else if (userInput.equals("b")) {
                System.out.println("Going back to center...");
                running = false;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
        return result;
    }

    private String goEast() {
        String result = "";
        boolean running = true;
        while (running) {
            System.out.println("Welcome to the East room");
            System.out.println("Would you like to:");
            System.out.println("A: stay");
            System.out.println("B: go back to center");
            String userInput = sc.nextLine().toLowerCase();
            if (userInput.equals("a")) {
                System.out.println("Staying...");
            } else if (userInput.equals("b")) {
                System.out.println("Going back to center");
                running = false;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
        return result;
    }

    private String goWest() {
        String result = "";
        boolean running = true;
        while (running) {
            System.out.println("Welcome to the West room");
            System.out.println("Would you like to: ");
            System.out.println("A: stay");
            System.out.println("B: go back to center");
            String userInput = sc.nextLine().toLowerCase();
            if (userInput.equals("a")) {
                System.out.println("Staying...");
            } else if (userInput.equals("b")) {
                System.out.println("Going back to center...");
                running = false;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
        return result;
    }
    public void havingEnteredRoom(){

    }

    // metod för att stänga scanner
    public void closeScanner() {
        sc.close();
    }
}


