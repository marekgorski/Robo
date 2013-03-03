package com.eatthatgame.robo;

public class Contender {
    private int MAX_HEALTH = 100;
    private int health = MAX_HEALTH;
    private int MAX_ENERGY = 50;
    private int energyDrain = 0;
    
    protected String name = "Contender";
    protected int age = 1;
    protected int attackPower = 10;
    protected int defensePower = 10;
    protected boolean attack = false;
    
    public int totalWon = 0;
    public int totalDrawn = 0;
    public int totalLost = 0;
    
    public int totalPoints = 0;
    
    
    
    public int attack(){
        return attackPower;
    }
    
    public int defend(){
        return defensePower;
    }
    
    public void hit(int damage) {
        //System.out.println(name + " 1. Health before energyCheck:" + health);
        energyCheck();
        //System.out.println(name + " 2. Health after energyCheck:" + health);
        health = health - damage;
        //System.out.println(name + " 3. Health after damage:" + health);
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
    
    public void setHealth(int value){
        health = value;
    }
    
    private void energyCheck(){
        energyDrain = (attackPower + defensePower)-MAX_ENERGY;
//        System.out.println(name + " has " +
//                           attackPower + " attackPower, " +
//                           defensePower + " defensePower, " +
//                           energyDrain + " excess energyDrain over the " +
//                           MAX_ENERGY + " maximum energy available");
        health = health - energyDrain;
        if(health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }
    }
    
    public void AI(){
        if(attack) {
            //System.out.println(name + " defends!");
            attack = false;
        } else {
            //System.out.println(name + " attacks!");
            attack = true;
        }
    }
    public void AI(Contender opponent) {
        if(getHealth() > opponent.getHealth()) {
            attack = true;
        } else {
            attack = false;
        }
        if(opponent.name.equals("Omega")) {
            attack = true;
        } else {
            attack = false;
        }
    }
}
