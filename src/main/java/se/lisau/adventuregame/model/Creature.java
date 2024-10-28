package se.lisau.adventuregame.model;

public abstract class Creature {
    private String name;
    private int health;
    private int damage;
    public Creature(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void attack(Creature toAttack){
        toAttack.takeDamage(damage);
    }
    public boolean isAlive(){
        if (health > 0){
            return true;
        } else{
            return false;
        }
    }
}

