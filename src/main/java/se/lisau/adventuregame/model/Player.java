package se.lisau.adventuregame.model;

public class Player extends Creature {

    public Player(String name, int health, int damage) {
        super(name, health, damage);
    }
    @Override
    public String getName(){
        return super.getName();
    }
    @Override
    public int getHealth(){
        return super.getHealth();
    }
    @Override
    public void setHealth(int health){
        super.setHealth(health);
    }
    @Override
    public int getDamage(){
        return super.getDamage();
    }
    @Override
    public void setDamage(int damage){
        super.setDamage(damage);
    }
    @Override
    public void takeDamage(int damage){
        super.takeDamage(damage);
    }
    @Override
    public void attack(Creature toAttack){
        toAttack.takeDamage(this.getDamage());
    }
    @Override
    public boolean isAlive(){
        return super.isAlive();
    }
}