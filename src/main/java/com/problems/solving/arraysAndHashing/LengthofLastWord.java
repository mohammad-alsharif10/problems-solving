package com.problems.solving.arraysAndHashing;

public class LengthofLastWord {


    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean foundChar = false;
        for (int index = s.length() - 1; index >= 0; index--) {
            if (s.charAt(index) == ' ' && foundChar) {
                break;
            }
            if (s.charAt(index) != ' ') {
                foundChar = true;
                ++length;
            }
        }
        return length;
    }
}
