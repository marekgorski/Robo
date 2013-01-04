package com.eatthatgame.robo;

import java.util.ArrayList;

public class League {
    public League(ArrayList contenders) {
        Contender a = (Contender) contenders.get(0);
        Contender b = (Contender) contenders.get(1);
        
        System.out.println("Contender A: " + a.name + " vs. Contender B: " + b.name);
        System.out.println("FIGHT!");
        
        int roundCount = 1;
        while((a.health > 0) && (b.health > 0)) {
            a.health -= b.damage;
            b.health -= a.damage;
            System.out.println("Round: " + roundCount);
            roundCount++;
            System.out.println(a.name + " health: " + a.health);
            System.out.println(b.name + " health: " + b.health);
        }
        if(a.health > b.health) {
            System.out.println(a.name + " wins!");
        } else {
            System.out.println(b.name + " wins!");
        }
    }
}
