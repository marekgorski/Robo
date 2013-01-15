package com.eatthatgame.robo;

import java.util.ArrayList;

public class RandomMatchUp2v2 {
    public RandomMatchUp2v2(ArrayList contenders) {
        int randomContenderID;
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender a1 = (Contender) contenders.remove(randomContenderID); 
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender a2 = (Contender) contenders.remove(randomContenderID); 
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender b1 = (Contender) contenders.remove(randomContenderID); 
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender b2 = (Contender) contenders.remove(randomContenderID); 
            
        System.out.println("\nTeam A: " + a1.name + " and " + a2.name + " vs. Team B: " + b1.name + " and " +b2.name + "\n");
        System.out.println("FIGHT!");
        
        int roundCount = 0;
        int MAX_ROUNDS = 200;
        while(a1.alive() && a2.alive() && b1.alive() && b2.alive() && roundCount < MAX_ROUNDS) {
            
            roundCount++;
            System.out.println("\n======= Round: " + roundCount + " =======");
            
            a1.AI();
            a2.AI();
            b1.AI();
            b2.AI();        
            
            if(a1.attack && a2.attack){
                if(b1.attack && b2.attack){
                    System.out.println("Both teams attack!");
                    System.out.println(a1.name + " hits " + b1.name + " for: " + a1.attack());
                    System.out.println(b1.name + " hits " + a1.name + " for: " + b1.attack());
                    System.out.println(a2.name + " hits " + b2.name + " for: " + a2.attack());
                    System.out.println(b2.name + " hits " + a2.name + " for: " + b2.attack());
                    b1.hit(a1.attack());
                    b2.hit(a2.attack());
                    a1.hit(b1.attack());
                    a2.hit(b2.attack());
                } else {
                    System.out.println("Team A attacks and Team B defends");
                    System.out.println(a1.name + " hits " + b1.name + " for: " + (a1.attack()-b1.defend()));
                    System.out.println(a2.name + " hits " + b2.name + " for: " + (a2.attack()-b2.defend()));
                    b1.hit(a1.attack()-b1.defend());
                    b2.hit(a2.attack()-b2.defend());
                    a1.hit(0);
                    a2.hit(0);
                }
            } else {
                if(b1.attack && b2.attack){
                    System.out.println("Team A defends and Team B attacks");
                    System.out.println(b1.name + " hits " + a1.name + " for: " + (b1.attack()-a1.defend()));
                    System.out.println(b2.name + " hits " + a2.name + " for: " + (b2.attack()-a2.defend()));
                    b1.hit(0);
                    b2.hit(0);
                    a1.hit(b1.attack()-a1.defend());
                    a2.hit(b2.attack()-a2.defend());
                } else {
                    // both defend only energyCheck runs
                    b1.hit(0);
                    b2.hit(0);
                    a1.hit(0);
                    a2.hit(0);
                }
            }

            System.out.println(a1.name + " health: " + a1.getHealth());
            System.out.println(a2.name + " health: " + a2.getHealth());
            System.out.println(b1.name + " health: " + b1.getHealth());
            System.out.println(b2.name + " health: " + b2.getHealth());
        }
        
        if(roundCount < MAX_ROUNDS) {
            if(a1.alive() && a2.alive()) {
                System.out.println("\n======= Team A: " + a1.name + " and " + a2.name + " wins by K.O. (in " + roundCount + " rounds) =======");
            } else if(b1.alive() && b2.alive()) {
                System.out.println("\n======= Team B: " + b1.name + " and " + b2.name + " wins by K.O. (in " + roundCount + " rounds) =======");
            } else {
                System.out.println("\nMutual Annihilation, all contenders are dead after " + roundCount + " rounds)");
            }
        } else {
            System.out.println("\n=======MAX Rounds Reached=======");
            if(a1.getHealth()+a2.getHealth() > b1.getHealth()+ b2.getHealth()) {
                System.out.println("Team A: " + a1.name + " and " + a2.name + " wins by jury decision (in MAX " + roundCount + " rounds)");
            } else {
                System.out.println("Team B: " + b1.name + " and " + b2.name + " wins by jury decision (in MAX " + roundCount + " rounds)");
            }
        }
    }
}
