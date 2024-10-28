package se.lisau.adventuregame.model;

public class Monster extends Creature {

    public Monster(String name, int health, int damage) {
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
    public int getDamage(){
        return super.getDamage();
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
