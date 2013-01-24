package com.eatthatgame.examples;

/*
 * to test just this file, right click on the Projects panel in Netbeans
 * and select "Run File" from the options - or press Shift-F6
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

public class ArrayExamples {

    public static void main(String[] args) {
        simpleArrayOutput();
        //simpleArrayForEachOutput();
        //arrayListOutput();
        //arrayListForLoopOutput();
        //arrayListIteratorOutput();
        //hashMapSimpleOutput();
        //hashMapIteratorOutput();
    }
    
    public static void simpleArrayOutput() {
        int[] a = {3,6,9};
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
    }
    
    public static void simpleArrayForEachOutput() {
        int[] a = {3,6,9,12,15,18,21};
        for(int i : a) {
            System.out.println(i);
        }
    }

    private static void arrayListOutput() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Mark");
        names.add("Tom");
        names.add("Hugo");
        names.remove(0);
        System.out.println(names);
    }
    
    private static void arrayListForLoopOutput() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Mark");
        names.add("Tom");
        //names.add("Yogi Bear");
        //names.remove("Mark");
        for(int i = 0; i < names.size(); i++) {
            System.out.println("Contender " + (i+1) + ": " + names.get(i));
        }

    }
    
    private static void arrayListIteratorOutput() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Mark");
        names.add("Tom");
        names.add("Yogi Bear");
        names.add("Boo Boo");
        ListIterator<String> nameIterator = names.listIterator();
        while(nameIterator.hasNext()) {
            String value = nameIterator.next();
            System.out.println(value);
        }
    }
    
    private static void hashMapSimpleOutput() {
        HashMap<String, String> australia = new HashMap<String, String>();
        australia.put("NSW","Sydney");
        australia.put("VIC","Melbourne");
        australia.put("QLD","Brisbane");
        System.out.println(australia);
    }
    
    private static void hashMapIteratorOutput() {
        HashMap<String, String> australia = new HashMap<String, String>();
        australia.put("NSW","Sydney");
        australia.put("VIC","Melbourne");
        australia.put("QLD","Brisbane");
        //System.out.println(australia);
        
        Set<String> keys = australia.keySet();
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value + " capital city is " + australia.get(value));
        }
        
    }


    
}
