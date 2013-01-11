package com.eatthatgame.robo;

import java.util.ArrayList;

/**
*
* @author Jay Iamsombat
* Date: 10 January 2013
* 
* Rules:
* - Every contender gets matched up with every other contender in the league.
* - The contender to get the most victories claims the title "King of the Hill"
* - If two contenders acquire the same amount of victories, a show down will occur between the two victors. If both
*   contenders win in the show down and the match was not determined by random occurrence of the AI both shall be
*   crowned "King of the Hill"
* 
*/
public class KingOfTheHill 
{
    public KingOfTheHill(ArrayList contenders) 
    {
        boolean victory;
        
        Contender a = (Contender) contenders.remove(0);
        Contender b = (Contender) contenders.remove(2);

        System.out.println("Contender A: " + a.name + " vs. Contender B: " + b.name);
        System.out.println("FIGHT!");

        int roundCount = 0;
        int MAX_ROUNDS = 200;
        while(a.alive() && b.alive() && roundCount < MAX_ROUNDS) {

            roundCount++;
            System.out.println("Round: " + roundCount);

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
                victory = true;
            } else if(b.alive()) {
                System.out.println(b.name + " wins by K.O. (in " + roundCount + " rounds)");
                victory = false;
            } else {
                System.out.println("Mutual Annihilation, both contenders are dead after " + roundCount + " rounds)");
                victory = false;
            }
        } else {
            System.out.println("=======MAX Rounds Reached=======");
            if(a.getHealth() > b.getHealth()) {
                System.out.println(a.name + " wins by jury decision (in MAX " + roundCount + " rounds)");
                victory = true;
            } else {
                System.out.println(b.name + " wins by jury decision (in MAX " + roundCount + " rounds)");
                victory = false;
            }
        }
        
        if (victory) {
            System.out.println(a.name + " has won the match!");
        } else {
            System.out.println(a.name + " has lost the match!");
        }
    }
}
