package com.eatthatgame.robo;

import java.util.ArrayList;

public class LastManStanding {
    public LastManStanding(ArrayList contenders) {
        int randomContenderID;
        randomContenderID = (int) (Math.random()*contenders.size());
        Contender a = (Contender) contenders.remove(randomContenderID); // set to 7 for Yogi Bear
    
        
        System.out.println("Winner is A: " + a.name);

    }
}
