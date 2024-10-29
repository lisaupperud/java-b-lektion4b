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
    private static final String NORTH = "north"; // behöver inte vara static
    private static final String SOUTH = "south"; // kan vara lokala variabler i resp. metod
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
            System.out.println("...you're met with a snowstorm...");
            System.out.println("...a big wall of ice towers before you...");
            nr.welcomeToRoom();
            nr.roomTask();
            fight.fightJetiInNorthRoom(currentPlayer);
            fight.resetPlayerDamage(currentPlayer);
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
            fight.fightSeaSnakeInSouthRoom(currentPlayer);
            fight.resetPlayerDamage(currentPlayer);
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
            fight.resetPlayerDamage(currentPlayer);
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
            fight.resetPlayerDamage(currentPlayer);
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










