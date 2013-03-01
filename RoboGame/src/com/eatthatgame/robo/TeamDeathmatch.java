package com.eatthatgame.robo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

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
     
     JOptionPane.showMessageDialog( null,"Select the Robots to be on each team."+"\n"
             
             +"Use only numbers between 0 and 7"+"\n"+
             
             "(Awesom-O = 0) (Boo Boo = 1) (Omega = 2) (Freedom = 3)"+"\n"+
             "(Blitz = 4)    (Max = 5)     (Tania = 6) (Yogi Bear = 7)");
     
     int UserInputA = Integer.parseInt(
          JOptionPane.showInputDialog( "Red Team Member 1"));
     int UserInputB = Integer.parseInt(
          JOptionPane.showInputDialog( "Red Team Member 2"));
     int UserInputC = Integer.parseInt(
          JOptionPane.showInputDialog( "Blue Team Member 1"));
     int UserInputD = Integer.parseInt(
          JOptionPane.showInputDialog( "Blue Team Member 2"));
        
        Contender a = (Contender) contenders.remove(UserInputA); 
        Contender b = (Contender) contenders.remove(UserInputB);
        Contender c = (Contender) contenders.remove(UserInputC);
        Contender d = (Contender) contenders.remove(UserInputD);
        
        (teams.get(0)).add(a); 
        (teams.get(0)).add(b); 
        (teams.get(1)).add(c); 
        (teams.get(1)).add(d);
        
        battle();
    }
   /*
    * This method override the mode battle method which currently has nothing in it.
    * I have updated the battle method so that both members of the team must fall 
    * for the game to end.
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
        while(roundCount < MAX_ROUNDS) {

            
            if(a.alive() || b.alive()){
                if(c.alive() || d.alive()){
                    
                  
            roundCount++;
            System.out.println("\n======= Round: " + roundCount + " =======");;
            
            a.AI();
            b.AI();
            c.AI();
            d.AI();
            
           // checks if the round cout is even. If it is a even number then its A vs C and B vs D. 
           //If its odd then its A vs D and B vs C.
        if(roundCount %2 == 0){
            
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
            }else{
            if(a.attack && b.attack){
                if(c.attack && d.attack){
                    System.out.println("Both teams attack!");
                    System.out.println(a.name + " hits " + d.name + " for: " + a.attack());
                    System.out.println(c.name + " hits " + b.name + " for: " + c.attack());
                    System.out.println(b.name + " hits " + c.name + " for: " + b.attack());
                    System.out.println(d.name + " hits " + a.name + " for: " + d.attack());
                    d.hit(a.attack());
                    c.hit(b.attack());
                    b.hit(c.attack());
                    a.hit(d.attack());
                } else {
                    System.out.println("Red Team attacks and Blue Team defends");
                    System.out.println(a.name + " hits " + d.name + " for: " + (a.attack()-d.defend()));
                    System.out.println(b.name + " hits " + c.name + " for: " + (b.attack()-c.defend()));
                    d.hit(a.attack()-d.defend());
                    c.hit(b.attack()-c.defend());
                    a.hit(0);
                    b.hit(0);
                }
            } else {
                if(c.attack && d.attack){
                    System.out.println("Red Team defends and Blue Team attacks");
                    System.out.println(c.name + " hits " + b.name + " for: " + (c.attack()-b.defend()));
                    System.out.println(d.name + " hits " + a.name + " for: " + (d.attack()-a.defend()));
                    c.hit(0);
                    d.hit(0);
                    b.hit(c.attack()-b.defend());
                    a.hit(d.attack()-a.defend());
                } else {
                    // both defend only energyCheck runs
                    a.hit(0);
                    b.hit(0);
                    c.hit(0);
                    d.hit(0);
        }
                //print out health
            System.out.println(a.name + " health: " + a.getHealth());
            System.out.println(b.name + " health: " + b.getHealth());
            System.out.println(c.name + " health: " + c.getHealth());
            System.out.println(d.name + " health: " + d.getHealth());
            
            }
        }
            
            
        }
        
       
          }
        }
        // checks if the maximum rounds have been reached and determines the winner by adding up their health.
         if(roundCount < MAX_ROUNDS) {
            if(a.alive() ==  false && b.alive() == false) {
                System.out.println( c.name + " and " + d.name+ " wins by K.O. (in " + roundCount + " rounds)");
            } else if(c.alive()==false && d.alive()==false) {
                System.out.println(a.name + " and " + b.name+ " wins by K.O. (in " + roundCount + " rounds)");
            } else {
                System.out.println("Mutual Annihilation, both teams are dead after " + roundCount + " rounds)");
            }
        } else {
            System.out.println("=======MAX Rounds Reached=======");
            if(a.getHealth()+ b.getHealth() > c.getHealth()+ d.getHealth()) {
                System.out.println(a.name + " and " + b.name+ " wins by jury decision (in MAX " + roundCount + " rounds)");
            } else {
                System.out.println(c.name + " and " + d.name+ " wins by jury decision (in MAX " + roundCount + " rounds)");
            }
    
      }
   }
}
     
        
    
    