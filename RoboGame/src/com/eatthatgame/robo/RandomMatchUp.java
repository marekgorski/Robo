package com.eatthatgame.robo;

import java.util.ArrayList;

public class RandomMatchUp {
    public RandomMatchUp(ArrayList contenders) {
        int randomContenderID;
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender a = (Contender) contenders.remove(randomContenderID); // set to 7 for Yogi Bear
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender b = (Contender) contenders.remove(randomContenderID); // then set to 1 for Boo Boo
            
        System.out.println("\nContender A: " + a.name + " vs. Contender B: " + b.name + "\n");
        System.out.println("FIGHT!");
        
        int roundCount = 0;
        int MAX_ROUNDS = 200;
        while(a.alive() && b.alive() && roundCount < MAX_ROUNDS) {
            
            roundCount++;
            System.out.println("\n======= Round: " + roundCount + " =======");
            
            a.AI();
            b.AI();        
            
            if(a.attack){
                if(b.attack){
                    System.out.println("Both attack!");
                    System.out.println("A hits for: " + a.attack());
                    System.out.println("B hits for: " + b.attack());
                    b.hit(a.attack());
                    a.hit(b.attack());
                } else {
                    System.out.println("A attacks and B defends");
                    System.out.println("A hits for: " + (a.attack()-b.defend()));
                    b.hit(a.attack()-b.defend());
                    a.hit(0);
                }
            } else {
                if(b.attack){
                    System.out.println("A defends and B attacks");
                    System.out.println("B hits for: " + (b.attack()-a.defend()));
                    b.hit(0);
                    a.hit(b.attack()-a.defend());
                } else {
                    // both defend only energyCheck runs
                    b.hit(0);
                    a.hit(0);
                }
            }

            System.out.println(a.name + " health: " + a.getHealth());
            System.out.println(b.name + " health: " + b.getHealth());
        }
        
        if(roundCount < MAX_ROUNDS) {
            if(a.alive()) {
                System.out.println("\n======= " + a.name + " wins by K.O. (in " + roundCount + " rounds) =======");
            } else if(b.alive()) {
                System.out.println("\n======= " + b.name + " wins by K.O. (in " + roundCount + " rounds) =======");
            } else {
                System.out.println("\nMutual Annihilation, both contenders are dead after " + roundCount + " rounds)");
            }
        } else {
            System.out.println("\n=======MAX Rounds Reached=======");
            if(a.getHealth() > b.getHealth()) {
                System.out.println(a.name + " wins by jury decision (in MAX " + roundCount + " rounds)");
            } else {
                System.out.println(b.name + " wins by jury decision (in MAX " + roundCount + " rounds)");
            }
        }
    }
}
