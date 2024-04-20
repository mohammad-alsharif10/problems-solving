package com.problems.solving.arraysAndHashing;

public class MergeStringsAlternately {

    public static String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        String merged = "";
        while (i < word1.length() && j < word2.length()) {
            merged = merged + word1.charAt(i) + word2.charAt(j);
            j++;
            i++;
        }
        merged=merged+word1.substring(i);
        merged=merged+word2.substring(j);
        return merged;
    }

    public static void main(String[] args) {

    }
}
