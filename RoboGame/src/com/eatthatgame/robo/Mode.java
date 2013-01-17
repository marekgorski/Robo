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
        
        Contender winner = contenders.get(0);
        
                for(int i=1; i<contenders.size(); i++) {

                if(contenders.get(i).totalWon >= winner.totalWon) {
                    winner = contenders.get(i);
                } else {
                    // do nothing
                }
        }
        
        return winner;
        // TODO - extend code to include all contenders - DONE
        
    }
}

