package com.eatthatgame.robo;

import java.util.ArrayList;

public class Tournament extends Mode{
    
    ArrayList<ArrayList<Contender>> TournamentGroups = new ArrayList<ArrayList<Contender>>();
    
    public Tournament(ArrayList<Contender> contendersList) {
        super(contendersList);
    }
    
    public void matchUp(){
        
            System.out.println("===================================================");
            System.out.println("==========Tournament Mode Match Up Begins==========");
            System.out.println("===================================================");
        
        if(contenders.isEmpty()) {
            System.out.println("===================================================");
            System.out.println("===================It Has Begun====================");
            System.out.println("===================================================");
        
        }
        
        if (contenders.size()<= 0 ) {
            System.out.println("===================================================");
            System.out.println("==============There Are No Contenders==============");
            System.out.println("===================================================");
            
            
        } else if(contenders.size()>1) {

        }
        
        for(int i=5; i<6 && i>2 ;i--) {
            
            if (contenders.size() % i == 0) {            
                numOfGroups = contenders.size()/i;
                numOfContendersPerGroup = i;
//                System.out.println("i: " + i);
//                System.out.println("numOfContendersPerGroup: " + numOfContendersPerGroup);
//                System.out.println("numOfGroups: " + numOfGroups);
            }
        }
                
        for(int i=0; i<numOfGroups; i++) {
                    
            group = new Group("Group " + i, numOfContendersPerGroup);
            groups.add(group);
                    
                for (int j=0; j<numOfContendersPerGroup; j++) {
                randomContenderID = (int) (Math.random()*contenders.size());
                Contender a = (Contender) contenders.remove(randomContenderID);                       
                        
                (groups.get(i)).add(a);
                }
        }
        System.out.println("\nGroup Overview:");
        
        for(int i=0; i<numOfGroups; i++) {
            System.out.println(groups.get(i).getGNumber() + " : " + (groups.get(i)).show() );
        }
        
        for(int i=0; i<numOfGroups; i++) {
            System.out.println("\n== " + groups.get(i).getGNumber());

            for(int j = 0; j < numOfContendersPerGroup; j++) {
                System.out.println((j+1) + ": " + groups.get(i).member(j).name);
                
//                QUESTION: how can I get the size of the arrayList inside the arrayList if the name I have put its an automatic String?
//                groups.get(i).getGNumber().size()  ,  groups.get(i).gNumber().size
//                  ?? all that getGNumber returns is a string with the name of the arrayList inside the arrayList 
//                     so the computer doesn't acknowledge that I want the arrayList with that name?
            }
        }
    }              
    
}