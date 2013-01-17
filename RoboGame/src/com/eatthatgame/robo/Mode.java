package com.eatthatgame.robo;

import java.util.ArrayList;

/**
 * This class contains the basics for any Game Mode used in this project
 *
 * @author Mark
 */
public class Mode {
    int currentContenderID;
    int randomContenderID;
    ArrayList<Contender> contenders;
    ArrayList<Contender> opponents;
        
    protected int MAX_ROUNDS = 200;
    protected int roundCount = 0;

    Contender a;
    Contender b;
    
    ArrayList<Team> teams;
    Team team;

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
        teams = new ArrayList<Team>();
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
    * @author Jay
    * @author Hugo
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
    }
 

    /**
    * This Team class allows you to put Contenders into teams
    * it has methods to add team members, get team name
    * return specific members as contenders, return as
    * a String all the team member names and show the size of the team
    * @author Mark
    */
    protected static class Team {

        private ArrayList<Contender> members;
        private String name;
        
        /**
        * This constructor needs to be passed a String with the team name
        */
        public Team(String teamName) {
            name = teamName;
            members = new ArrayList<Contender>();
        }
        
        /**
        * This method allows you to add Contenders as members to the team
        */
        public void add(Contender member) {
            members.add(member);
        }
        
        /**
        * This method returns a String with the team name
        */
        public String getName(){
            return name;
        }
        
        /**
        * This method returns a specific Contender from the members
        * as specified by the integer passed into the method
        */
        public Contender member(int index) {
            // TODO add error handling to make sure the index is within bounds
            return members.get(index);
        }
        
        /**
        * This method returns a String that contains all the names
        * of the team members (Contenders) that are part of this team
        */
        public String show() {
            String s = "";
            int i;
            for(i = 0; i < members.size(); i++) {
                s += members.get(i).name;
                if(i < (members.size()-2)) {
                    s += ", ";
                } else if(i == (members.size()-2)) {
                    s += " and ";
                }
            }
            return s;
        }
        
        /**
        * This method returns an integer that is the count of the team members
        */
        public int size() {
            return members.size();
        }
        
    }
}

