package com.problems.solving.slidingWindow;

public class MaximumNumberVowelsInSubstring {

    public static boolean isVowel(char c){
        if (c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i' || c == 'A' || c == 'E' || c == 'O' || c == 'U' || c == 'I') {
            return true;
        }
        return false;
    }

    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int lastSubstringVowls = 0;
        for (int i = 0; i < k; i++) {
           if (isVowel(s.charAt(i))) {
               maxVowels++;
               lastSubstringVowls++;
           }
        }
        for (int i = 1; i < s.length() - (k - 1); i++) {
            if (isVowel(s.charAt(i+k-1)) && !isVowel(s.charAt(i-1))) {
            lastSubstringVowls++;
            }
            else if (!isVowel(s.charAt(i+k-1)) && isVowel(s.charAt(i-1))){
              lastSubstringVowls--;
            }
            maxVowels = Math.max(maxVowels, lastSubstringVowls);
        }
        return maxVowels;
    }

    public static void main(String[] args) {

    }
}
