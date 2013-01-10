package com.eatthatgame.robo;

import java.util.ArrayList;

public class LastManStanding {
    int currentContenderID;
    ArrayList<Contender> contenders;
    Contender a;
    Contender b;
    
    public LastManStanding(ArrayList<Contender> contendersList) {
        contenders = new ArrayList<Contender>(contendersList);
    }
    
    public void matchUp() {
        System.out.println("====================================================");
        System.out.println("=======Last Man Standing Mode Match Up Begins=======");
        System.out.println("====================================================");
        currentContenderID = (int) (Math.random()*contenders.size());
        a = (Contender) contenders.remove(currentContenderID); // set to 7 for Yogi Bear
    
        System.out.println("and the winner is: " + a.name);
    }
    
    public void battle(){
        // nothing happens here yet, put in battle mechanic code in here
    }
}
