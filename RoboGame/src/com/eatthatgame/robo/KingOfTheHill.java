package com.eatthatgame.robo;

import java.util.ArrayList;
import java.util.Arrays;

/**
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
    // Creating two contender lists, one for the main contender and one for the opponents.
    int currentContenderID;
    ArrayList<Contender> contenders;
    ArrayList<Contender> opponents;
    
    //Setting the main contender and its opponent.
    Contender a;
    Contender b;

    public KingOfTheHill(ArrayList<Contender> contendersList) 
    {
        currentContenderID = 0;
        contenders = new ArrayList<Contender>(contendersList);
        opponents = new ArrayList<Contender>(contenders);
    }
    
    public void matchUp()
    {
        // Counting the matches until everyone fights
        int matchUpCount = (contenders.size()*(contenders.size()))+1;
        
        //If there are no more contenders left
        for(int i=matchUpCount; i>0; i--){
            if(currentContenderID>contenders.size()-1) 
            {
                System.out.println("All Contenders have participated");
                for(Contender c : contenders) 
                {        
                    System.out.println(c.name + " : " +
                                       c.totalWon + "W " +
                                       c.totalDrawn + "D " +
                                       c.totalLost + "L " );  
                }                
            } 
            else 
            {
                if(opponents.isEmpty()) 
                {
                    System.out.println("All opponents for " + a.name + " are exhausted");
                    currentContenderID++;
                    opponents = new ArrayList<Contender>(contenders);
                } 
                else 
                {
                    // set the Career fighter
                    a = (Contender) contenders.get(currentContenderID);
                    if(contenders.size() == opponents.size()) 
                    {
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
                }
            }
        }
    }
    
     public void battle() 
     {
        a.setHealth(100);
        b.setHealth(100);
        
        int roundCount = 0;
        int MAX_ROUNDS = 200;
        
        while(a.alive() && b.alive() && roundCount < MAX_ROUNDS) 
        {
            
            roundCount++;
            //System.out.println("Round: " + roundCount);
            
            a.AI();
            b.AI();        
            
            if(a.attack)
            {
                if(b.attack)
                {
                    //System.out.println("Both attack!");
                    //System.out.println("A hits for: " + a.attack());
                    //System.out.println("B hits for: " + b.attack());
                    b.hit(a.attack());
                    a.hit(b.attack());
                } 
                else 
                {
                    //System.out.println("A attacks and B defends");
                    //System.out.println("A hits for: " + (a.attack()-b.defend()));
                    b.hit(a.attack()-b.defend());
                    a.hit(0);
                }
            } 
            else 
            {
                if(b.attack)
                {
                    //System.out.println("A defends and B attacks");
                    //System.out.println("B hits for: " + (b.attack()-a.defend()));
                    b.hit(0);
                    a.hit(b.attack()-a.defend());
                } 
                else 
                {
                    // both defend only energyCheck runs
                    b.hit(0);
                    a.hit(0);
                }
            }

            //System.out.println(a.name + " health: " + a.getHealth());
            //System.out.println(b.name + " health: " + b.getHealth());
        }
        
        if(roundCount < MAX_ROUNDS) 
        {
            if(a.alive()) 
            {
                System.out.println(a.name + " wins by K.O. (in " + roundCount + " rounds)");
                a.totalWon++;
                b.totalLost++;
                System.out.println(a.totalWon);
                
            } 
            else if(b.alive()) 
            {
                System.out.println(b.name + " wins by K.O. (in " + roundCount + " rounds)");
                a.totalLost++;
                b.totalWon++;
                System.out.println(b.totalWon);
            } 
            else 
            {
                System.out.println("Mutual Annihilation, both contenders are dead after " + roundCount + " rounds)");
                a.totalDrawn++;
                b.totalDrawn++;
            }
        } 
        else 
        {
            System.out.println("=======MAX Rounds Reached=======");
            if(a.getHealth() > b.getHealth()) {
                System.out.println(a.name + " wins by jury decision (in MAX " + roundCount + " rounds)");
                a.totalWon++;
                b.totalLost++;
            } 
            else 
            {
                System.out.println(b.name + " wins by jury decision (in MAX " + roundCount + " rounds)");
                a.totalLost++;
                b.totalWon++;
            }
        }   
    }
}
