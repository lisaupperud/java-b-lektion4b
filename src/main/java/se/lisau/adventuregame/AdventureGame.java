package se.lisau.adventuregame;

import se.lisau.adventuregame.model.Player;

import java.util.Scanner;

// huvudklass för spelet

// hanterar spellogiken

public class AdventureGame {
    // scanner-objekt för all UI
    private final Scanner sc = new Scanner(System.in);
    // rums-objekt
    private final NorthRoom nr;
    private final SouthRoom sr;
    private final EastRoom er;
    private final WestRoom wr;
    private static final String NORTH = "north";
    private static final String SOUTH = "south";
    private static final String EAST = "east";
    private static final String WEST = "west";
    private static final String TOWN_CENTRE = "town centre";
    private static final String START = "start";
    private String currentLocation = START;
    private Player currentPlayer;
    private final Fight fight;


    // konstruktor för klassen AdventureGame
    public AdventureGame() {
        //this.sc = new Scanner(System.in);
        this.nr = new NorthRoom(sc);
        this.sr = new SouthRoom(sc);
        this.er = new EastRoom(sc);
        this.wr = new WestRoom(sc);
        this.fight = new Fight();

    }

    // metod för menyn
    private void printWelcomeMenu() {
        System.out.println("Please enter your player name: ");
        String playerName = sc.nextLine();
        this.currentPlayer = new Player(playerName, 100, 20);
        System.out.println("Hi and welcome to the Adventure Game " + currentPlayer.getName() + "!");
    }

    // metod för att låta användaren välja väderstreck
    public void getDirections() {
        printWelcomeMenu();
        boolean running = true;// variabel för while-loopen
        while (running) {
            townCentre();
            System.out.println("go north");
            System.out.println("go south");
            System.out.println("go east");
            System.out.println("go west");
            System.out.println("quit");
            String userInput = sc.nextLine().toLowerCase();

            switch (userInput) {
                case "go north" -> goNorth();
                case "go south" -> goSouth();
                case "go east" -> goEast();
                case "go west" -> goWest();
                case "quit" -> {
                    running = false;
                    System.out.println("Exiting game...");
                }
                default -> System.out.println("Invalid input. Try again.");
            }
        }
    }

    private void townCentre() {
        if (!currentLocation.equals(TOWN_CENTRE)) {
            currentLocation = TOWN_CENTRE;
            System.out.println("---you're in the town centre---");
            System.out.println("---what would you like to do next?---");
        } else {
            wrongWay();
        }

    }

    private void wrongWay() {
        System.out.println("unable to go there now");
    }

    // metod för att gå norr
    private void goNorth() {
        if (currentLocation.equals(TOWN_CENTRE)) {
            System.out.println("---going north---");
            //System.out.println("Choice was go North -> calls for goNorth method");
            System.out.println("...you're going a dark room...");
            System.out.println("...the walls are lit up with questionmarks...");
            nr.welcomeToRoom();
            //System.out.println("Calls for roomTask-method in NorthRoom-class");
            nr.roomTask();
            fight.fightJetiInNorthRoom(currentPlayer);
            currentLocation = NORTH;
        } else {
            wrongWay();
        }

    }

    // metod för att gå söder
    private void goSouth() {
        if (currentLocation.equals(TOWN_CENTRE)) {
            System.out.println("---going south---");
            System.out.println("...you're going across a small sea...");
            System.out.println("...big waves crash onto the sides of your boat...");
            System.out.println("...the boat hits land...");
            sr.welcomeToRoom();
            sr.roomTask();
            fight.fightSnakeInSouthRoom(currentPlayer);
            currentLocation = SOUTH;
        } else {
            wrongWay();
        }
    }

    // metod för att gå öst
    private void goEast() {
        if (currentLocation.equals(TOWN_CENTRE)) {
            System.out.println("---going east---");
            System.out.println("...you've gone deep into the woods surrounded by tall trees...");
            System.out.println("...there's an opening in front of you, light is sipping through the branches...");
            er.welcomeToRoom();
            er.roomTask();
            fight.fightTrollInEastRoom(currentPlayer);
            currentLocation = EAST;
        } else {
            wrongWay();
        }

    }

    // metod för att gå väst
    private void goWest() {
        if (currentLocation.equals(TOWN_CENTRE)) {
            System.out.println("---going west---");
            System.out.println("...there is a long road ahead of you...");
            System.out.println("...desert surrounding you everywhere you look...");
            System.out.println("...the sun is blinding your eyes and burning your neck...");
            wr.welcomeToRoom();
            wr.roomTask();
            fight.fightScorpionInWestRoom(currentPlayer);
            currentLocation = WEST;
        } else {
            wrongWay();
        }

    }

    // metod för att stänga scanner
    public void closeScanner() {
        sc.close();
    }

}










