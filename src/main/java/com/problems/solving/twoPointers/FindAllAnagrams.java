package com.problems.solving.twoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();
        Map<Character, Integer> smallStringMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            if (smallStringMap.containsKey(c)) {
                smallStringMap.put(c, smallStringMap.get(c) + 1);
            } else {
                smallStringMap.put(c, 1);
            }
        }

        for (int outerIndex = 0; outerIndex < s.length(); outerIndex++) {
            Map<Character, Integer> temp = new HashMap<>();
            int currentCharIndex = outerIndex;
            for (int innerIndex = 0; innerIndex < p.length(); innerIndex++) {
                if (currentCharIndex >= s.length()) {
                    break;
                }
                if (!smallStringMap.containsKey(s.charAt(currentCharIndex))) {
                    break;
                }
                if (temp.containsKey(s.charAt(currentCharIndex))) {
                    temp.put(s.charAt(currentCharIndex), temp.get(s.charAt(currentCharIndex)) + 1);
                } else {
                    temp.put(s.charAt(currentCharIndex), 1);
                }
                ++currentCharIndex;
                if (temp.equals(smallStringMap)) {
                    anagrams.add(outerIndex);
                }
            }
        }
        return anagrams;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }
}
