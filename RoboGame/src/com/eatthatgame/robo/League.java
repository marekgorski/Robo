package com.eatthatgame.robo;

import java.util.ArrayList;

public class League {
    public League(ArrayList contenders) {
        int randomContenderID;
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender a = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender b = (Contender) contenders.remove(randomContenderID);
            
        System.out.println("Contender A: " + a.name + " vs. Contender B: " + b.name);
        System.out.println("FIGHT!");
        
        int roundCount = 0;
        while((a.health > 0) && (b.health > 0)) {
            a.health -= b.attack();
            b.health -= a.attack();
            
            roundCount++;
            System.out.println("Round: " + roundCount);

            System.out.println(a.name + " health: " + a.health);
            System.out.println(b.name + " health: " + b.health);
        }
        if(a.health > b.health) {
            System.out.println(a.name + " wins! (in " + roundCount + " rounds)");
        } else {
            System.out.println(b.name + " wins! (in " + roundCount + " rounds)");
        }
    }
}
