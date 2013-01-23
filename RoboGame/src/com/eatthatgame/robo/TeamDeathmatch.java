package com.eatthatgame.robo;

import java.util.ArrayList;

/*
 * 
 * This mode is a simple Death Match where  2 Contenders against 2 other Contender
 * Once both Contenders on one team fall or the Maximum round limit is reached then the
 * Winners is the Contenders left standing or the Condentders with the most health.
 * the Two teams are the classic colours of:
 * Red Team
 * Blue Team
 * 
 * TODO- Make it so both team members must fall for the game to end.
 * At the moment only one has to fall and the game will end.
 */

public class TeamDeathmatch extends Mode{
    
    public TeamDeathmatch(ArrayList<Contender> contendersList) {
        super(contendersList);
    }
    /*
     * This Method overrides the Mode match up method which currently has nothing in it.
     * this method gets four random contenders and adds them to the teams.
     */
   @Override  
          public void matchUp(){
        
     team = new Mode.Team("Red Team");
     teams.add(team);
     team = new Mode.Team("Blue Team");
     teams.add(team);
        
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender a = (Contender) contenders.remove(randomContenderID); 
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender b = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender c = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender d = (Contender) contenders.remove(randomContenderID);
        
        (teams.get(0)).add(a); 
        (teams.get(0)).add(b); 
        (teams.get(1)).add(c); 
        (teams.get(1)).add(d);
        
        battle();
    }
   /*
    * This method override the mode battle method which currently has nothing in it.
    * TODO- Make it so both team members must fall for the game to end.
    * At the moment only one has to fall and the game will end.
    */
      @Override
              public void battle(){
          
        Mode.Team A_Team = teams.get(0);
        Mode.Team B_Team = teams.get(1);
        
        a = A_Team.member(0);
        b = A_Team.member(1);
        Contender c = B_Team.member(0);
        Contender d = B_Team.member(1);
        
        
       System.out.println("=========================================");
       System.out.println("=============Team DeathMatch=============");
       System.out.println("=========================================");
       
       
       System.out.println("Red Team: " + a.name + " and " + b.name);
       System.out.println("Blue Team: " + c.name + " and " + d.name);
        System.out.println("FIGHT!");
       
        
        roundCount = 0;
        MAX_ROUNDS = 400;
        while(a.alive() && b.alive()  && c.alive() && d.alive() && roundCount < MAX_ROUNDS) {
            
            roundCount++;
            System.out.println("Round: " + roundCount);
            
            a.AI();
            b.AI();
            c.AI();
            d.AI();
            
            
            
            if(a.attack && b.attack){
                if(c.attack && d.attack){
                    System.out.println("Both teams attack!");
                    System.out.println(a.name + " hits " + c.name + " for: " + a.attack());
                    System.out.println(c.name + " hits " + a.name + " for: " + c.attack());
                    System.out.println(b.name + " hits " + d.name + " for: " + b.attack());
                    System.out.println(d.name + " hits " + b.name + " for: " + d.attack());
                    c.hit(a.attack());
                    d.hit(b.attack());
                    c.hit(c.attack());
                    b.hit(d.attack());
                } else {
                    System.out.println("Rec Team attacks and Blue Team defends");
                    System.out.println(a.name + " hits " + c.name + " for: " + (a.attack()-c.defend()));
                    System.out.println(b.name + " hits " + d.name + " for: " + (b.attack()-d.defend()));
                    c.hit(a.attack()-c.defend());
                    d.hit(b.attack()-d.defend());
                    a.hit(0);
                    b.hit(0);
                }
            } else {
                if(c.attack && d.attack){
                    System.out.println("Red Team defends and Blue Team attacks");
                    System.out.println(c.name + " hits " + a.name + " for: " + (c.attack()-a.defend()));
                    System.out.println(d.name + " hits " + b.name + " for: " + (d.attack()-b.defend()));
                    c.hit(0);
                    d.hit(0);
                    a.hit(c.attack()-a.defend());
                    b.hit(d.attack()-b.defend());
                } else {
                    // both defend only energyCheck runs
                    a.hit(0);
                    b.hit(0);
                    c.hit(0);
                    d.hit(0);
                    
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
