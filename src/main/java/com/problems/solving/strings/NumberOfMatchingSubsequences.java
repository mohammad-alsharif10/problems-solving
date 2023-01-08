package com.problems.solving.strings;

import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubsequences {
    public static int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> sub = new HashMap<>();
        for (String word : words) {
            if (sub.containsKey(word) && sub.get(word) != 0) {
                sub.put(word, sub.get(word) + 1);
                continue;
            } else if (sub.containsKey(word) && sub.get(word) == 0) {
                continue;
            }
            int innerIndex = 0;
            for (int index = 0; index < s.length(); index++) {
                if (innerIndex == word.length()) {
                    break;
                }
                if (word.charAt(innerIndex) == s.charAt(index)) {
                    ++innerIndex;
                }
            }
            if (innerIndex == word.length()) {
                sub.put(word, 1);
            } else {
                sub.put(word, 0);
            }
        }

        return sub.values().stream().reduce(Integer::sum).orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }
}
