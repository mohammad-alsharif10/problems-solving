package com.problems.solving.arraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> firstWord = new HashMap<>();
        Map<Character, Integer> secondWord = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            Integer value1 = firstWord.get(s.charAt(index));
            if (value1 == null) {
                firstWord.put(s.charAt(index), 1);
            } else {
                firstWord.put(s.charAt(index), ++value1);
            }
            Integer value2 = secondWord.get(t.charAt(index));
            if (value2 == null) {
                secondWord.put(t.charAt(index), 1);
            } else {
                secondWord.put(t.charAt(index), ++value2);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!secondWord.containsKey(s.charAt(i))) {
                return false;
            }
            Integer occurence1 = firstWord.get(s.charAt(0));
            Integer occurence2 = secondWord.get(s.charAt(0));
            if (occurence2 != occurence1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram1(String s, String t) {
        int[] chars = new int[26];
        for (char current : s.toCharArray()) {
            chars[current - 'a']++;
        }
        for (char current : t.toCharArray()) {
            chars[current - 'a']--;
        }
        for (int current : chars) {
            if (current != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isAnagram1("anagram", "naamarg");
    }
}
