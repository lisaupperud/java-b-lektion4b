package se.lisau.adventuregame;

import se.lisau.adventuregame.model.Creature;
import se.lisau.adventuregame.model.Monster;
import se.lisau.adventuregame.model.Player;

public class Fight {
    Creature jeti = new Monster("Jeti", 100, 25);
    Creature seaSnake = new Monster("SeaSnake", 100, 20);
    Creature troll = new Monster("Troll", 100, 15);
    Creature scorpion = new Monster("Scorpion", 100, 10);
    boolean fight;


    public void executeAttack(Creature attacker, Creature defender) {
        // om spelare attackerar så ska monsters health minska och damage öka
        try {
            attacker.attack(defender);
            Thread.sleep(1000);
            System.out.println(attacker.getName() + " attacks " + defender.getName());
            if (defender.isAlive()) {
                System.out.println(defender.getName() + " health: " + defender.getHealth());
            } else {
                System.out.println(defender.getName() + " is dead");
            }
        } catch (InterruptedException e) {
            System.out.println("The fight was interrupted");
            Thread.currentThread().interrupt();
        }

    }

    public void fightOneRound(Creature player, Creature defender) {
        // först är player = attacker och monster = defender
        executeAttack(defender, player);
        // om monster lever efter attacken
        // så blir monster = attacker och player = defender
        if (defender.isAlive()) {
            executeAttack(player, defender);

        }
    }

    public void fightJetiInNorthRoom(Player player) {
        player.setDamage(receiveSpear(player.getDamage()));
        fight = true;
        while (fight) {
            if (player.isAlive() && jeti.isAlive()) {
                fightOneRound(player, jeti);
                if (!jeti.isAlive()) {
                    restoreHealth(player);
                }
            } else {
                fight = false;
            }
        }
        resetMonsterHealth(jeti);
    }

    public void fightSeaSnakeInSouthRoom(Player player) {
        // fightas mot snake
        player.setDamage(receiveHarpoon(player.getDamage()));
        fight = true;
        while (fight) {
            if (player.isAlive() && seaSnake.isAlive()) {
                fightOneRound(player, seaSnake);
                if (!seaSnake.isAlive()) {
                    restoreHealth(player);
                }
            } else {
                fight = false;
            }
        }
        resetMonsterHealth(seaSnake);
    }


    public void fightTrollInEastRoom(Player player) {
        player.setDamage(receiveSword(player.getDamage()));
        fight = true;
        while (fight) {
            if (player.isAlive() && troll.isAlive()) {
                fightOneRound(player, troll);
                if (!troll.isAlive()) {
                    restoreHealth(player);
                }
            } else {
                fight = false;
            }
        }
        resetMonsterHealth(troll);
    }

    public void fightScorpionInWestRoom(Player player) {
        player.setDamage(receiveFlameThrower(player.getDamage()));
        fight = true;
        while (fight) {
            if (player.isAlive() && scorpion.isAlive()) {
                fightOneRound(player, scorpion);
                if (!scorpion.isAlive()) {
                    restoreHealth(player);
                }
            } else {
                fight = false;
            }
        }
        resetMonsterHealth(scorpion);
    }


    public int receiveSpear(int damage) {
        System.out.println("you've answered the questions correct!");
        System.out.println("here is your weapon:\n SPEAR");
        System.out.println("Let the fight begin!");
        int spearDamage = 20;
        return spearDamage + damage;
    }

    public int receiveHarpoon(int damage) {
        System.out.println("you've answered the questions correct!");
        System.out.println("here is your weapon:\n HARPOON");
        System.out.println("Let the fight begin!");
        int harpoonDamage = 15;
        return harpoonDamage + damage;
    }

    public int receiveSword(int damage) {
        System.out.println("you've answered the questions correct!");
        System.out.println("here is your weapon: \n SWORD");
        System.out.println("Let the fight begin!");
        int swordDamage = 20;
        return swordDamage + damage;
    }

    public int receiveFlameThrower(int damage) {
        System.out.println("you've answered the questions correct!");
        System.out.println("here is your weapon: \n FLAME THROWER");
        System.out.println("Let the fight begin!");
        int flameThrowerDamage = 20;
        return flameThrowerDamage + damage;
    }

    public void restoreHealth(Player player) {
        player.setHealth(100);
        System.out.println(player.getName() + " health has returned to full");
        System.out.println("Current health: " + player.getHealth());

    }

    public void resetPlayerDamage(Player player) {
        if (player.getDamage() > 20) {
            player.setDamage(20);
        }
    }
    public void resetMonsterHealth(Creature monster){
        if (!monster.isAlive()){
            monster.setHealth(100);
        }
    }

}
