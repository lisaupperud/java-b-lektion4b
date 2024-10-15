package se.lisau.adventure_game;

public class Main {
    public static void main(String[] args) {
        AdventureGame game = new AdventureGame();
        game.menu();
        game.getDirections();
        game.closeScanner();
    }
}
