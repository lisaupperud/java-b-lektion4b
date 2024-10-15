package se.lisau.adventure_game;

import java.util.Scanner;

// huvudklass för spelet

// hanterar spellogiken

public class AdventureGame {
    // scanner-objekt för all UI
    private final Scanner sc;
    private final NorthRoom nr;
    private final SouthRoom sr;
    private final EastRoom er;
    private final WestRoom wr;


    // konstruktor för klassen AdventureGame
    public AdventureGame() {
        this.sc = new Scanner(System.in);
        this.nr = new NorthRoom(sc);
        this.sr = new SouthRoom(sc);
        this.er = new EastRoom(sc);
        this.wr = new WestRoom(sc);
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

    // metod för att gå norr
    private String goNorth() {
        System.out.println("Choice was go North -> calls for goNorth method");
        System.out.println("Welcome to the North Room");
        String result = "";
        System.out.println("Calls for roomTask-method in NorthRoom-class");
        nr.roomTask();
        return result;
    }

    // metod för att gå söder
    private String goSouth() {
        System.out.println("Welcome to the South Room");
        String result = "";
        sr.roomTask();
        return result;
    }

    // metod för att gå öst
    private String goEast() {
        System.out.println("Welcome to the East Room");
        String result = "";
        er.roomTask();
        return result;
    }

    // metod för att gå väst
    private String goWest() {
        System.out.println("Welcome to the West Room");
        String result = "";
        wr.roomTask();
        return result;
    }


    // metod för att stänga scanner
    public void closeScanner() {
        sc.close();
    }

}










