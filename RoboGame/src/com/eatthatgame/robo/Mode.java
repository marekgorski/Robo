package com.eatthatgame.robo;

import java.util.ArrayList;

/**
 * This class contains the basics for any Game Mode used in this project
 *
 * @author Mark
 */
public class Mode {
    int currentContenderID;
    ArrayList<Contender> contenders;
    ArrayList<Contender> opponents;

    Contender a;
    Contender b;
    
    protected int roundCount = 0;
    protected int MAX_ROUNDS = 200;
    
    /**
    * This constructor populates the contenders with the ArrayList passed into it
    * The constructor stores the list inside of contenders, copies it over to the opponents
    * and sets the index to 0 for the currentContenderID
    *
    * @param contendersList   contains the Contenders sent in as an ArrayListntender by the index of the contenders ArrayList
    */
    public Mode(ArrayList<Contender> contendersList) {
        currentContenderID = 0;
        contenders = new ArrayList<Contender>(contendersList);
        opponents = new ArrayList<Contender>(contenders);
    }

    /**
    * This method should contain the rules of the mode
    * it should outline who fights who in what order and under
    * what conditions
    */
    public void matchUp() {
        System.out.println("=========================================");
        System.out.println("======Mode Match Up Method Undefined=====");
        System.out.println("=========================================");
    }
    
    /**
    * This method should be run inside of the matchUp method
    * each "battle" would ideally be taking place in a round
    * which the matchUp method should keep track of
    */
    public void battle() {
        System.out.println("=========================================");
        System.out.println("======Mode Battle Method Undefined=======");
        System.out.println("=========================================");
    }
    
    /**
    * This method returns the winning Contender
    * it checks the totalWon values that each Contender has
    * based on which it selects the Contender with the highest value
    */
    public Contender getWinner() {
        
        Contender winner;
        Contender c00 = contenders.get(0);
        Contender c01 = contenders.get(1);
        Contender c02 = contenders.get(2);
        Contender c03 = contenders.get(3);

       
        if(c00.totalWon > c01.totalWon) {
            winner = c00;
        } else {
            winner = c01;
        }
        
        if(winner.totalWon > c02.totalWon) {
            // winner doesn't change
        } else {
            winner = c02;
        }
        
        if(winner.totalWon > c03.totalWon) {
            // winner doesn't change
        } else {
            winner = c03;
        }
        
        // TODO - extend code to include all contenders
        
        return winner;
    }
}
