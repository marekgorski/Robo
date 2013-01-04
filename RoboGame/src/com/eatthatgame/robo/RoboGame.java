package com.eatthatgame.robo;

import com.eatthatgame.robo.contenders.*;

public class RoboGame {

    public static void main(String[] args) {
        Contender contenderA = new Adam();
        Contender contenderB = new JayGundam();

        System.out.println(contenderA.name + " vs. " + contenderB.name);

        while((contenderA.health > 0) && (contenderB.health > 0)) {
            contenderA.health -= contenderB.damage;
            contenderB.health -= contenderA.damage;
            System.out.println(contenderA.name + " health: " + contenderA.health);
            System.out.println(contenderB.name + " health: " + contenderB.health);
        }
        if(contenderA.health > contenderB.health) {
            System.out.println(contenderA.name + "Robo wins!");
        } else {
            System.out.println(contenderB.name + "Robo wins!");
        }
    }

}


