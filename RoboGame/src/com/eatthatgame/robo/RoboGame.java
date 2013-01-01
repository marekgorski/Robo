package com.eatthatgame.robo;

import com.eatthatgame.robo.contenders.*;

public class RoboGame {

    public static void main(String[] args) {
        RedRobo redRobo = new RedRobo();
        BlueRobo blueRobo = new BlueRobo();

        System.out.println(redRobo.name + " vs. " + blueRobo.name);

        while((redRobo.health > 0) && (blueRobo.health > 0)) {
            redRobo.health -= blueRobo.damage;
            blueRobo.health -= redRobo.damage;
            System.out.println("RedRobo Health: " + redRobo.health);
            System.out.println("BlueRobo Health: " + blueRobo.health);
        }
        if(redRobo.health > blueRobo.health) {
            System.out.println(redRobo.name + "Robo wins!");
        } else {
            System.out.println(blueRobo.name + "Robo wins!");
        }
    }

}


