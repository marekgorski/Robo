package com.eatthatgame.robo.contenders;

import com.eatthatgame.robo.Contender;

public class NathanRobo extends Contender {

    public NathanRobo() {
        this.name = "Max";
        this.age = 6;
        this.attackPower = 23;
        this.defensePower = 13;
          }
    
    @Override
    public void AI(){
        int RoboHealth = getHealth();
        
        if( RoboHealth == 100) {
            System.out.println(name + " Attacks!");
            attack = true;
           
            if( RoboHealth > 75) {
                System.out.println(name + " Defends!");
                attack = true;

            }
            if( RoboHealth > 45 ) {
                System.out.println(name + " Attacks!");
                attack = true;

            }
        } else {
            System.out.println(name + " Defends!");
            attack = false;
        }
    }

}