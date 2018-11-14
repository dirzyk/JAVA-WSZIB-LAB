package com.mag.kata.bankocr;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Digit {

    private static final Map<String, Integer> digitMap = createDigitMap();
    
    private static Map<String, Integer> createDigitMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put(" _ " +
                "| |" +
                "|_|", 0);
        map.put("   " +
                "  |" +
                "  |", 1);
        map.put(" _ " +
                " _|" + 
                "|_ ", 2);
        map.put(" _ " + 
                " _|" + 
                " _|", 3);
        map.put("   " + 
                "|_|" + 
                "  |", 4);
        map.put(" _ " + 
                "|_ " + 
                " _|", 5);
        map.put(" _ " + 
                "|_ " + 
                "|_|", 6);
        map.put(" _ " + 
                "  |" + 
                "  |", 7);
        map.put(" _ " + 
                "|_|" + 
                "|_|", 8);
        map.put(" _ " + 
                "|_|" + 
                " _|", 9);
        return map;
    }
    
    public static Optional<Integer> get(String digitPattern) {
        return digitMap.containsKey(digitPattern) ? Optional.of(digitMap.get(digitPattern)) : Optional.empty();
    }
    
}
