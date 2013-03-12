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
    
    int numOfGroups;
    int numOfContendersPerGroup;
    
    ArrayList<Group> groups;
    Group group;

    /**
    * This constructor populates the contenders with the ArrayList passed into it
    * The constructor stores the list inside of contenders, copies it over to the opponents
    * and sets the index to 0 for the currentContenderID
    *
    * @param contendersList   contains the Contenders sent in as an ArrayListener by the index of the contenders ArrayList
    */
    public Mode(ArrayList<Contender> contendersList) {
        currentContenderID = 0;
        contenders = new ArrayList<Contender>(contendersList);
        opponents = new ArrayList<Contender>(contenders);
        teams = new ArrayList<Team>();
        groups = new ArrayList<Group>();
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
//                    System.out.println("Both attack!");
//                    System.out.println("A hits for: " + a.attack());
//                    System.out.println("B hits for: " + b.attack());
                    b.hit(a.attack());
                    a.hit(b.attack());
                } else {
//                    System.out.println("A attacks and B defends");
//                    System.out.println("A hits for: " + (a.attack()-b.defend()));
                    b.hit(a.attack()-b.defend());
                    a.hit(0);
                }
            } else {
                if(b.attack){
//                    System.out.println("A defends and B attacks");
//                    System.out.println("B hits for: " + (b.attack()-a.defend()));
                    b.hit(0);
                    a.hit(b.attack()-a.defend());
                } else {
                    // both defend only energyCheck runs
                    b.hit(0);
                    a.hit(0);
                }
            }

//            System.out.println(a.name + " health: " + a.getHealth());
//            System.out.println(b.name + " health: " + b.getHealth());
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
                System.out.println("Mutual Annihilation, both contenders are dead after " + roundCount + " rounds");
                a.totalDrawn++;
                b.totalDrawn++;
            }
        } else {
            System.out.println("== Maximum Rounds Reached");
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
    
    /**
    * 
    *
    * @author Hugo
    */

    protected static class Group extends ArrayList{
        
        private ArrayList<Contender> gPlayers;
        private String gNumber;
        private int gSize;
        
        /**
        * This constructor needs to be passed a String, which represents the group number,
        *  the reason for it to be a String is later explained, and finally an integer with the group
        *  size
        */
        public Group(String groupNumber, int groupSize) {
            gNumber = groupNumber;
            gSize = groupSize;
            
            if (gSize == 5){
                gPlayers = new ArrayList<Contender>(5);
            } else if (gSize == 4 ) {
                gPlayers = new ArrayList<Contender>(4);                
            } else if (gSize == 3 ) {
                gPlayers = new ArrayList<Contender>(3);                
            }            
        }
        /**
        * This method allows you to add Contenders as players to the group
        */
        public void add(Contender gPlayer) {
            gPlayers.add(gPlayer);
        }
        
        public void remove(Contender gPlayer) {
            gPlayers.remove(gPlayer);
        }
        
        public void swap(Group reArrangedGroupArray, int contenderSwapIndex1, int contenderSwapIndex2) {
           Object temp = reArrangedGroupArray.get( contenderSwapIndex2 ) ;
           reArrangedGroupArray.set( contenderSwapIndex2, reArrangedGroupArray.get( contenderSwapIndex1 ) ) ; 
           reArrangedGroupArray.set( contenderSwapIndex1, temp ) ; 
        }
        
        /**
        * This method returns a String with the group number
        */
        public String getGNumber(){
            return gNumber;
        }
        
        /**
        * This method returns a specific Contender from the gPlayers
        * as specified by the integer argument passed into the method
        */
        public Contender member(int index) {
            return gPlayers.get(index);
        }
        
        /**
        * This method returns a String that contains all the names
        * of the group gPlayers (Contenders) that are part of this group
        */
        public String showG() {
            
            String s = "";
            int i;
            for(i = 0; i < gPlayers.size(); i++) {
                s += gPlayers.get(i).name;
                if(i < (gPlayers.size()-2)) {
                    s += ", ";
                } else if(i == (gPlayers.size()-2)) {
                    s += " and ";
                }
            }
            return s;
        }
            
    }
}

