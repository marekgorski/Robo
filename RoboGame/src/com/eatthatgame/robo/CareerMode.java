package com.eatthatgame.robo;

import java.util.ArrayList;

public class CareerMode extends Mode{
    
    public CareerMode(ArrayList<Contender> contendersList) {
        super(contendersList);
    }
    
    @Override
    public void matchUp() {
        System.out.println("=========================================");
        System.out.println("=======Career Mode Match Up Begins=======");
        System.out.println("=========================================");
        int matchUpCount = (contenders.size()*(contenders.size()))+1;
        for(int i=matchUpCount; i>0; i--){
            if(currentContenderID>contenders.size()-1) {
                System.out.println("All Contenders have participated");
                for(Contender c : contenders) {
                    System.out.println(c.name + " : " +
                                       c.totalWon + "W " +
                                       c.totalDrawn + "D " +
                                       c.totalLost + "L ");
                }
                
            } else {
                if(opponents.isEmpty()) {
                    System.out.println("All opponents for " + a.name + " are exhausted");
                    currentContenderID++;
                    opponents = new ArrayList<Contender>(contenders);
                } else {
                    // set the Career fighter
                    a = (Contender) contenders.get(currentContenderID);
                    if(contenders.size() == opponents.size()) {
                        // remove the current Career fighter from the opponents list
                        opponents.remove(currentContenderID);
                    }
                    // grab/remove the next opponent from the top of the list
                    b = (Contender) opponents.remove(0);
                    
                    System.out.print(a.name);
                    System.out.print(" vs. ");
                    System.out.print(b.name);
                    System.out.print("\n");
                    
                    battle();
                    System.out.println("-------------------------------------------------------");
                }
            }

        }

        // display after all match ups are complete
        System.out.println("==========================");
        System.out.println("========THE WINNER========");
        System.out.println("         " + getWinner().name);
        System.out.println("==========================");
        
    }
    
    @Override
    public void battle() {
        a.setHealth(100);
        b.setHealth(100);
        roundCount = 0;
        
        while(a.alive() && b.alive() && roundCount < MAX_ROUNDS) {
            
            roundCount++;
            //System.out.println("Round: " + roundCount);
            
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
                System.out.println(a.name + " wins by K.O. (in " + roundCount + " rounds)");
                a.totalWon++;
                b.totalLost++;
            } else if(b.alive()) {
                System.out.println(b.name + " wins by K.O. (in " + roundCount + " rounds)");
                a.totalLost++;
                b.totalWon++;
            } else {
                System.out.println("Mutual Annihilation, both contenders are dead after " + roundCount + " rounds)");
                a.totalDrawn++;
                b.totalDrawn++;
            }
        } else {
            System.out.println("=======MAX Rounds Reached=======");
            if(a.getHealth() > b.getHealth()) {
                System.out.println(a.name + " wins by jury decision (in MAX " + roundCount + " rounds)");
                a.totalWon++;
                b.totalLost++;
            } else {
                System.out.println(b.name + " wins by jury decision (in MAX " + roundCount + " rounds)");
                a.totalLost++;
                b.totalWon++;
            }
        }

    }

}
