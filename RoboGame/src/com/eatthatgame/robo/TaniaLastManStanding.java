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

public class TaniaLastManStanding extends Mode{
    
    public TaniaLastManStanding(ArrayList<Contender> contendersList) {
        super(contendersList);
    }
    
    @Override
    public void matchUp() {
        
        team = new Team("Red Team");
        teams.add(team);
        team = new Team("Blue Team");
        teams.add(team);
        team = new Team("Green Team");
        teams.add(team);
        team = new Team("Orange Team");
        teams.add(team);
        team = new Team("Semi Final Team 1");
        teams.add(team);
        team = new Team("Semi Final Team 2");
        teams.add(team);
        team = new Team("Final Team");
        teams.add(team);
        
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender a = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender b = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender c = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender d = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender e = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender f = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender g = (Contender) contenders.remove(randomContenderID);
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender h = (Contender) contenders.remove(randomContenderID);
        
              
        (teams.get(0)).add(a); // Red Team Contender 1
        (teams.get(0)).add(b); // Red Team Contender 2
        (teams.get(1)).add(c); // Green Team Contender 1
        (teams.get(1)).add(d);
        (teams.get(2)).add(e); // Orange Team Contender 1
        (teams.get(2)).add(f);
        (teams.get(3)).add(g); // Blue Team Contender 1
        (teams.get(3)).add(h);
           
        for(int i = 0; i < teams.size(); i++) {
            System.out.println((teams.get(i)).getName() + " : " + (teams.get(i)).show() );
        }

        System.out.println("Let The Fight Begin.............");
    
        
        roundCount = 0;

        Team A_Team = teams.get(0);
        Team B_Team = teams.get(1);
        
        a = A_Team.member(0);
        Contender a2 = A_Team.member(1);
        b = B_Team.member(0);
        Contender b2 = B_Team.member(1);
        
        // TODO - change fight mechanic
        // The fight mechanic needs allow a and a2 to attack b together
        // the case for this would be when a2 beats b2 the next round
        // a2 should be able to attack b to help a beat b
        
        while(a.alive() && a2.alive() && b.alive() && b2.alive() && roundCount < MAX_ROUNDS) {
            
            roundCount++;
            
            System.out.println("Round: " + roundCount);
            
            a.AI();
            a2.AI();
            b.AI();
            b2.AI();
            
            if(a.attack && a2.attack){
                if(b.attack && b2.attack){
                    System.out.println("Both teams attack!");
                    System.out.println(a.name + " hits " + b.name + " for: " + a.attack());
                    System.out.println(a2.name + " hits " + b2.name + " for: " + a2.attack());
                    System.out.println(b.name + " hits " + a.name + " for: " + b.attack());
                    System.out.println(b2.name + " hits " + a2.name + " for: " + b2.attack());
                    a.hit(b.attack());
                    a2.hit(b2.attack());
                    b.hit(a.attack());
                    b2.hit(a2.attack());
                    
                } else {
                    System.out.println("redTeam attacks and greenTeam defends");
                    System.out.println(a.name + " hits " + b.name + " for: " + (a.attack()-b.defend()));
                    System.out.println(a2.name + " hits " + b2.name + " for: " + (a2.attack()-b2.defend()));
                    b.hit(a.attack()-b.defend());
                    b2.hit(a2.attack()-b2.defend());
                    a.hit(0);
                    a2.hit(0);
                }
            } else {
                if(b.attack && b2.attack){
                    System.out.println("A Team defends and B Team attacks");
                    System.out.println(b.name + " hits " + a.name + " for: " + (b.attack()-a.defend()));
                    System.out.println(b2.name + " hits " + a2.name + " for: " + (b2.attack()-a2.defend()));
                    b.hit(0);
                    b2.hit(0);
                    a.hit(b.attack()-a.defend());
                    a2.hit(b2.attack()-a2.defend());
                } else {
                    // both defend only energyCheck runs
                    a.hit(0);
                    a2.hit(0);
                    b.hit(0);
                    b2.hit(0);
                }
            }

            System.out.println(a.name + " health: " + a.getHealth());
            System.out.println(a2.name + " health: " + a2.getHealth());
            System.out.println(b.name + " health: " + b.getHealth());
            System.out.println(b2.name + " health: " + b2.getHealth());
        }
        
        if(roundCount < MAX_ROUNDS) {
            if(a.alive() && a2.alive()) {
                System.out.println( a.name + " and " + a2.name+ " wins by K.O. (in " + roundCount + " rounds)");
                
                (teams.get(4)).add(a);
                (teams.get(4)).add(a2);
                System.out.println("semifinalTeam1: " + a.name + " and " + a2.name);
                
            } else if(b.alive() && b2.alive()) {
                System.out.println(b.name + " and " + b2.name+ " wins by K.O. (in " + roundCount + " rounds)");
                
                (teams.get(4)).add(b);
                (teams.get(4)).add(b2);
                System.out.println("semifinalTeam1: " + b.name + " and " + b2.name);              
                
            } else {
                System.out.println("Mutual Annihilation, both teams are dead after " + roundCount + " rounds)");
            }
        } else {
            System.out.println("=======MAX Rounds Reached=======");
            if((a.getHealth()+a2.getHealth()) >(b.getHealth()+b2.getHealth()) ) {
                System.out.println(a.name + " and " + a2.name+ " wins by jury decision (in MAX " + roundCount + " rounds)");
                
                (teams.get(4)).add(a);
                (teams.get(4)).add(a2);
                System.out.println("semifinalTeam1: " + a.name + " and " + a2.name);
                
                
            } else {
                System.out.println(b.name + " and " + b2.name+ " wins by jury decision (in MAX " + roundCount + " rounds)");
                
                (teams.get(4)).add(b);
                (teams.get(4)).add(b2);
                System.out.println("semifinalTeam1: " + b.name + " and " + b2.name);
            }
            
            // TODO - optimise code more
            // red and green teams are now just A_Team and B_Team
            // this means any team can become A_Team or B_Team
            // currently the red team is A_Team and green team is B_Team
            // to test blueTeam and orangeTeam set them to be A_Team and B_Team
            // to randomise which teams fight each other the actual "fight" code needs
            // to be seperate from the "team match up" code which needs to be added

        }
    }
}
    

