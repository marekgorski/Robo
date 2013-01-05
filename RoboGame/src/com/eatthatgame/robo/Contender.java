package com.eatthatgame.robo;

public class Contender {
    protected String name = "Contender";
    protected int age = 1;
    protected int attackPower = 10;
    protected int defensePower = 10;
    private int health = 100;
    
    public int attack(){
        return attackPower;
    }
    
    public int defend(){
        return defensePower;
    }
    
    public void hit(int damage) {
        health = health - damage;
    }
    
    public boolean alive(){
        if(health > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int getHealth(){
        return health;
    }
}
