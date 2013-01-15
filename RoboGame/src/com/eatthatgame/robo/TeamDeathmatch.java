package com.eatthatgame.robo;

import java.util.ArrayList;
import javax.swing.*;
import java.util.Random;

public class TeamDeathmatch {
    
    public boolean getRandomBoolean() {
    Random random = new Random();
    return random.nextBoolean();
}
    
    
    public TeamDeathmatch(ArrayList contenders) {
        int randomContenderID;
        Contender[] redTeam;
        Contender[] blueTeam;
        redTeam = new Contender[2];
        blueTeam = new Contender[2];

        randomContenderID = (int) (Math.random()*contenders.size());
        Contender a = (Contender) contenders.remove(randomContenderID); // set to 7 for Yogi Bear
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender b = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender c = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender d = (Contender) contenders.remove(randomContenderID);
        
        redTeam[0] = a;
        redTeam[1] = b;
        blueTeam[0] = c;
        blueTeam[1] = d;
        
       System.out.println("Red Team: " + a.name + " and " + b.name);
       System.out.println("Blue Team: " + c.name + " and " + d.name);
        System.out.println("FIGHT!");
        
        int roundCount = 0;
        int MAX_ROUNDS = 400;
        while(redTeam[0].alive() && redTeam[1].alive() && blueTeam[0].alive() &&  blueTeam[1].alive() && roundCount < MAX_ROUNDS) {
            
            roundCount++;
            System.out.println("Round: " + roundCount);
            
            redTeam[0].AI();
            redTeam[1].AI();
            blueTeam[0].AI();
            blueTeam[1].AI();
            
            
            
            if(redTeam[0].attack && redTeam[1].attack){
                if(blueTeam[0].attack && blueTeam[1].attack){
                    System.out.println("Both teams attack!");
                    System.out.println(redTeam[0].name + " hits " + blueTeam[0].name + " for: " + redTeam[0].attack());
                    System.out.println(blueTeam[0].name + " hits " + redTeam[0].name + " for: " + blueTeam[0].attack());
                    System.out.println(redTeam[1].name + " hits " + blueTeam[1].name + " for: " + redTeam[1].attack());
                    System.out.println(blueTeam[1].name + " hits " + redTeam[1].name + " for: " + blueTeam[1].attack());
                    blueTeam[0].hit(redTeam[0].attack());
                    blueTeam[1].hit(redTeam[1].attack());
                    blueTeam[0].hit(blueTeam[0].attack());
                    redTeam[1].hit(blueTeam[1].attack());
                } else {
                    System.out.println("Team A attacks and Team B defends");
                    System.out.println(redTeam[0].name + " hits " + blueTeam[0].name + " for: " + (redTeam[0].attack()-blueTeam[0].defend()));
                    System.out.println(redTeam[1].name + " hits " + blueTeam[1].name + " for: " + (redTeam[1].attack()-blueTeam[1].defend()));
                    blueTeam[0].hit(redTeam[0].attack()-blueTeam[0].defend());
                    blueTeam[1].hit(redTeam[1].attack()-blueTeam[1].defend());
                    redTeam[0].hit(0);
                    redTeam[1].hit(0);
                }
            } else {
                if(blueTeam[0].attack && blueTeam[1].attack){
                    System.out.println("Team A defends and Team B attacks");
                    System.out.println(blueTeam[0].name + " hits " + redTeam[0].name + " for: " + (blueTeam[0].attack()-redTeam[0].defend()));
                    System.out.println(blueTeam[1].name + " hits " + redTeam[1].name + " for: " + (blueTeam[1].attack()-redTeam[1].defend()));
                    blueTeam[0].hit(0);
                    blueTeam[1].hit(0);
                    redTeam[0].hit(blueTeam[0].attack()-redTeam[0].defend());
                    redTeam[1].hit(blueTeam[1].attack()-redTeam[1].defend());
                } else {
                    // both defend only energyCheck runs
                    redTeam[0].hit(0);
                    redTeam[1].hit(0);
                    blueTeam[0].hit(0);
                    blueTeam[1].hit(0);
                    
                }
            }

            System.out.println(a.name + " health: " + a.getHealth());
            System.out.println(b.name + " health: " + b.getHealth());
            System.out.println(c.name + " health: " + c.getHealth());
            System.out.println(d.name + " health: " + d.getHealth());
        }
        
        if(roundCount < MAX_ROUNDS) {
            if(a.alive() && b.alive()) {
                System.out.println( a.name + " and " + b.name+ " wins by K.O. (in " + roundCount + " rounds)");
            } else if(c.alive() && d.alive()) {
                System.out.println(c.name + " and " + d.name+ " wins by K.O. (in " + roundCount + " rounds)");
            } else {
                System.out.println("Mutual Annihilation, both teams are dead after " + roundCount + " rounds)");
            }
        } else {
            System.out.println("=======MAX Rounds Reached=======");
            if(a.getHealth() > b.getHealth()) {
                System.out.println(a.name + " and " + b.name+ " wins by jury decision (in MAX " + roundCount + " rounds)");
            } else {
                System.out.println(c.name + " and " + d.name+ " wins by jury decision (in MAX " + roundCount + " rounds)");
            }
        }
    }
}
