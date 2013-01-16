package com.eatthatgame.robo;

import java.util.ArrayList;

/*
 * This mode is all about matching 2 Contenders against 2 other Contender
 * Once both Contenders on one team fall (run out of health) the other team wins
 * redTeam
 * greenTeam
 * orangeTeam
 * blueTeam
 * semifinalTeam1
 * semifinaleTeam1
 * finalTeam
 * 
 * each team has two team members
 * 
 * redTeam fight with greenTeam , winner team goes to semifinalTeam1
 * 
 * orangeTeam fight with blueTeam,winner team goes to semifinalTeam2
 * 
 * Then again 
 * semifinalTeam1 fight with semifinalTeam2, winner team goes to finalTeam
 * 
 * In final both team members will fight and the winner will be champ.
 */

public class TaniaLastManStanding {
    
    public TaniaLastManStanding(ArrayList contenders) {
        int randomContenderID;
        Contender[] redTeam;
        Contender[] blueTeam;
        Contender[] greenTeam;
        Contender[] orangeTeam;
        Contender[] semifinalTeam1;
        Contender[] semifinalTeam2;
        Contender[] finalTeam;
        
        redTeam  = new Contender[2];
        blueTeam = new Contender[2];
        greenTeam = new Contender[2];
        orangeTeam = new Contender[2];
        semifinalTeam1 = new Contender[2];
        semifinalTeam2 = new Contender[2];
        finalTeam = new Contender[2];        
        
       
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender a = (Contender) contenders.remove(randomContenderID); // set to 7 for Yogi Bear
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender b = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender c = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender d = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender e = (Contender) contenders.remove(randomContenderID); // set to 7 for Yogi Bear
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender f = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender g = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender h = (Contender) contenders.remove(randomContenderID);
        
              
              
        redTeam[0]    = a;
        redTeam[1]    = b;
        greenTeam[0]  = c;
        greenTeam[1]  = d;
        orangeTeam[0] = e;
        orangeTeam[1] = f;
        blueTeam[0]   = g;
        blueTeam[1]   = h;
    
        
        
       System.out.println("Red Team: " + a.name + " and " + b.name);
       System.out.println("greenTeam: " + c.name + " and " + d.name);
       System.out.println("orangeTeam: " + e.name + " and " + f.name);
       System.out.println("Blue Team: " + g.name + " and " + h.name);
       System.out.println("Let The Fight Begin.............");
        
        int roundCount = 0;
        int MAX_ROUNDS = 200;
        
        while(redTeam[0].alive() && redTeam[1].alive() && greenTeam[0].alive() && greenTeam[1].alive() && roundCount < MAX_ROUNDS) {
            
            roundCount++;
            System.out.println("Round: " + roundCount);
            
            redTeam[0].AI();
            redTeam[1].AI();
            greenTeam[0].AI();
            greenTeam[1].AI();           
            
            
            
            if(redTeam[0].attack && redTeam[1].attack){
                if(greenTeam[0].attack && greenTeam[1].attack){
                    System.out.println("Both teams attack!");
                    System.out.println(redTeam[0].name + " hits " + greenTeam[0].name + " for: " + redTeam[0].attack());
                    System.out.println(redTeam[1].name + " hits " + greenTeam[1].name + " for: " + redTeam[1].attack());
                    System.out.println(greenTeam[0].name + " hits " + redTeam[0].name + " for: " + greenTeam[0].attack());
                    System.out.println(greenTeam[1].name + " hits " + redTeam[1].name + " for: " + greenTeam[1].attack());
                    redTeam[0].hit(greenTeam[0].attack());
                    redTeam[1].hit(greenTeam[1].attack());
                    greenTeam[0].hit(redTeam[0].attack());
                    greenTeam[1].hit(redTeam[1].attack());
                    
                } else {
                    System.out.println("redTeam attacks and greenTeam defends");
                    System.out.println(redTeam[0].name + " hits " + greenTeam[0].name + " for: " + (redTeam[0].attack()-greenTeam[0].defend()));
                    System.out.println(redTeam[1].name + " hits " + greenTeam[1].name + " for: " + (redTeam[1].attack()-greenTeam[1].defend()));
                    greenTeam[0].hit(redTeam[0].attack()-greenTeam[0].defend());
                    greenTeam[1].hit(redTeam[1].attack()-greenTeam[1].defend());
                    redTeam[0].hit(0);
                    redTeam[1].hit(0);
                }
            } else {
                if(greenTeam[0].attack && greenTeam[1].attack){
                    System.out.println("redTeam defends and greenTeam attacks");
                    System.out.println(greenTeam[0].name + " hits " + redTeam[0].name + " for: " + (greenTeam[0].attack()-redTeam[0].defend()));
                    System.out.println(greenTeam[1].name + " hits " + redTeam[1].name + " for: " + (greenTeam[1].attack()-redTeam[1].defend()));
                    greenTeam[0].hit(0);
                    greenTeam[1].hit(0);
                    redTeam[0].hit(greenTeam[0].attack()-redTeam[0].defend());
                    redTeam[1].hit(greenTeam[1].attack()-redTeam[1].defend());
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
                
                semifinalTeam1[0]    = a;
                semifinalTeam1[1]    = b;
                System.out.println("semifinalTeam1: " + a.name + " and " + b.name);
                
            } else if(c.alive() && d.alive()) {
                System.out.println(c.name + " and " + d.name+ " wins by K.O. (in " + roundCount + " rounds)");
                
                semifinalTeam1[0]    = c;
                semifinalTeam1[1]    = d;
                System.out.println("semifinalTeam1: " + a.name + " and " + b.name);
                
                
            } else {
                System.out.println("Mutual Annihilation, both teams are dead after " + roundCount + " rounds)");
            }
        } else {
            System.out.println("=======MAX Rounds Reached=======");
            if((a.getHealth()+b.getHealth()) >(c.getHealth()+d.getHealth()) ) {
                System.out.println(a.name + " and " + b.name+ " wins by jury decision (in MAX " + roundCount + " rounds)");
                
                semifinalTeam1[0]    = a;
                semifinalTeam1[1]    = b;
                System.out.println("semifinalTeam1: " + a.name + " and " + b.name);
                
                
            } else {
                System.out.println(c.name + " and " + d.name+ " wins by jury decision (in MAX " + roundCount + " rounds)");
                
                semifinalTeam1[0]    = a;
                semifinalTeam1[1]    = b;
                System.out.println("semifinalTeam1: " + a.name + " and " + b.name);
            }
            
            // TODO - optimise code
            // I did coding for redTeam fight against greenTeam.
            // for blueTeam and orangeTeam its the same repetation of coding.
            // how I can minimize the coding and I also want that the team fight will be randomly.

        }
    }
}
    

