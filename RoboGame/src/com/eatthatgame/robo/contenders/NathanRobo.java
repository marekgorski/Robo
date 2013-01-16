package com.eatthatgame.robo.contenders;

import com.eatthatgame.robo.Contender;
import java.util.Random;

public class NathanRobo extends Contender {

    public NathanRobo() {
        this.name = "Max";
        this.age = 6;
        this.attackPower = 23;
        this.defensePower = 13;
        
          }
    
    public boolean getRandomBoolean() {
    Random random = new Random();
    return random.nextBoolean();
    }
    
    public boolean changeMove(){
    boolean lastMove = false;
    if(lastMove = true){
            System.out.println(name + " Defends!");
            lastMove = false;
            return false;
        }
        else{
            System.out.println(name + " Attacks!"); 
            lastMove = true;
            return true;
        }
    }
    
    @Override
    public void AI(){
        int RoboHealth = getHealth();
        
        if( RoboHealth < 75 ) {
            System.out.println(name + " Attacks!");
            attack = true;
            
        }
            
        else if( RoboHealth > 75) {
            System.out.println(name + " Defends!");
            attack = false;
        }
        
        else if( RoboHealth > 45 ) {
            System.out.println(name + " Attacks!");
            attack = true;
        }

        else {
            System.out.println(name + " Defends!");
            defensePower = defensePower +3;
            attack = false;
        }
        
        
    }
}