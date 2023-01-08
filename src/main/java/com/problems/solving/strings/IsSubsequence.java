package com.problems.solving.strings;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int innerIndex = 0;
        for (int index = 0; index < t.length(); index++) {
            if (innerIndex == s.length()) {
                break;
            }
            if (s.charAt(innerIndex) == t.charAt(index)) {
                ++innerIndex;
            }
        }
        return innerIndex == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}
